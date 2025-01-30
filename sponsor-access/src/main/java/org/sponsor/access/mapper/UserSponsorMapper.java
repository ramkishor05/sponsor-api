package org.sponsor.access.mapper;

import static org.sponsor.access.constants.Constants.MAPPER_IMPL;
import static org.sponsor.access.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sponsor.access.entities.EOUserSponsor;
import org.sponsor.access.model.UIUserSponsor;

@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL, uses = {UserSponsorActivityMapper.class})
public interface UserSponsorMapper extends GenericMapper<EOUserSponsor, UIUserSponsor> {

	@Override
	@Mapping(source = "userAccount.id" , target  = "userAccountId")
	@Mapping(source = "activity.status" , target  = "status")
	UIUserSponsor mapToDTO(EOUserSponsor entityObject) ;
	
	@Override
	@Mapping(target  = "userAccount.id" , source  = "userAccountId")
	EOUserSponsor mapToDAO(UIUserSponsor entityObject) ;
}
