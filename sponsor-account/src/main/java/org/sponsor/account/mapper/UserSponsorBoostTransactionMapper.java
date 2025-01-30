package org.sponsor.account.mapper;

import static org.sponsor.account.constants.Constants.MAPPER_IMPL;
import static org.sponsor.account.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sponsor.account.entities.EOUserSponsorBoostTransaction;
import org.sponsor.account.model.UIUserSponsorBoostTransaction;

@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL)
public interface UserSponsorBoostTransactionMapper extends GenericMapper<EOUserSponsorBoostTransaction, UIUserSponsorBoostTransaction> {

	@Override
	@Mapping(source = "investTransaction.amount", target = "investAmount")
	@Mapping(source = "investTransaction.trsDate", target = "investDate")
	@Mapping(source = "returnTransaction.amount", target = "returnAmount")
	@Mapping(source = "returnTransaction.trsDate", target = "returnDate")
	@Mapping(source = "userSponsor.sponsorId", target = "sponsorId")
	UIUserSponsorBoostTransaction mapToDTO(EOUserSponsorBoostTransaction entityObject) ;
}
