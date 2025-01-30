package org.sponsor.account.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOBusinessFinancialAccountTransaction;
import org.sponsor.account.mapper.BusinessAccountTransactionMapper;
import org.sponsor.account.model.UIBusinessFinancialAccountTransaction;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:35+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class BusinessAccountTransactionMapperImpl implements BusinessAccountTransactionMapper {

    @Override
    public UIBusinessFinancialAccountTransaction mapToDTO(EOBusinessFinancialAccountTransaction entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIBusinessFinancialAccountTransaction uIBusinessFinancialAccountTransaction = new UIBusinessFinancialAccountTransaction();

        uIBusinessFinancialAccountTransaction.setId( entityObject.getId() );
        uIBusinessFinancialAccountTransaction.setOrderSequence( entityObject.getOrderSequence() );
        uIBusinessFinancialAccountTransaction.setAmount( entityObject.getAmount() );
        uIBusinessFinancialAccountTransaction.setType( entityObject.getType() );
        uIBusinessFinancialAccountTransaction.setUtrNumber( entityObject.getUtrNumber() );
        uIBusinessFinancialAccountTransaction.setRemarks( entityObject.getRemarks() );

        return uIBusinessFinancialAccountTransaction;
    }

    @Override
    public EOBusinessFinancialAccountTransaction mapToDAO(UIBusinessFinancialAccountTransaction dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOBusinessFinancialAccountTransaction eOBusinessFinancialAccountTransaction = new EOBusinessFinancialAccountTransaction();

        eOBusinessFinancialAccountTransaction.setId( dtoObject.getId() );
        eOBusinessFinancialAccountTransaction.setOrderSequence( dtoObject.getOrderSequence() );
        eOBusinessFinancialAccountTransaction.setAmount( dtoObject.getAmount() );
        eOBusinessFinancialAccountTransaction.setType( dtoObject.getType() );
        eOBusinessFinancialAccountTransaction.setUtrNumber( dtoObject.getUtrNumber() );
        eOBusinessFinancialAccountTransaction.setRemarks( dtoObject.getRemarks() );

        return eOBusinessFinancialAccountTransaction;
    }

    @Override
    public List<EOBusinessFinancialAccountTransaction> mapToDAO(List<UIBusinessFinancialAccountTransaction> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOBusinessFinancialAccountTransaction> list = new ArrayList<EOBusinessFinancialAccountTransaction>( dtoObjectList.size() );
        for ( UIBusinessFinancialAccountTransaction uIBusinessFinancialAccountTransaction : dtoObjectList ) {
            list.add( mapToDAO( uIBusinessFinancialAccountTransaction ) );
        }

        return list;
    }

    @Override
    public List<UIBusinessFinancialAccountTransaction> mapToDTO(List<EOBusinessFinancialAccountTransaction> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIBusinessFinancialAccountTransaction> list = new ArrayList<UIBusinessFinancialAccountTransaction>( entityObjectList.size() );
        for ( EOBusinessFinancialAccountTransaction eOBusinessFinancialAccountTransaction : entityObjectList ) {
            list.add( mapToDTO( eOBusinessFinancialAccountTransaction ) );
        }

        return list;
    }
}
