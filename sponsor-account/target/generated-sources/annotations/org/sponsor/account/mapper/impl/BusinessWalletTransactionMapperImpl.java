package org.sponsor.account.mapper.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOBusinessFinancialWalletTransaction;
import org.sponsor.account.mapper.BusinessWalletTransactionMapper;
import org.sponsor.account.model.UIBusinessFinancialWalletTransaction;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:34+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class BusinessWalletTransactionMapperImpl implements BusinessWalletTransactionMapper {

    @Override
    public UIBusinessFinancialWalletTransaction mapToDTO(EOBusinessFinancialWalletTransaction entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIBusinessFinancialWalletTransaction uIBusinessFinancialWalletTransaction = new UIBusinessFinancialWalletTransaction();

        uIBusinessFinancialWalletTransaction.setId( entityObject.getId() );
        uIBusinessFinancialWalletTransaction.setOrderSequence( entityObject.getOrderSequence() );
        if ( entityObject.getTrsDate() != null ) {
            uIBusinessFinancialWalletTransaction.setTrsDate( new SimpleDateFormat().format( entityObject.getTrsDate() ) );
        }
        uIBusinessFinancialWalletTransaction.setAmount( entityObject.getAmount() );
        uIBusinessFinancialWalletTransaction.setType( entityObject.getType() );
        uIBusinessFinancialWalletTransaction.setUtrNumber( entityObject.getUtrNumber() );
        uIBusinessFinancialWalletTransaction.setRemarks( entityObject.getRemarks() );

        return uIBusinessFinancialWalletTransaction;
    }

    @Override
    public EOBusinessFinancialWalletTransaction mapToDAO(UIBusinessFinancialWalletTransaction dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOBusinessFinancialWalletTransaction eOBusinessFinancialWalletTransaction = new EOBusinessFinancialWalletTransaction();

        eOBusinessFinancialWalletTransaction.setId( dtoObject.getId() );
        eOBusinessFinancialWalletTransaction.setOrderSequence( dtoObject.getOrderSequence() );
        try {
            if ( dtoObject.getTrsDate() != null ) {
                eOBusinessFinancialWalletTransaction.setTrsDate( new SimpleDateFormat().parse( dtoObject.getTrsDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        eOBusinessFinancialWalletTransaction.setAmount( dtoObject.getAmount() );
        eOBusinessFinancialWalletTransaction.setType( dtoObject.getType() );
        eOBusinessFinancialWalletTransaction.setUtrNumber( dtoObject.getUtrNumber() );
        eOBusinessFinancialWalletTransaction.setRemarks( dtoObject.getRemarks() );

        return eOBusinessFinancialWalletTransaction;
    }

    @Override
    public List<EOBusinessFinancialWalletTransaction> mapToDAO(List<UIBusinessFinancialWalletTransaction> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOBusinessFinancialWalletTransaction> list = new ArrayList<EOBusinessFinancialWalletTransaction>( dtoObjectList.size() );
        for ( UIBusinessFinancialWalletTransaction uIBusinessFinancialWalletTransaction : dtoObjectList ) {
            list.add( mapToDAO( uIBusinessFinancialWalletTransaction ) );
        }

        return list;
    }

    @Override
    public List<UIBusinessFinancialWalletTransaction> mapToDTO(List<EOBusinessFinancialWalletTransaction> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIBusinessFinancialWalletTransaction> list = new ArrayList<UIBusinessFinancialWalletTransaction>( entityObjectList.size() );
        for ( EOBusinessFinancialWalletTransaction eOBusinessFinancialWalletTransaction : entityObjectList ) {
            list.add( mapToDTO( eOBusinessFinancialWalletTransaction ) );
        }

        return list;
    }
}
