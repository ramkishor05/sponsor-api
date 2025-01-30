package org.sponsor.account.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOBusinessFinancialAccount;
import org.sponsor.account.entities.EOBusinessFinancialAccountTransaction;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.mapper.BusinessFinancialAccountMapper;
import org.sponsor.account.model.UIBusinessFinancialAccount;
import org.sponsor.account.model.UIBusinessFinancialAccountTransaction;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:34+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class BusinessFinancialAccountMapperImpl implements BusinessFinancialAccountMapper {

    @Override
    public List<EOBusinessFinancialAccount> mapToDAO(List<UIBusinessFinancialAccount> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOBusinessFinancialAccount> list = new ArrayList<EOBusinessFinancialAccount>( dtoObjectList.size() );
        for ( UIBusinessFinancialAccount uIBusinessFinancialAccount : dtoObjectList ) {
            list.add( mapToDAO( uIBusinessFinancialAccount ) );
        }

        return list;
    }

    @Override
    public List<UIBusinessFinancialAccount> mapToDTO(List<EOBusinessFinancialAccount> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIBusinessFinancialAccount> list = new ArrayList<UIBusinessFinancialAccount>( entityObjectList.size() );
        for ( EOBusinessFinancialAccount eOBusinessFinancialAccount : entityObjectList ) {
            list.add( mapToDTO( eOBusinessFinancialAccount ) );
        }

        return list;
    }

    @Override
    public EOBusinessFinancialAccount mapToDAO(UIBusinessFinancialAccount dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOBusinessFinancialAccount eOBusinessFinancialAccount = new EOBusinessFinancialAccount();

        eOBusinessFinancialAccount.setBussinessSponsor( uIBusinessFinancialAccountToEOBusinessSponsor( dtoObject ) );
        eOBusinessFinancialAccount.setId( dtoObject.getId() );
        eOBusinessFinancialAccount.setOrderSequence( dtoObject.getOrderSequence() );
        eOBusinessFinancialAccount.setBalance( dtoObject.getBalance() );
        eOBusinessFinancialAccount.setFees( dtoObject.getFees() );
        eOBusinessFinancialAccount.setTransactions( uIBusinessFinancialAccountTransactionListToEOBusinessFinancialAccountTransactionList( dtoObject.getTransactions() ) );

        return eOBusinessFinancialAccount;
    }

    @Override
    public UIBusinessFinancialAccount mapToDTO(EOBusinessFinancialAccount entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIBusinessFinancialAccount uIBusinessFinancialAccount = new UIBusinessFinancialAccount();

        uIBusinessFinancialAccount.setBussinessSponsorId( entityObjectBussinessSponsorId( entityObject ) );
        uIBusinessFinancialAccount.setId( entityObject.getId() );
        uIBusinessFinancialAccount.setOrderSequence( entityObject.getOrderSequence() );
        uIBusinessFinancialAccount.setBalance( entityObject.getBalance() );
        uIBusinessFinancialAccount.setFees( entityObject.getFees() );
        uIBusinessFinancialAccount.setTransactions( eOBusinessFinancialAccountTransactionListToUIBusinessFinancialAccountTransactionList( entityObject.getTransactions() ) );

        return uIBusinessFinancialAccount;
    }

    protected EOBusinessSponsor uIBusinessFinancialAccountToEOBusinessSponsor(UIBusinessFinancialAccount uIBusinessFinancialAccount) {
        if ( uIBusinessFinancialAccount == null ) {
            return null;
        }

        EOBusinessSponsor eOBusinessSponsor = new EOBusinessSponsor();

        eOBusinessSponsor.setId( uIBusinessFinancialAccount.getBussinessSponsorId() );

        return eOBusinessSponsor;
    }

    protected EOBusinessFinancialAccountTransaction uIBusinessFinancialAccountTransactionToEOBusinessFinancialAccountTransaction(UIBusinessFinancialAccountTransaction uIBusinessFinancialAccountTransaction) {
        if ( uIBusinessFinancialAccountTransaction == null ) {
            return null;
        }

        EOBusinessFinancialAccountTransaction eOBusinessFinancialAccountTransaction = new EOBusinessFinancialAccountTransaction();

        eOBusinessFinancialAccountTransaction.setId( uIBusinessFinancialAccountTransaction.getId() );
        eOBusinessFinancialAccountTransaction.setOrderSequence( uIBusinessFinancialAccountTransaction.getOrderSequence() );
        eOBusinessFinancialAccountTransaction.setAmount( uIBusinessFinancialAccountTransaction.getAmount() );
        eOBusinessFinancialAccountTransaction.setType( uIBusinessFinancialAccountTransaction.getType() );
        eOBusinessFinancialAccountTransaction.setUtrNumber( uIBusinessFinancialAccountTransaction.getUtrNumber() );
        eOBusinessFinancialAccountTransaction.setRemarks( uIBusinessFinancialAccountTransaction.getRemarks() );

        return eOBusinessFinancialAccountTransaction;
    }

    protected List<EOBusinessFinancialAccountTransaction> uIBusinessFinancialAccountTransactionListToEOBusinessFinancialAccountTransactionList(List<UIBusinessFinancialAccountTransaction> list) {
        if ( list == null ) {
            return null;
        }

        List<EOBusinessFinancialAccountTransaction> list1 = new ArrayList<EOBusinessFinancialAccountTransaction>( list.size() );
        for ( UIBusinessFinancialAccountTransaction uIBusinessFinancialAccountTransaction : list ) {
            list1.add( uIBusinessFinancialAccountTransactionToEOBusinessFinancialAccountTransaction( uIBusinessFinancialAccountTransaction ) );
        }

        return list1;
    }

    private Long entityObjectBussinessSponsorId(EOBusinessFinancialAccount eOBusinessFinancialAccount) {
        EOBusinessSponsor bussinessSponsor = eOBusinessFinancialAccount.getBussinessSponsor();
        if ( bussinessSponsor == null ) {
            return null;
        }
        return bussinessSponsor.getId();
    }

    protected UIBusinessFinancialAccountTransaction eOBusinessFinancialAccountTransactionToUIBusinessFinancialAccountTransaction(EOBusinessFinancialAccountTransaction eOBusinessFinancialAccountTransaction) {
        if ( eOBusinessFinancialAccountTransaction == null ) {
            return null;
        }

        UIBusinessFinancialAccountTransaction uIBusinessFinancialAccountTransaction = new UIBusinessFinancialAccountTransaction();

        uIBusinessFinancialAccountTransaction.setId( eOBusinessFinancialAccountTransaction.getId() );
        uIBusinessFinancialAccountTransaction.setOrderSequence( eOBusinessFinancialAccountTransaction.getOrderSequence() );
        uIBusinessFinancialAccountTransaction.setAmount( eOBusinessFinancialAccountTransaction.getAmount() );
        uIBusinessFinancialAccountTransaction.setType( eOBusinessFinancialAccountTransaction.getType() );
        uIBusinessFinancialAccountTransaction.setUtrNumber( eOBusinessFinancialAccountTransaction.getUtrNumber() );
        uIBusinessFinancialAccountTransaction.setRemarks( eOBusinessFinancialAccountTransaction.getRemarks() );

        return uIBusinessFinancialAccountTransaction;
    }

    protected List<UIBusinessFinancialAccountTransaction> eOBusinessFinancialAccountTransactionListToUIBusinessFinancialAccountTransactionList(List<EOBusinessFinancialAccountTransaction> list) {
        if ( list == null ) {
            return null;
        }

        List<UIBusinessFinancialAccountTransaction> list1 = new ArrayList<UIBusinessFinancialAccountTransaction>( list.size() );
        for ( EOBusinessFinancialAccountTransaction eOBusinessFinancialAccountTransaction : list ) {
            list1.add( eOBusinessFinancialAccountTransactionToUIBusinessFinancialAccountTransaction( eOBusinessFinancialAccountTransaction ) );
        }

        return list1;
    }
}
