package org.sponsor.account.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOBusinessFinancialBankAccount;
import org.sponsor.account.mapper.BusinessBankAccountMapper;
import org.sponsor.account.model.UIBusinessBankAccount;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:34+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class BusinessBankAccountMapperImpl implements BusinessBankAccountMapper {

    @Override
    public UIBusinessBankAccount mapToDTO(EOBusinessFinancialBankAccount entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIBusinessBankAccount uIBusinessBankAccount = new UIBusinessBankAccount();

        uIBusinessBankAccount.setId( entityObject.getId() );
        uIBusinessBankAccount.setOrderSequence( entityObject.getOrderSequence() );
        uIBusinessBankAccount.setBankName( entityObject.getBankName() );
        uIBusinessBankAccount.setAccountHolder( entityObject.getAccountHolder() );
        uIBusinessBankAccount.setAccountNumber( entityObject.getAccountNumber() );
        uIBusinessBankAccount.setIfsc( entityObject.getIfsc() );

        return uIBusinessBankAccount;
    }

    @Override
    public EOBusinessFinancialBankAccount mapToDAO(UIBusinessBankAccount dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOBusinessFinancialBankAccount eOBusinessFinancialBankAccount = new EOBusinessFinancialBankAccount();

        eOBusinessFinancialBankAccount.setId( dtoObject.getId() );
        eOBusinessFinancialBankAccount.setOrderSequence( dtoObject.getOrderSequence() );
        eOBusinessFinancialBankAccount.setBankName( dtoObject.getBankName() );
        eOBusinessFinancialBankAccount.setAccountHolder( dtoObject.getAccountHolder() );
        eOBusinessFinancialBankAccount.setAccountNumber( dtoObject.getAccountNumber() );
        eOBusinessFinancialBankAccount.setIfsc( dtoObject.getIfsc() );

        return eOBusinessFinancialBankAccount;
    }

    @Override
    public List<EOBusinessFinancialBankAccount> mapToDAO(List<UIBusinessBankAccount> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOBusinessFinancialBankAccount> list = new ArrayList<EOBusinessFinancialBankAccount>( dtoObjectList.size() );
        for ( UIBusinessBankAccount uIBusinessBankAccount : dtoObjectList ) {
            list.add( mapToDAO( uIBusinessBankAccount ) );
        }

        return list;
    }

    @Override
    public List<UIBusinessBankAccount> mapToDTO(List<EOBusinessFinancialBankAccount> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIBusinessBankAccount> list = new ArrayList<UIBusinessBankAccount>( entityObjectList.size() );
        for ( EOBusinessFinancialBankAccount eOBusinessFinancialBankAccount : entityObjectList ) {
            list.add( mapToDTO( eOBusinessFinancialBankAccount ) );
        }

        return list;
    }
}
