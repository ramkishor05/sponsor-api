package org.sponsor.access.mapper;

import static org.sponsor.access.constants.Constants.MAPPER_IMPL;
import static org.sponsor.access.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sponsor.access.entities.EOUserSponsorActivity;
import org.sponsor.access.model.UIUserSponsorActivity;

@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL)
public interface UserSponsorActivityMapper extends GenericMapper<EOUserSponsorActivity, UIUserSponsorActivity> {

	@Override
	@Mapping(source = "userSponsor.id" , target  = "userSponsorId")
	UIUserSponsorActivity mapToDTO(EOUserSponsorActivity entityObject) ;
	
	@Override
	@Mapping(target  = "userSponsor.id" , source  = "userSponsorId")
	EOUserSponsorActivity mapToDAO(UIUserSponsorActivity entityObject) ;
}
