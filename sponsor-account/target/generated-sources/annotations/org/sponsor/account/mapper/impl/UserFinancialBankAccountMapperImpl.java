package org.sponsor.account.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOUserFinancialBankAccount;
import org.sponsor.account.mapper.UserFinancialBankAccountMapper;
import org.sponsor.account.model.UIUserFinancialBankAccount;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:33+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserFinancialBankAccountMapperImpl implements UserFinancialBankAccountMapper {

    @Override
    public UIUserFinancialBankAccount mapToDTO(EOUserFinancialBankAccount entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserFinancialBankAccount uIUserFinancialBankAccount = new UIUserFinancialBankAccount();

        uIUserFinancialBankAccount.setId( entityObject.getId() );
        uIUserFinancialBankAccount.setOrderSequence( entityObject.getOrderSequence() );
        uIUserFinancialBankAccount.setBankName( entityObject.getBankName() );
        uIUserFinancialBankAccount.setAccountHolder( entityObject.getAccountHolder() );
        uIUserFinancialBankAccount.setAccountNumber( entityObject.getAccountNumber() );
        uIUserFinancialBankAccount.setIfsc( entityObject.getIfsc() );

        return uIUserFinancialBankAccount;
    }

    @Override
    public EOUserFinancialBankAccount mapToDAO(UIUserFinancialBankAccount dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOUserFinancialBankAccount eOUserFinancialBankAccount = new EOUserFinancialBankAccount();

        eOUserFinancialBankAccount.setId( dtoObject.getId() );
        eOUserFinancialBankAccount.setOrderSequence( dtoObject.getOrderSequence() );
        eOUserFinancialBankAccount.setBankName( dtoObject.getBankName() );
        eOUserFinancialBankAccount.setAccountHolder( dtoObject.getAccountHolder() );
        eOUserFinancialBankAccount.setAccountNumber( dtoObject.getAccountNumber() );
        eOUserFinancialBankAccount.setIfsc( dtoObject.getIfsc() );

        return eOUserFinancialBankAccount;
    }

    @Override
    public List<EOUserFinancialBankAccount> mapToDAO(List<UIUserFinancialBankAccount> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserFinancialBankAccount> list = new ArrayList<EOUserFinancialBankAccount>( dtoObjectList.size() );
        for ( UIUserFinancialBankAccount uIUserFinancialBankAccount : dtoObjectList ) {
            list.add( mapToDAO( uIUserFinancialBankAccount ) );
        }

        return list;
    }

    @Override
    public List<UIUserFinancialBankAccount> mapToDTO(List<EOUserFinancialBankAccount> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserFinancialBankAccount> list = new ArrayList<UIUserFinancialBankAccount>( entityObjectList.size() );
        for ( EOUserFinancialBankAccount eOUserFinancialBankAccount : entityObjectList ) {
            list.add( mapToDTO( eOUserFinancialBankAccount ) );
        }

        return list;
    }
}
