package org.sponsor.account.mapper;

import static org.sponsor.account.constants.Constants.MAPPER_IMPL;
import static org.sponsor.account.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.sponsor.account.entities.EOUserFinancialBankAccount;
import org.sponsor.account.model.UIUserFinancialBankAccount;

@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL)
public interface UserFinancialBankAccountMapper extends GenericMapper<EOUserFinancialBankAccount, UIUserFinancialBankAccount> {
   
}
