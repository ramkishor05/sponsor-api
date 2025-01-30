package org.sponsor.account.mapper.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOBusinessFinancialWallet;
import org.sponsor.account.entities.EOBusinessFinancialWalletTransaction;
import org.sponsor.account.mapper.BusinessFinancialWalletMapper;
import org.sponsor.account.model.UIBusinessFinancialWallet;
import org.sponsor.account.model.UIBusinessFinancialWalletTransaction;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:35+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class BusinessFinancialWalletMapperImpl implements BusinessFinancialWalletMapper {

    @Override
    public UIBusinessFinancialWallet mapToDTO(EOBusinessFinancialWallet entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIBusinessFinancialWallet uIBusinessFinancialWallet = new UIBusinessFinancialWallet();

        uIBusinessFinancialWallet.setId( entityObject.getId() );
        uIBusinessFinancialWallet.setOrderSequence( entityObject.getOrderSequence() );
        uIBusinessFinancialWallet.setBalance( entityObject.getBalance() );
        uIBusinessFinancialWallet.setTransactions( eOBusinessFinancialWalletTransactionListToUIBusinessFinancialWalletTransactionList( entityObject.getTransactions() ) );

        return uIBusinessFinancialWallet;
    }

    @Override
    public EOBusinessFinancialWallet mapToDAO(UIBusinessFinancialWallet dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOBusinessFinancialWallet eOBusinessFinancialWallet = new EOBusinessFinancialWallet();

        eOBusinessFinancialWallet.setId( dtoObject.getId() );
        eOBusinessFinancialWallet.setOrderSequence( dtoObject.getOrderSequence() );
        eOBusinessFinancialWallet.setBalance( dtoObject.getBalance() );
        try {
            eOBusinessFinancialWallet.setTransactions( uIBusinessFinancialWalletTransactionListToEOBusinessFinancialWalletTransactionList( dtoObject.getTransactions() ) );
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }

        return eOBusinessFinancialWallet;
    }

    @Override
    public List<EOBusinessFinancialWallet> mapToDAO(List<UIBusinessFinancialWallet> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOBusinessFinancialWallet> list = new ArrayList<EOBusinessFinancialWallet>( dtoObjectList.size() );
        for ( UIBusinessFinancialWallet uIBusinessFinancialWallet : dtoObjectList ) {
            list.add( mapToDAO( uIBusinessFinancialWallet ) );
        }

        return list;
    }

    @Override
    public List<UIBusinessFinancialWallet> mapToDTO(List<EOBusinessFinancialWallet> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIBusinessFinancialWallet> list = new ArrayList<UIBusinessFinancialWallet>( entityObjectList.size() );
        for ( EOBusinessFinancialWallet eOBusinessFinancialWallet : entityObjectList ) {
            list.add( mapToDTO( eOBusinessFinancialWallet ) );
        }

        return list;
    }

    protected UIBusinessFinancialWalletTransaction eOBusinessFinancialWalletTransactionToUIBusinessFinancialWalletTransaction(EOBusinessFinancialWalletTransaction eOBusinessFinancialWalletTransaction) {
        if ( eOBusinessFinancialWalletTransaction == null ) {
            return null;
        }

        UIBusinessFinancialWalletTransaction uIBusinessFinancialWalletTransaction = new UIBusinessFinancialWalletTransaction();

        uIBusinessFinancialWalletTransaction.setId( eOBusinessFinancialWalletTransaction.getId() );
        uIBusinessFinancialWalletTransaction.setOrderSequence( eOBusinessFinancialWalletTransaction.getOrderSequence() );
        if ( eOBusinessFinancialWalletTransaction.getTrsDate() != null ) {
            uIBusinessFinancialWalletTransaction.setTrsDate( new SimpleDateFormat().format( eOBusinessFinancialWalletTransaction.getTrsDate() ) );
        }
        uIBusinessFinancialWalletTransaction.setAmount( eOBusinessFinancialWalletTransaction.getAmount() );
        uIBusinessFinancialWalletTransaction.setType( eOBusinessFinancialWalletTransaction.getType() );
        uIBusinessFinancialWalletTransaction.setUtrNumber( eOBusinessFinancialWalletTransaction.getUtrNumber() );
        uIBusinessFinancialWalletTransaction.setRemarks( eOBusinessFinancialWalletTransaction.getRemarks() );

        return uIBusinessFinancialWalletTransaction;
    }

    protected List<UIBusinessFinancialWalletTransaction> eOBusinessFinancialWalletTransactionListToUIBusinessFinancialWalletTransactionList(List<EOBusinessFinancialWalletTransaction> list) {
        if ( list == null ) {
            return null;
        }

        List<UIBusinessFinancialWalletTransaction> list1 = new ArrayList<UIBusinessFinancialWalletTransaction>( list.size() );
        for ( EOBusinessFinancialWalletTransaction eOBusinessFinancialWalletTransaction : list ) {
            list1.add( eOBusinessFinancialWalletTransactionToUIBusinessFinancialWalletTransaction( eOBusinessFinancialWalletTransaction ) );
        }

        return list1;
    }

    protected EOBusinessFinancialWalletTransaction uIBusinessFinancialWalletTransactionToEOBusinessFinancialWalletTransaction(UIBusinessFinancialWalletTransaction uIBusinessFinancialWalletTransaction) throws ParseException {
        if ( uIBusinessFinancialWalletTransaction == null ) {
            return null;
        }

        EOBusinessFinancialWalletTransaction eOBusinessFinancialWalletTransaction = new EOBusinessFinancialWalletTransaction();

        eOBusinessFinancialWalletTransaction.setId( uIBusinessFinancialWalletTransaction.getId() );
        eOBusinessFinancialWalletTransaction.setOrderSequence( uIBusinessFinancialWalletTransaction.getOrderSequence() );
        if ( uIBusinessFinancialWalletTransaction.getTrsDate() != null ) {
            eOBusinessFinancialWalletTransaction.setTrsDate( new SimpleDateFormat().parse( uIBusinessFinancialWalletTransaction.getTrsDate() ) );
        }
        eOBusinessFinancialWalletTransaction.setAmount( uIBusinessFinancialWalletTransaction.getAmount() );
        eOBusinessFinancialWalletTransaction.setType( uIBusinessFinancialWalletTransaction.getType() );
        eOBusinessFinancialWalletTransaction.setUtrNumber( uIBusinessFinancialWalletTransaction.getUtrNumber() );
        eOBusinessFinancialWalletTransaction.setRemarks( uIBusinessFinancialWalletTransaction.getRemarks() );

        return eOBusinessFinancialWalletTransaction;
    }

    protected List<EOBusinessFinancialWalletTransaction> uIBusinessFinancialWalletTransactionListToEOBusinessFinancialWalletTransactionList(List<UIBusinessFinancialWalletTransaction> list) throws ParseException {
        if ( list == null ) {
            return null;
        }

        List<EOBusinessFinancialWalletTransaction> list1 = new ArrayList<EOBusinessFinancialWalletTransaction>( list.size() );
        for ( UIBusinessFinancialWalletTransaction uIBusinessFinancialWalletTransaction : list ) {
            list1.add( uIBusinessFinancialWalletTransactionToEOBusinessFinancialWalletTransaction( uIBusinessFinancialWalletTransaction ) );
        }

        return list1;
    }
}
