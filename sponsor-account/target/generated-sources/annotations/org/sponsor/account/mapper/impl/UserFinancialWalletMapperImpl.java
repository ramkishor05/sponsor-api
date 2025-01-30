package org.sponsor.account.mapper.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOUserFinancialWallet;
import org.sponsor.account.entities.EOUserFinancialWalletTransaction;
import org.sponsor.account.mapper.UserFinancialWalletMapper;
import org.sponsor.account.model.UIUserFinancialWallet;
import org.sponsor.account.model.UIUserFinancialWalletTransaction;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:35+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserFinancialWalletMapperImpl implements UserFinancialWalletMapper {

    @Override
    public UIUserFinancialWallet mapToDTO(EOUserFinancialWallet entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserFinancialWallet uIUserFinancialWallet = new UIUserFinancialWallet();

        uIUserFinancialWallet.setId( entityObject.getId() );
        uIUserFinancialWallet.setOrderSequence( entityObject.getOrderSequence() );
        uIUserFinancialWallet.setBalance( entityObject.getBalance() );
        uIUserFinancialWallet.setLevelIncome( entityObject.getLevelIncome() );
        uIUserFinancialWallet.setSponsorIncome( entityObject.getSponsorIncome() );
        uIUserFinancialWallet.setBoostIncome( entityObject.getBoostIncome() );
        uIUserFinancialWallet.setRoyaltyIncome( entityObject.getRoyaltyIncome() );
        uIUserFinancialWallet.setTransactions( eOUserFinancialWalletTransactionListToUIUserFinancialWalletTransactionList( entityObject.getTransactions() ) );

        return uIUserFinancialWallet;
    }

    @Override
    public EOUserFinancialWallet mapToDAO(UIUserFinancialWallet dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOUserFinancialWallet eOUserFinancialWallet = new EOUserFinancialWallet();

        eOUserFinancialWallet.setId( dtoObject.getId() );
        eOUserFinancialWallet.setOrderSequence( dtoObject.getOrderSequence() );
        eOUserFinancialWallet.setBalance( dtoObject.getBalance() );
        try {
            eOUserFinancialWallet.setTransactions( uIUserFinancialWalletTransactionListToEOUserFinancialWalletTransactionList( dtoObject.getTransactions() ) );
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        eOUserFinancialWallet.setSponsorIncome( dtoObject.getSponsorIncome() );
        eOUserFinancialWallet.setBoostIncome( dtoObject.getBoostIncome() );
        eOUserFinancialWallet.setLevelIncome( dtoObject.getLevelIncome() );
        eOUserFinancialWallet.setRoyaltyIncome( dtoObject.getRoyaltyIncome() );

        return eOUserFinancialWallet;
    }

    @Override
    public List<EOUserFinancialWallet> mapToDAO(List<UIUserFinancialWallet> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserFinancialWallet> list = new ArrayList<EOUserFinancialWallet>( dtoObjectList.size() );
        for ( UIUserFinancialWallet uIUserFinancialWallet : dtoObjectList ) {
            list.add( mapToDAO( uIUserFinancialWallet ) );
        }

        return list;
    }

    @Override
    public List<UIUserFinancialWallet> mapToDTO(List<EOUserFinancialWallet> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserFinancialWallet> list = new ArrayList<UIUserFinancialWallet>( entityObjectList.size() );
        for ( EOUserFinancialWallet eOUserFinancialWallet : entityObjectList ) {
            list.add( mapToDTO( eOUserFinancialWallet ) );
        }

        return list;
    }

    protected UIUserFinancialWalletTransaction eOUserFinancialWalletTransactionToUIUserFinancialWalletTransaction(EOUserFinancialWalletTransaction eOUserFinancialWalletTransaction) {
        if ( eOUserFinancialWalletTransaction == null ) {
            return null;
        }

        UIUserFinancialWalletTransaction uIUserFinancialWalletTransaction = new UIUserFinancialWalletTransaction();

        uIUserFinancialWalletTransaction.setId( eOUserFinancialWalletTransaction.getId() );
        uIUserFinancialWalletTransaction.setOrderSequence( eOUserFinancialWalletTransaction.getOrderSequence() );
        if ( eOUserFinancialWalletTransaction.getTrsDate() != null ) {
            uIUserFinancialWalletTransaction.setTrsDate( new SimpleDateFormat().format( eOUserFinancialWalletTransaction.getTrsDate() ) );
        }
        uIUserFinancialWalletTransaction.setAmount( eOUserFinancialWalletTransaction.getAmount() );
        uIUserFinancialWalletTransaction.setType( eOUserFinancialWalletTransaction.getType() );
        uIUserFinancialWalletTransaction.setUtrNumber( eOUserFinancialWalletTransaction.getUtrNumber() );
        uIUserFinancialWalletTransaction.setRemarks( eOUserFinancialWalletTransaction.getRemarks() );

        return uIUserFinancialWalletTransaction;
    }

    protected List<UIUserFinancialWalletTransaction> eOUserFinancialWalletTransactionListToUIUserFinancialWalletTransactionList(List<EOUserFinancialWalletTransaction> list) {
        if ( list == null ) {
            return null;
        }

        List<UIUserFinancialWalletTransaction> list1 = new ArrayList<UIUserFinancialWalletTransaction>( list.size() );
        for ( EOUserFinancialWalletTransaction eOUserFinancialWalletTransaction : list ) {
            list1.add( eOUserFinancialWalletTransactionToUIUserFinancialWalletTransaction( eOUserFinancialWalletTransaction ) );
        }

        return list1;
    }

    protected EOUserFinancialWalletTransaction uIUserFinancialWalletTransactionToEOUserFinancialWalletTransaction(UIUserFinancialWalletTransaction uIUserFinancialWalletTransaction) throws ParseException {
        if ( uIUserFinancialWalletTransaction == null ) {
            return null;
        }

        EOUserFinancialWalletTransaction eOUserFinancialWalletTransaction = new EOUserFinancialWalletTransaction();

        eOUserFinancialWalletTransaction.setId( uIUserFinancialWalletTransaction.getId() );
        eOUserFinancialWalletTransaction.setOrderSequence( uIUserFinancialWalletTransaction.getOrderSequence() );
        if ( uIUserFinancialWalletTransaction.getTrsDate() != null ) {
            eOUserFinancialWalletTransaction.setTrsDate( new SimpleDateFormat().parse( uIUserFinancialWalletTransaction.getTrsDate() ) );
        }
        eOUserFinancialWalletTransaction.setAmount( uIUserFinancialWalletTransaction.getAmount() );
        eOUserFinancialWalletTransaction.setType( uIUserFinancialWalletTransaction.getType() );
        eOUserFinancialWalletTransaction.setUtrNumber( uIUserFinancialWalletTransaction.getUtrNumber() );
        eOUserFinancialWalletTransaction.setRemarks( uIUserFinancialWalletTransaction.getRemarks() );

        return eOUserFinancialWalletTransaction;
    }

    protected List<EOUserFinancialWalletTransaction> uIUserFinancialWalletTransactionListToEOUserFinancialWalletTransactionList(List<UIUserFinancialWalletTransaction> list) throws ParseException {
        if ( list == null ) {
            return null;
        }

        List<EOUserFinancialWalletTransaction> list1 = new ArrayList<EOUserFinancialWalletTransaction>( list.size() );
        for ( UIUserFinancialWalletTransaction uIUserFinancialWalletTransaction : list ) {
            list1.add( uIUserFinancialWalletTransactionToEOUserFinancialWalletTransaction( uIUserFinancialWalletTransaction ) );
        }

        return list1;
    }
}
