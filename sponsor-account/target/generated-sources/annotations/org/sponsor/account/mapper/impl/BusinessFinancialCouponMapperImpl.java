package org.sponsor.account.mapper.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOBusinessFinancialCoupon;
import org.sponsor.account.mapper.BusinessFinancialCouponMapper;
import org.sponsor.account.model.UIBusinessFinancialCoupon;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:35+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class BusinessFinancialCouponMapperImpl implements BusinessFinancialCouponMapper {

    @Override
    public UIBusinessFinancialCoupon mapToDTO(EOBusinessFinancialCoupon entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIBusinessFinancialCoupon uIBusinessFinancialCoupon = new UIBusinessFinancialCoupon();

        uIBusinessFinancialCoupon.setId( entityObject.getId() );
        uIBusinessFinancialCoupon.setOrderSequence( entityObject.getOrderSequence() );
        uIBusinessFinancialCoupon.setName( entityObject.getName() );
        uIBusinessFinancialCoupon.setDescription( entityObject.getDescription() );
        uIBusinessFinancialCoupon.setValue( entityObject.getValue() );
        if ( entityObject.getStartDate() != null ) {
            uIBusinessFinancialCoupon.setStartDate( new SimpleDateFormat().format( entityObject.getStartDate() ) );
        }
        if ( entityObject.getEndDate() != null ) {
            uIBusinessFinancialCoupon.setEndDate( new SimpleDateFormat().format( entityObject.getEndDate() ) );
        }
        uIBusinessFinancialCoupon.setType( entityObject.getType() );
        uIBusinessFinancialCoupon.setStatus( entityObject.getStatus() );

        return uIBusinessFinancialCoupon;
    }

    @Override
    public EOBusinessFinancialCoupon mapToDAO(UIBusinessFinancialCoupon dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOBusinessFinancialCoupon eOBusinessFinancialCoupon = new EOBusinessFinancialCoupon();

        eOBusinessFinancialCoupon.setId( dtoObject.getId() );
        eOBusinessFinancialCoupon.setOrderSequence( dtoObject.getOrderSequence() );
        eOBusinessFinancialCoupon.setName( dtoObject.getName() );
        eOBusinessFinancialCoupon.setDescription( dtoObject.getDescription() );
        eOBusinessFinancialCoupon.setValue( dtoObject.getValue() );
        try {
            if ( dtoObject.getStartDate() != null ) {
                eOBusinessFinancialCoupon.setStartDate( new SimpleDateFormat().parse( dtoObject.getStartDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        try {
            if ( dtoObject.getEndDate() != null ) {
                eOBusinessFinancialCoupon.setEndDate( new SimpleDateFormat().parse( dtoObject.getEndDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        eOBusinessFinancialCoupon.setType( dtoObject.getType() );
        eOBusinessFinancialCoupon.setStatus( dtoObject.getStatus() );

        return eOBusinessFinancialCoupon;
    }

    @Override
    public List<EOBusinessFinancialCoupon> mapToDAO(List<UIBusinessFinancialCoupon> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOBusinessFinancialCoupon> list = new ArrayList<EOBusinessFinancialCoupon>( dtoObjectList.size() );
        for ( UIBusinessFinancialCoupon uIBusinessFinancialCoupon : dtoObjectList ) {
            list.add( mapToDAO( uIBusinessFinancialCoupon ) );
        }

        return list;
    }

    @Override
    public List<UIBusinessFinancialCoupon> mapToDTO(List<EOBusinessFinancialCoupon> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIBusinessFinancialCoupon> list = new ArrayList<UIBusinessFinancialCoupon>( entityObjectList.size() );
        for ( EOBusinessFinancialCoupon eOBusinessFinancialCoupon : entityObjectList ) {
            list.add( mapToDTO( eOBusinessFinancialCoupon ) );
        }

        return list;
    }
}
