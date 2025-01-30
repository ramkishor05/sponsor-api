package org.sponsor.account.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOBusinessFinancialBankUpi;
import org.sponsor.account.mapper.BusinessBankUpiMapper;
import org.sponsor.account.model.UIBusinessBankUpi;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:33+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class BusinessBankUpiMapperImpl implements BusinessBankUpiMapper {

    @Override
    public UIBusinessBankUpi mapToDTO(EOBusinessFinancialBankUpi entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIBusinessBankUpi uIBusinessBankUpi = new UIBusinessBankUpi();

        uIBusinessBankUpi.setId( entityObject.getId() );
        uIBusinessBankUpi.setOrderSequence( entityObject.getOrderSequence() );
        uIBusinessBankUpi.setUpiHolder( entityObject.getUpiHolder() );
        uIBusinessBankUpi.setUpiId( entityObject.getUpiId() );
        uIBusinessBankUpi.setQrCode( entityObject.getQrCode() );

        return uIBusinessBankUpi;
    }

    @Override
    public EOBusinessFinancialBankUpi mapToDAO(UIBusinessBankUpi dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOBusinessFinancialBankUpi eOBusinessFinancialBankUpi = new EOBusinessFinancialBankUpi();

        eOBusinessFinancialBankUpi.setId( dtoObject.getId() );
        eOBusinessFinancialBankUpi.setOrderSequence( dtoObject.getOrderSequence() );
        eOBusinessFinancialBankUpi.setUpiHolder( dtoObject.getUpiHolder() );
        eOBusinessFinancialBankUpi.setUpiId( dtoObject.getUpiId() );
        eOBusinessFinancialBankUpi.setQrCode( dtoObject.getQrCode() );

        return eOBusinessFinancialBankUpi;
    }

    @Override
    public List<EOBusinessFinancialBankUpi> mapToDAO(List<UIBusinessBankUpi> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOBusinessFinancialBankUpi> list = new ArrayList<EOBusinessFinancialBankUpi>( dtoObjectList.size() );
        for ( UIBusinessBankUpi uIBusinessBankUpi : dtoObjectList ) {
            list.add( mapToDAO( uIBusinessBankUpi ) );
        }

        return list;
    }

    @Override
    public List<UIBusinessBankUpi> mapToDTO(List<EOBusinessFinancialBankUpi> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIBusinessBankUpi> list = new ArrayList<UIBusinessBankUpi>( entityObjectList.size() );
        for ( EOBusinessFinancialBankUpi eOBusinessFinancialBankUpi : entityObjectList ) {
            list.add( mapToDTO( eOBusinessFinancialBankUpi ) );
        }

        return list;
    }
}
