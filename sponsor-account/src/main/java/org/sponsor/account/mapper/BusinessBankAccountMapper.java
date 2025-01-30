package org.sponsor.account.mapper;

import static org.sponsor.account.constants.Constants.MAPPER_IMPL;
import static org.sponsor.account.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.sponsor.account.entities.EOBusinessFinancialBankAccount;
import org.sponsor.account.model.UIBusinessBankAccount;

@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL)
public interface BusinessBankAccountMapper extends GenericMapper<EOBusinessFinancialBankAccount, UIBusinessBankAccount> {

}
