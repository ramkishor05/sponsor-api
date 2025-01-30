package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.model.UIBusinessSponsorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessSponsorServiceImpl extends CrudServiceImpl<UIBusinessSponsorModel, EOBusinessSponsor, Long> implements BusinessSponsorService {

	@Override
	public JpaRepository<EOBusinessSponsor, Long> getRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericMapper<EOBusinessSponsor, UIBusinessSponsorModel> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
