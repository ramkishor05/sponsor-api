package org.sponsor.access.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.access.entities.EOUserSponsor;
import org.sponsor.access.entities.EOUserSponsorActivity;
import org.sponsor.access.mapper.UserSponsorActivityMapper;
import org.sponsor.access.model.UIUserSponsorActivity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T20:51:19+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserSponsorActivityMapperImpl implements UserSponsorActivityMapper {

    @Override
    public List<EOUserSponsorActivity> mapToDAO(List<UIUserSponsorActivity> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserSponsorActivity> list = new ArrayList<EOUserSponsorActivity>( dtoObjectList.size() );
        for ( UIUserSponsorActivity uIUserSponsorActivity : dtoObjectList ) {
            list.add( mapToDAO( uIUserSponsorActivity ) );
        }

        return list;
    }

    @Override
    public List<UIUserSponsorActivity> mapToDTO(List<EOUserSponsorActivity> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserSponsorActivity> list = new ArrayList<UIUserSponsorActivity>( entityObjectList.size() );
        for ( EOUserSponsorActivity eOUserSponsorActivity : entityObjectList ) {
            list.add( mapToDTO( eOUserSponsorActivity ) );
        }

        return list;
    }

    @Override
    public UIUserSponsorActivity mapToDTO(EOUserSponsorActivity entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserSponsorActivity uIUserSponsorActivity = new UIUserSponsorActivity();

        uIUserSponsorActivity.setUserSponsorId( entityObjectUserSponsorId( entityObject ) );
        uIUserSponsorActivity.setId( entityObject.getId() );
        uIUserSponsorActivity.setOrderSequence( entityObject.getOrderSequence() );
        uIUserSponsorActivity.setStatus( entityObject.getStatus() );
        uIUserSponsorActivity.setRemarks( entityObject.getRemarks() );

        return uIUserSponsorActivity;
    }

    @Override
    public EOUserSponsorActivity mapToDAO(UIUserSponsorActivity entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        EOUserSponsorActivity eOUserSponsorActivity = new EOUserSponsorActivity();

        eOUserSponsorActivity.setUserSponsor( uIUserSponsorActivityToEOUserSponsor( entityObject ) );
        eOUserSponsorActivity.setId( entityObject.getId() );
        eOUserSponsorActivity.setOrderSequence( entityObject.getOrderSequence() );
        eOUserSponsorActivity.setStatus( entityObject.getStatus() );
        eOUserSponsorActivity.setRemarks( entityObject.getRemarks() );

        return eOUserSponsorActivity;
    }

    private Long entityObjectUserSponsorId(EOUserSponsorActivity eOUserSponsorActivity) {
        EOUserSponsor userSponsor = eOUserSponsorActivity.getUserSponsor();
        if ( userSponsor == null ) {
            return null;
        }
        return userSponsor.getId();
    }

    protected EOUserSponsor uIUserSponsorActivityToEOUserSponsor(UIUserSponsorActivity uIUserSponsorActivity) {
        if ( uIUserSponsorActivity == null ) {
            return null;
        }

        EOUserSponsor eOUserSponsor = new EOUserSponsor();

        eOUserSponsor.setId( uIUserSponsorActivity.getUserSponsorId() );

        return eOUserSponsor;
    }
}
