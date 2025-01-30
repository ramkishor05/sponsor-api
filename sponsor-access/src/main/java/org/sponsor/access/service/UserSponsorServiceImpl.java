package org.sponsor.access.service;

import java.util.Map;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.access.entities.EOUserSponsor;
import org.sponsor.access.mapper.UserSponsorMapper;
import org.sponsor.access.model.UIUserSponsor;
import org.sponsor.access.repository.UserSponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class UserSponsorServiceImpl extends CrudServiceImpl<UIUserSponsor, EOUserSponsor, Long> implements UserSponsorService {
	
	@Autowired
	private UserSponsorRepository userSponsorRepository;
	
	@Autowired
	private UserSponsorMapper userSponsorMapper;

	@Override
	public JpaRepository<EOUserSponsor, Long> getRepository() {
		return userSponsorRepository;
	}

	@Override
	public GenericMapper<EOUserSponsor, UIUserSponsor> getMapper() {
		return userSponsorMapper;
	}

	@Override
	public UIUserSponsor findByUserAccountId(Long userAccountId, MultiValueMap<String, String> headers,
			Map<String, Object> filters, Map<String, Object> actions) {
		return userSponsorMapper.mapToDTO(userSponsorRepository.findByUserAccountId(userAccountId).orElse(null));
	}

	@Override
	public boolean existsByUtrNumber(String utrNumber) {
		// TODO Auto-generated method stub
		return userSponsorRepository.existsByUtrNumber(utrNumber);
	}

}
