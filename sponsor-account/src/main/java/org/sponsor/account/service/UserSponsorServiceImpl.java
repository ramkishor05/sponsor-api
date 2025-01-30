package org.sponsor.account.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.brijframework.integration.spring.rest.context.ApiTokenContext;
import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.constants.BoostStatus;
import org.sponsor.account.constants.SponsorStatus;
import org.sponsor.account.entities.EOUserFinancialWallet;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.exceptions.UserAlreadyExistsException;
import org.sponsor.account.exceptions.UserNotFoundException;
import org.sponsor.account.forgin.repository.UserClient;
import org.sponsor.account.mapper.UserSponsorMapper;
import org.sponsor.account.model.UIUserSponsorModel;
import org.sponsor.account.model.UIUserSponsorTreeModel;
import org.sponsor.account.repository.UserSponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class UserSponsorServiceImpl extends CrudServiceImpl<UIUserSponsorModel, EOUserSponsor, Long>  implements UserSponsorService {

	@Autowired
	private UserSponsorRepository userSponsorRepository;
	
	@Autowired
	private UserSponsorEntryTransactionService userSponsorEntryTransactionService;
	
	@Autowired
	private UserSponsorLinkTransactionService userSponsorLinkTransactionService;
	
	@Autowired
	private UserSponsorProductTransactionService userSponsorProductTransactionService;
	
	@Autowired
	private UserSponsorLevelTransactionService userSponsorLevelTransactionService;
	
	@Autowired
	private UserSponsorBoostTransactionService userSponsorBoostTransactionService;
	
	@Autowired
	private UserSponsorMapper userSponsorMapper;
	
	@Autowired
	private UserClient userClient;

	@Autowired
	private UserFinancialWalletService userWalletService;
	
	@Override
	public JpaRepository<EOUserSponsor, Long> getRepository() {
		return userSponsorRepository;
	}

	@Override
	public GenericMapper<EOUserSponsor, UIUserSponsorModel> getMapper() {
		return userSponsorMapper;
	}
	
	@Override
	public void preAdd(UIUserSponsorModel data) {
		Optional<EOUserSponsor> find = userSponsorRepository.findByUserAccountId(data.getUserAccountId());
		if(find.isPresent()) {
			throw new UserAlreadyExistsException("Sponsor already exists in system");
		}
	}
	
	@Override
	public void preAdd(UIUserSponsorModel data, EOUserSponsor entity) {
		Long sponsorId=userSponsorRepository.nextSponsorId()+1;
		data.setLevel(0l);
		data.setSponsorId(sponsorId);
		entity.setLevel(0l);
		entity.setSponsorId(sponsorId);
		EOUserSponsor sponsorLeader = userSponsorRepository.findOneBySponsorId(data.getSponsorLeaderId());
		if(sponsorLeader==null) {
			throw new UserNotFoundException("Invalid SponsorLeaderId");
		}
		entity.setSponsorLeader(sponsorLeader);
		entity.setSponsorBussiness(sponsorLeader.getSponsorBussiness());
	}
	
	@Override
	public void postAdd(UIUserSponsorModel data, EOUserSponsor entity) {
		EOUserSponsor sponsorLeader = entity.getSponsorLeader();
		userSponsorEntryTransactionService.addUserSponsorEntryTransaction(entity, data.getUtrNumber(), data.getTransactionReceipt());
		userSponsorLinkTransactionService.addUserSponsorLinkTransaction(entity, data.getUtrNumber(), data.getTransactionReceipt());
		userSponsorProductTransactionService.addUserSponsorProductTransaction(entity, data.getUtrNumber(), data.getTransactionReceipt());
		userSponsorLevelTransactionService.fillLevel(sponsorLeader);
	}
	
	@Override
	public void postFetch(EOUserSponsor findObject, UIUserSponsorModel dtoObject) {
		EOUserFinancialWallet userFinancialWallet = userWalletService.getUserFinancialWallet(findObject);
		dtoObject.setSponsorIncome(userFinancialWallet.getSponsorIncome());
		dtoObject.setLevelIncome(userFinancialWallet.getLevelIncome());
		dtoObject.setRoyaltyIncome(userFinancialWallet.getRoyaltyIncome());
		dtoObject.setBoostPending(userSponsorBoostTransactionService.existsByUserSponsorIdAndStatus(findObject.getId(), BoostStatus.Inprocess.toString()));
		dtoObject.setBoostIncome(userFinancialWallet.getBoostIncome());
		userSponsorLinkTransactionService.fillTransactionDetail(findObject.getId(), dtoObject);
		userClient.doUserDetail(findObject.getUserAccountId()).onSuccess(userDetail->{
			dtoObject.setFullName(userDetail.getAccountName());
			dtoObject.setRegisteredEmail(userDetail.getRegisteredEmail());
		});
		dtoObject.setApplicableBoost( !dtoObject.getBoostPending() && userSponsorRepository.countSponsors(dtoObject.getSponsorId())>=2 && (dtoObject.getSponsorIncome()-dtoObject.getBoostIncome())>=250 );
	}

	@Override
	public List<UIUserSponsorModel> findAllByCurrent(Map<String, List<String>> headers) {
		List<EOUserSponsor> list = repositoryFindAll(headers, null);
		return postFetch(list);
	}
	
	@Override
	public List<EOUserSponsor> repositoryFindAll(Map<String, List<String>> headers, Map<String, Object> filters) {
		Long sponsorId = getSponsorId(headers);
		if(sponsorId!=null && !sponsorId.equals(0l)) {
			return  findAllByCurrentSponsorId(sponsorId);
		} else {
			Long userId = Long.valueOf(ApiTokenContext.getContext().getUserId());
			return findAllByCurrentUserId(userId);
		}
	}

	private Long getSponsorId(Map<String, List<String>> headers) {
		if(headers==null) {
			return null;
		}
		List<String> sponsorIds = headers.getOrDefault("sponsorid", Arrays.asList());
		Long sponsorId = null;
		if(!CollectionUtils.isEmpty(sponsorIds)) {
			try {
				sponsorId=Long.valueOf(sponsorIds.get(0));
			}catch (Exception e) {
			}
		}
		return sponsorId;
	}
	
	private List<EOUserSponsor> findAllByCurrentUserId(Long id) {
		List<EOUserSponsor> list=new ArrayList<EOUserSponsor>();
		EOUserSponsor eoUserSponsor = userSponsorRepository.findOneByUserId(id);
		if(eoUserSponsor!=null) {
			list.add(eoUserSponsor);
			list.addAll(getChildSponsors(eoUserSponsor.getSponsorId()));
		}
		return list;
	}
	
	private List<EOUserSponsor> findAllByCurrentSponsorId(Long id) {
		List<EOUserSponsor> list=new ArrayList<EOUserSponsor>();
		EOUserSponsor eoUserSponsor = userSponsorRepository.findOneBySponsorId(id);
		if(eoUserSponsor!=null) {
			list.add(eoUserSponsor);
			list.addAll(getChildSponsors(eoUserSponsor.getSponsorId()));
		}
		return list;
	}
	
	private List<EOUserSponsor> getChildSponsors(Long sponsorId) {
		List<EOUserSponsor> list=new ArrayList<EOUserSponsor>();
		List<EOUserSponsor> childSponsors = userSponsorRepository.getChildSponsors(sponsorId);
		if(CollectionUtils.isEmpty(childSponsors)) {
			return list;
		}
		list.addAll(childSponsors);
		for(EOUserSponsor userSponsor: childSponsors) {
			list.addAll(getChildSponsors(userSponsor.getSponsorId()));
		}
		return list;
	}
	
	@Override
	public UIUserSponsorTreeModel fetchTree(Map<String, List<String>> headers) {
		UIUserSponsorModel userSponsor = fetchCurrent(headers);
		if(userSponsor==null) {
			return null;
		}
		fillChildSponsors(userSponsor);
		return buildTree(userSponsor, false);
	}
	
	private UIUserSponsorTreeModel buildTree(UIUserSponsorModel userSponsor, boolean parent) {
		if(userSponsor==null) {
			return null;
		}
		UIUserSponsorTreeModel userSponsorTree=new UIUserSponsorTreeModel();
		userSponsorTree.setId(userSponsor.getId());
		if(parent) {
			return userSponsorTree;
		}
		userSponsorTree.setName(userSponsor.getSponsorId()+"");
		userSponsorTree.getAttributes().put("Name", userSponsor.getFullName());
		userSponsorTree.getAttributes().put("Level", userSponsor.getLevelNumber());
		userSponsorTree.getAttributes().put("Income", userSponsor.getBoostIncome()+userSponsor.getLevelIncome()+userSponsor.getSponsorIncome());
		userSponsorTree.setParent(buildTree(userSponsor.getParent(), true));
		userSponsorTree.setChildren(userSponsor.getChildren().stream().map(child->buildTree(child, false)).toList());
		return userSponsorTree;
	}

	private void fillChildSponsors(UIUserSponsorModel sponsor) {
		List<EOUserSponsor> childSponsors = userSponsorRepository.getChildSponsors(sponsor.getSponsorId());
		for(EOUserSponsor childSponsor: childSponsors) {
			UIUserSponsorModel uiChildSponsor=getMapper().mapToDTO(childSponsor);
			uiChildSponsor.setParent(sponsor);
			postFetch(childSponsor, uiChildSponsor);
			sponsor.getChildren().add(uiChildSponsor);
			fillChildSponsors(uiChildSponsor);
		}
	}
	
	@Override
	public UIUserSponsorModel fetchCurrent(Map<String, List<String>> headers) {
		EOUserSponsor eoUserSponsor = getCurrentSponsor(headers);
		if(eoUserSponsor==null) {
			return null;
		}
		UIUserSponsorModel userSponsor = getMapper().mapToDTO(eoUserSponsor);
		postFetch(eoUserSponsor, userSponsor);
		userSponsor.setWallet(userWalletService.getUserFinancialWalletModel(eoUserSponsor));;
		return userSponsor;
	}
	
	
	@Override
	public EOUserSponsor getCurrentSponsor(Map<String, List<String>> headers) {
		Long sponsorId = getSponsorId(headers);
		if(sponsorId!=null && !sponsorId.equals(0l)) {
			return  userSponsorRepository.findOneBySponsorId(sponsorId);
		} else {
			Long userId = Long.valueOf(ApiTokenContext.getContext().getUserId());
			return  userSponsorRepository.findOneByUserId(userId);
		}
	}
	
	@Override
	public EOUserSponsor findSponsor(Long sponsorId) {
		return userSponsorRepository.findOneBySponsorId(sponsorId);
	}
	
	@Override
	public boolean changeStatus(Long sponsorId,SponsorStatus sponsorStatus){
		EOUserSponsor findSponsor = findSponsor(sponsorId);
		findSponsor.setStatus(sponsorStatus.toString());
		userSponsorRepository.saveAndFlush(findSponsor);
		return true;
	}
	
	@Override
	public boolean existsByUtrNumber(String utrNumber) {
		return userSponsorRepository.existsByUtrNumber(utrNumber);
	}
}
