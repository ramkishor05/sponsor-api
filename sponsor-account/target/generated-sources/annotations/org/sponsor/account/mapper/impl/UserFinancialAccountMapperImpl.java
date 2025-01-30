package org.sponsor.account.mapper.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOUserFinancialAccount;
import org.sponsor.account.entities.EOUserFinancialAccountTransaction;
import org.sponsor.account.mapper.UserFinancialAccountMapper;
import org.sponsor.account.model.UIUserFinancialAccount;
import org.sponsor.account.model.UIUserFinancialAccountTransaction;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:34+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserFinancialAccountMapperImpl implements UserFinancialAccountMapper {

    @Override
    public UIUserFinancialAccount mapToDTO(EOUserFinancialAccount entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserFinancialAccount uIUserFinancialAccount = new UIUserFinancialAccount();

        uIUserFinancialAccount.setId( entityObject.getId() );
        uIUserFinancialAccount.setOrderSequence( entityObject.getOrderSequence() );
        uIUserFinancialAccount.setBalance( entityObject.getBalance() );
        uIUserFinancialAccount.setLevelIncome( entityObject.getLevelIncome() );
        uIUserFinancialAccount.setSponsorIncome( entityObject.getSponsorIncome() );
        uIUserFinancialAccount.setBoostIncome( entityObject.getBoostIncome() );
        uIUserFinancialAccount.setTransactions( eOUserFinancialAccountTransactionListToUIUserFinancialAccountTransactionList( entityObject.getTransactions() ) );

        return uIUserFinancialAccount;
    }

    @Override
    public EOUserFinancialAccount mapToDAO(UIUserFinancialAccount dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOUserFinancialAccount eOUserFinancialAccount = new EOUserFinancialAccount();

        eOUserFinancialAccount.setId( dtoObject.getId() );
        eOUserFinancialAccount.setOrderSequence( dtoObject.getOrderSequence() );
        eOUserFinancialAccount.setBalance( dtoObject.getBalance() );
        try {
            eOUserFinancialAccount.setTransactions( uIUserFinancialAccountTransactionListToEOUserFinancialAccountTransactionList( dtoObject.getTransactions() ) );
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        eOUserFinancialAccount.setSponsorIncome( dtoObject.getSponsorIncome() );
        eOUserFinancialAccount.setBoostIncome( dtoObject.getBoostIncome() );
        eOUserFinancialAccount.setLevelIncome( dtoObject.getLevelIncome() );

        return eOUserFinancialAccount;
    }

    @Override
    public List<EOUserFinancialAccount> mapToDAO(List<UIUserFinancialAccount> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserFinancialAccount> list = new ArrayList<EOUserFinancialAccount>( dtoObjectList.size() );
        for ( UIUserFinancialAccount uIUserFinancialAccount : dtoObjectList ) {
            list.add( mapToDAO( uIUserFinancialAccount ) );
        }

        return list;
    }

    @Override
    public List<UIUserFinancialAccount> mapToDTO(List<EOUserFinancialAccount> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserFinancialAccount> list = new ArrayList<UIUserFinancialAccount>( entityObjectList.size() );
        for ( EOUserFinancialAccount eOUserFinancialAccount : entityObjectList ) {
            list.add( mapToDTO( eOUserFinancialAccount ) );
        }

        return list;
    }

    protected UIUserFinancialAccountTransaction eOUserFinancialAccountTransactionToUIUserFinancialAccountTransaction(EOUserFinancialAccountTransaction eOUserFinancialAccountTransaction) {
        if ( eOUserFinancialAccountTransaction == null ) {
            return null;
        }

        UIUserFinancialAccountTransaction uIUserFinancialAccountTransaction = new UIUserFinancialAccountTransaction();

        uIUserFinancialAccountTransaction.setId( eOUserFinancialAccountTransaction.getId() );
        uIUserFinancialAccountTransaction.setOrderSequence( eOUserFinancialAccountTransaction.getOrderSequence() );
        if ( eOUserFinancialAccountTransaction.getTrsDate() != null ) {
            uIUserFinancialAccountTransaction.setTrsDate( new SimpleDateFormat().format( eOUserFinancialAccountTransaction.getTrsDate() ) );
        }
        uIUserFinancialAccountTransaction.setAmount( eOUserFinancialAccountTransaction.getAmount() );
        uIUserFinancialAccountTransaction.setType( eOUserFinancialAccountTransaction.getType() );
        uIUserFinancialAccountTransaction.setUtrNumber( eOUserFinancialAccountTransaction.getUtrNumber() );
        uIUserFinancialAccountTransaction.setRemarks( eOUserFinancialAccountTransaction.getRemarks() );

        return uIUserFinancialAccountTransaction;
    }

    protected List<UIUserFinancialAccountTransaction> eOUserFinancialAccountTransactionListToUIUserFinancialAccountTransactionList(List<EOUserFinancialAccountTransaction> list) {
        if ( list == null ) {
            return null;
        }

        List<UIUserFinancialAccountTransaction> list1 = new ArrayList<UIUserFinancialAccountTransaction>( list.size() );
        for ( EOUserFinancialAccountTransaction eOUserFinancialAccountTransaction : list ) {
            list1.add( eOUserFinancialAccountTransactionToUIUserFinancialAccountTransaction( eOUserFinancialAccountTransaction ) );
        }

        return list1;
    }

    protected EOUserFinancialAccountTransaction uIUserFinancialAccountTransactionToEOUserFinancialAccountTransaction(UIUserFinancialAccountTransaction uIUserFinancialAccountTransaction) throws ParseException {
        if ( uIUserFinancialAccountTransaction == null ) {
            return null;
        }

        EOUserFinancialAccountTransaction eOUserFinancialAccountTransaction = new EOUserFinancialAccountTransaction();

        eOUserFinancialAccountTransaction.setId( uIUserFinancialAccountTransaction.getId() );
        eOUserFinancialAccountTransaction.setOrderSequence( uIUserFinancialAccountTransaction.getOrderSequence() );
        if ( uIUserFinancialAccountTransaction.getTrsDate() != null ) {
            eOUserFinancialAccountTransaction.setTrsDate( new SimpleDateFormat().parse( uIUserFinancialAccountTransaction.getTrsDate() ) );
        }
        eOUserFinancialAccountTransaction.setAmount( uIUserFinancialAccountTransaction.getAmount() );
        eOUserFinancialAccountTransaction.setType( uIUserFinancialAccountTransaction.getType() );
        eOUserFinancialAccountTransaction.setUtrNumber( uIUserFinancialAccountTransaction.getUtrNumber() );
        eOUserFinancialAccountTransaction.setRemarks( uIUserFinancialAccountTransaction.getRemarks() );

        return eOUserFinancialAccountTransaction;
    }

    protected List<EOUserFinancialAccountTransaction> uIUserFinancialAccountTransactionListToEOUserFinancialAccountTransactionList(List<UIUserFinancialAccountTransaction> list) throws ParseException {
        if ( list == null ) {
            return null;
        }

        List<EOUserFinancialAccountTransaction> list1 = new ArrayList<EOUserFinancialAccountTransaction>( list.size() );
        for ( UIUserFinancialAccountTransaction uIUserFinancialAccountTransaction : list ) {
            list1.add( uIUserFinancialAccountTransactionToEOUserFinancialAccountTransaction( uIUserFinancialAccountTransaction ) );
        }

        return list1;
    }
}
