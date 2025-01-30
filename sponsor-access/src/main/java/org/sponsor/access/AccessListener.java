package org.sponsor.access;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.brijframework.integration.json.schema.data.factories.JsonSchemaDataFactory;
import org.sponsor.access.constants.Authority;
import org.sponsor.access.entities.EOUserAccount;
import org.sponsor.access.entities.EOUserProfile;
import org.sponsor.access.entities.EOUserRole;
import org.sponsor.access.repository.UserAccountRepository;
import org.sponsor.access.repository.UserProfileRepository;
import org.sponsor.access.repository.UserRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AccessListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Value("${spring.db.datajson.upload}")
	boolean upload;
	
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
    	if(upload) {
    		Map<Integer, EOUserRole> userRoleMap = userRoleRepository.findAll().parallelStream().collect(Collectors.toMap(EOUserRole::getPosition, Function.identity()));
        	Map<String, EOUserAccount> userAccountMap = userAccountRepository.findAll().parallelStream().collect(Collectors.toMap(EOUserAccount::getUsername, Function.identity()));
	    	JsonSchemaDataFactory instance = JsonSchemaDataFactory.getInstance();
	    	List<EOUserRole> userRoleList = instance.getAll(EOUserRole.class);
	    	for (EOUserRole userRole : userRoleList) {
	    		EOUserRole eoUserRole = userRoleMap.getOrDefault(userRole.getPosition(),userRole);
	    		BeanUtils.copyProperties(userRole, eoUserRole, "id");
	    		EOUserRole saveUserRole=userRoleRepository.save(eoUserRole);
	    		userRole.setId(saveUserRole.getId());
	    		userRoleMap.put(userRole.getPosition(), userRole);
	    		if(Authority.ADMIN.getRoleType().equalsIgnoreCase(userRole.getRoleType())) {
	    			EOUserAccount eoUserAccount = userAccountMap.getOrDefault(eoUserRole.getRoleName(), new EOUserAccount());
    	    		eoUserAccount.setAccountName(eoUserRole.getRoleName());
    	    		eoUserAccount.setUsername(eoUserRole.getRoleName());
	    			eoUserAccount.setPassword(passwordEncoder.encode(eoUserRole.getRoleName()));
    	    		eoUserAccount.setUserRole(eoUserRole);
    	    		eoUserAccount=userAccountRepository.saveAndFlush(eoUserAccount);
    	    		Optional<EOUserProfile> findUserProfile = userProfileRepository.findByUserAccountId(eoUserAccount.getId());
    	    		if(!findUserProfile.isPresent()) {
	    	    		EOUserProfile eoUserProfile=   new EOUserProfile();
	    	    		eoUserProfile.setFullName(eoUserRole.getRoleName());
	    	    		eoUserProfile.setUserAccount(eoUserAccount);
	    	    		userProfileRepository.saveAndFlush(eoUserProfile);
    	    		}else {
    	    			EOUserProfile eoUserProfile=   findUserProfile.get();
	    	    		eoUserProfile.setFullName(eoUserRole.getRoleName());
	    	    		eoUserProfile.setUserAccount(eoUserAccount);
	    	    		userProfileRepository.saveAndFlush(eoUserProfile);
    	    		}
	    		}
	    	}
    	}
    }

}