package org.sponsor.account.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOUserFinancialBankUpi;
import org.sponsor.account.mapper.UserFinancialBankUpiMapper;
import org.sponsor.account.model.UIUserFinancialBankUpi;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:34+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserFinancialBankUpiMapperImpl implements UserFinancialBankUpiMapper {

    @Override
    public UIUserFinancialBankUpi mapToDTO(EOUserFinancialBankUpi entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserFinancialBankUpi uIUserFinancialBankUpi = new UIUserFinancialBankUpi();

        uIUserFinancialBankUpi.setId( entityObject.getId() );
        uIUserFinancialBankUpi.setOrderSequence( entityObject.getOrderSequence() );
        uIUserFinancialBankUpi.setUpiHolder( entityObject.getUpiHolder() );
        uIUserFinancialBankUpi.setUpiId( entityObject.getUpiId() );
        uIUserFinancialBankUpi.setQrCode( entityObject.getQrCode() );

        return uIUserFinancialBankUpi;
    }

    @Override
    public EOUserFinancialBankUpi mapToDAO(UIUserFinancialBankUpi dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOUserFinancialBankUpi eOUserFinancialBankUpi = new EOUserFinancialBankUpi();

        eOUserFinancialBankUpi.setId( dtoObject.getId() );
        eOUserFinancialBankUpi.setOrderSequence( dtoObject.getOrderSequence() );
        eOUserFinancialBankUpi.setUpiHolder( dtoObject.getUpiHolder() );
        eOUserFinancialBankUpi.setUpiId( dtoObject.getUpiId() );
        eOUserFinancialBankUpi.setQrCode( dtoObject.getQrCode() );

        return eOUserFinancialBankUpi;
    }

    @Override
    public List<EOUserFinancialBankUpi> mapToDAO(List<UIUserFinancialBankUpi> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserFinancialBankUpi> list = new ArrayList<EOUserFinancialBankUpi>( dtoObjectList.size() );
        for ( UIUserFinancialBankUpi uIUserFinancialBankUpi : dtoObjectList ) {
            list.add( mapToDAO( uIUserFinancialBankUpi ) );
        }

        return list;
    }

    @Override
    public List<UIUserFinancialBankUpi> mapToDTO(List<EOUserFinancialBankUpi> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserFinancialBankUpi> list = new ArrayList<UIUserFinancialBankUpi>( entityObjectList.size() );
        for ( EOUserFinancialBankUpi eOUserFinancialBankUpi : entityObjectList ) {
            list.add( mapToDTO( eOUserFinancialBankUpi ) );
        }

        return list;
    }
}
