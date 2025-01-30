package org.sponsor.account.mapper;

import static org.sponsor.account.constants.Constants.MAPPER_IMPL;
import static org.sponsor.account.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.model.UIUserSponsorModel;

@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL)
public interface UserSponsorMapper extends GenericMapper<EOUserSponsor, UIUserSponsorModel> {

	@Override
	@Mapping(source = "sponsorLeader.sponsorId", target = "sponsorLeaderId")
	@Mapping(source = "sponsorLeader.fullName", target = "sponsorLeaderName")
	UIUserSponsorModel mapToDTO(EOUserSponsor entityObject);
	
	
}
