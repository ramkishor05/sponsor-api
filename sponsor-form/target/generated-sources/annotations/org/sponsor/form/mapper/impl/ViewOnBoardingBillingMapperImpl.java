package org.sponsor.form.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.form.view.entities.onboarding.EOViewOnBoardingBilling;
import org.sponsor.form.view.mapper.ViewOnBoardingBillingMapper;
import org.sponsor.form.view.model.onboadring.UIViewOnBoardingBilling;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T22:45:29+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ViewOnBoardingBillingMapperImpl implements ViewOnBoardingBillingMapper {

    @Override
    public UIViewOnBoardingBilling mapToDTO(EOViewOnBoardingBilling entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIViewOnBoardingBilling uIViewOnBoardingBilling = new UIViewOnBoardingBilling();

        uIViewOnBoardingBilling.setId( entityObject.getId() );
        uIViewOnBoardingBilling.setOrderSequence( entityObject.getOrderSequence() );
        uIViewOnBoardingBilling.setRecordState( entityObject.getRecordState() );
        uIViewOnBoardingBilling.setIdenNo( entityObject.getIdenNo() );
        uIViewOnBoardingBilling.setType( entityObject.getType() );
        uIViewOnBoardingBilling.setService( entityObject.getService() );
        uIViewOnBoardingBilling.setAmount( entityObject.getAmount() );
        uIViewOnBoardingBilling.setDiscount( entityObject.getDiscount() );

        return uIViewOnBoardingBilling;
    }

    @Override
    public EOViewOnBoardingBilling mapToDAO(UIViewOnBoardingBilling dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOViewOnBoardingBilling eOViewOnBoardingBilling = new EOViewOnBoardingBilling();

        eOViewOnBoardingBilling.setId( dtoObject.getId() );
        eOViewOnBoardingBilling.setRecordState( dtoObject.getRecordState() );
        eOViewOnBoardingBilling.setOrderSequence( dtoObject.getOrderSequence() );
        eOViewOnBoardingBilling.setIdenNo( dtoObject.getIdenNo() );
        eOViewOnBoardingBilling.setType( dtoObject.getType() );
        eOViewOnBoardingBilling.setService( dtoObject.getService() );
        eOViewOnBoardingBilling.setAmount( dtoObject.getAmount() );
        eOViewOnBoardingBilling.setDiscount( dtoObject.getDiscount() );

        return eOViewOnBoardingBilling;
    }

    @Override
    public List<EOViewOnBoardingBilling> mapToDAO(List<UIViewOnBoardingBilling> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOViewOnBoardingBilling> list = new ArrayList<EOViewOnBoardingBilling>( dtoObjectList.size() );
        for ( UIViewOnBoardingBilling uIViewOnBoardingBilling : dtoObjectList ) {
            list.add( mapToDAO( uIViewOnBoardingBilling ) );
        }

        return list;
    }

    @Override
    public List<UIViewOnBoardingBilling> mapToDTO(List<EOViewOnBoardingBilling> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIViewOnBoardingBilling> list = new ArrayList<UIViewOnBoardingBilling>( entityObjectList.size() );
        for ( EOViewOnBoardingBilling eOViewOnBoardingBilling : entityObjectList ) {
            list.add( mapToDTO( eOViewOnBoardingBilling ) );
        }

        return list;
    }
}
