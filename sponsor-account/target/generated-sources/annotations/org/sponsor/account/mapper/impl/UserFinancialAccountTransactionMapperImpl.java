package org.sponsor.account.mapper.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOUserFinancialWalletTransaction;
import org.sponsor.account.mapper.UserFinancialAccountTransactionMapper;
import org.sponsor.account.model.UIUserFinancialWalletTransaction;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:34+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserFinancialAccountTransactionMapperImpl implements UserFinancialAccountTransactionMapper {

    @Override
    public UIUserFinancialWalletTransaction mapToDTO(EOUserFinancialWalletTransaction entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserFinancialWalletTransaction uIUserFinancialWalletTransaction = new UIUserFinancialWalletTransaction();

        uIUserFinancialWalletTransaction.setId( entityObject.getId() );
        uIUserFinancialWalletTransaction.setOrderSequence( entityObject.getOrderSequence() );
        if ( entityObject.getTrsDate() != null ) {
            uIUserFinancialWalletTransaction.setTrsDate( new SimpleDateFormat().format( entityObject.getTrsDate() ) );
        }
        uIUserFinancialWalletTransaction.setAmount( entityObject.getAmount() );
        uIUserFinancialWalletTransaction.setType( entityObject.getType() );
        uIUserFinancialWalletTransaction.setUtrNumber( entityObject.getUtrNumber() );
        uIUserFinancialWalletTransaction.setRemarks( entityObject.getRemarks() );

        return uIUserFinancialWalletTransaction;
    }

    @Override
    public EOUserFinancialWalletTransaction mapToDAO(UIUserFinancialWalletTransaction dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOUserFinancialWalletTransaction eOUserFinancialWalletTransaction = new EOUserFinancialWalletTransaction();

        eOUserFinancialWalletTransaction.setId( dtoObject.getId() );
        eOUserFinancialWalletTransaction.setOrderSequence( dtoObject.getOrderSequence() );
        try {
            if ( dtoObject.getTrsDate() != null ) {
                eOUserFinancialWalletTransaction.setTrsDate( new SimpleDateFormat().parse( dtoObject.getTrsDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        eOUserFinancialWalletTransaction.setAmount( dtoObject.getAmount() );
        eOUserFinancialWalletTransaction.setType( dtoObject.getType() );
        eOUserFinancialWalletTransaction.setUtrNumber( dtoObject.getUtrNumber() );
        eOUserFinancialWalletTransaction.setRemarks( dtoObject.getRemarks() );

        return eOUserFinancialWalletTransaction;
    }

    @Override
    public List<EOUserFinancialWalletTransaction> mapToDAO(List<UIUserFinancialWalletTransaction> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserFinancialWalletTransaction> list = new ArrayList<EOUserFinancialWalletTransaction>( dtoObjectList.size() );
        for ( UIUserFinancialWalletTransaction uIUserFinancialWalletTransaction : dtoObjectList ) {
            list.add( mapToDAO( uIUserFinancialWalletTransaction ) );
        }

        return list;
    }

    @Override
    public List<UIUserFinancialWalletTransaction> mapToDTO(List<EOUserFinancialWalletTransaction> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserFinancialWalletTransaction> list = new ArrayList<UIUserFinancialWalletTransaction>( entityObjectList.size() );
        for ( EOUserFinancialWalletTransaction eOUserFinancialWalletTransaction : entityObjectList ) {
            list.add( mapToDTO( eOUserFinancialWalletTransaction ) );
        }

        return list;
    }
}
