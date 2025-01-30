package org.sponsor.access.service;

import java.util.Optional;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.access.entities.EOUserSponsor;
import org.sponsor.access.entities.EOUserSponsorActivity;
import org.sponsor.access.mapper.UserSponsorActivityMapper;
import org.sponsor.access.model.UIUserSponsorActivity;
import org.sponsor.access.repository.UserSponsorActivityRepository;
import org.sponsor.access.repository.UserSponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSponsorActivityServiceImpl extends CrudServiceImpl<UIUserSponsorActivity, EOUserSponsorActivity, Long> implements UserSponsorActivityService {
	
	@Autowired
	private UserSponsorActivityRepository userSponsorActivityRepository;
	
	@Autowired
	private UserSponsorActivityMapper userSponsorActivityMapper;
	
	@Autowired
	private UserSponsorRepository userSponsorRepository;

	@Override
	public JpaRepository<EOUserSponsorActivity, Long> getRepository() {
		return userSponsorActivityRepository;
	}

	@Override
	public GenericMapper<EOUserSponsorActivity, UIUserSponsorActivity> getMapper() {
		return userSponsorActivityMapper;
	}
	
	@Override
	public void postAdd(UIUserSponsorActivity data, EOUserSponsorActivity entity) {
		Optional<EOUserSponsor> find = userSponsorRepository.findById(data.getUserSponsorId());
		find.ifPresent(userSponsor->{
			userSponsor.setActivity(entity);
			userSponsorRepository.saveAndFlush(userSponsor);
		});
	}
	
}
