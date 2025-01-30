package org.sponsor.account.mapper;

import static org.sponsor.account.constants.Constants.MAPPER_IMPL;
import static org.sponsor.account.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sponsor.account.entities.EOUserSponsorRoyaltyTransaction;
import org.sponsor.account.model.UIUserSponsorRoyaltyTransaction;

@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL)
public interface UserSponsorRoyaltyTransactionMapper extends GenericMapper<EOUserSponsorRoyaltyTransaction, UIUserSponsorRoyaltyTransaction> {

	@Override
	@Mapping(source = "userWalletTransaction.amount", target = "amount")
	@Mapping(source = "userSponsor.sponsorId", target = "sponsorId")
	UIUserSponsorRoyaltyTransaction mapToDTO(EOUserSponsorRoyaltyTransaction entityObject) ;
}
