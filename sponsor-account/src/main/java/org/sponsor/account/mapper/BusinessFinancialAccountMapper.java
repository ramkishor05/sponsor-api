package org.sponsor.account.mapper;

import static org.sponsor.account.constants.Constants.MAPPER_IMPL;
import static org.sponsor.account.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sponsor.account.entities.EOBusinessFinancialAccount;
import org.sponsor.account.model.UIBusinessFinancialAccount;

@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL)
public interface BusinessFinancialAccountMapper extends GenericMapper<EOBusinessFinancialAccount, UIBusinessFinancialAccount> {

	@Override
	@Mapping(target = "bankUpi", ignore = true)
	@Mapping(target = "bankAccount", ignore = true)
	@Mapping(target = "bussinessSponsor.id", source = "bussinessSponsorId")
	EOBusinessFinancialAccount mapToDAO(UIBusinessFinancialAccount dtoObject) ;
	
	@Override
	@Mapping(target = "bussinessSponsorId", source = "bussinessSponsor.id")
	UIBusinessFinancialAccount mapToDTO(EOBusinessFinancialAccount entityObject);
}
