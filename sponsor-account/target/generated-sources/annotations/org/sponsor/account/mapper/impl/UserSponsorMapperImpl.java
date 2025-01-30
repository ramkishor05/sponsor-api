package org.sponsor.account.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.mapper.UserSponsorMapper;
import org.sponsor.account.model.UIUserSponsorModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:35+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserSponsorMapperImpl implements UserSponsorMapper {

    @Override
    public EOUserSponsor mapToDAO(UIUserSponsorModel dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOUserSponsor eOUserSponsor = new EOUserSponsor();

        eOUserSponsor.setId( dtoObject.getId() );
        eOUserSponsor.setOrderSequence( dtoObject.getOrderSequence() );
        eOUserSponsor.setSponsorId( dtoObject.getSponsorId() );
        eOUserSponsor.setUtrNumber( dtoObject.getUtrNumber() );
        eOUserSponsor.setUserAccountId( dtoObject.getUserAccountId() );
        eOUserSponsor.setFullName( dtoObject.getFullName() );
        eOUserSponsor.setStatus( dtoObject.getStatus() );

        return eOUserSponsor;
    }

    @Override
    public List<EOUserSponsor> mapToDAO(List<UIUserSponsorModel> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserSponsor> list = new ArrayList<EOUserSponsor>( dtoObjectList.size() );
        for ( UIUserSponsorModel uIUserSponsorModel : dtoObjectList ) {
            list.add( mapToDAO( uIUserSponsorModel ) );
        }

        return list;
    }

    @Override
    public List<UIUserSponsorModel> mapToDTO(List<EOUserSponsor> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserSponsorModel> list = new ArrayList<UIUserSponsorModel>( entityObjectList.size() );
        for ( EOUserSponsor eOUserSponsor : entityObjectList ) {
            list.add( mapToDTO( eOUserSponsor ) );
        }

        return list;
    }

    @Override
    public UIUserSponsorModel mapToDTO(EOUserSponsor entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserSponsorModel uIUserSponsorModel = new UIUserSponsorModel();

        uIUserSponsorModel.setSponsorLeaderId( entityObjectSponsorLeaderSponsorId( entityObject ) );
        uIUserSponsorModel.setSponsorLeaderName( entityObjectSponsorLeaderFullName( entityObject ) );
        uIUserSponsorModel.setId( entityObject.getId() );
        uIUserSponsorModel.setOrderSequence( entityObject.getOrderSequence() );
        uIUserSponsorModel.setUserAccountId( entityObject.getUserAccountId() );
        uIUserSponsorModel.setFullName( entityObject.getFullName() );
        uIUserSponsorModel.setSponsorId( entityObject.getSponsorId() );
        uIUserSponsorModel.setUtrNumber( entityObject.getUtrNumber() );
        uIUserSponsorModel.setLevel( entityObject.getLevel() );
        uIUserSponsorModel.setStatus( entityObject.getStatus() );

        return uIUserSponsorModel;
    }

    private Long entityObjectSponsorLeaderSponsorId(EOUserSponsor eOUserSponsor) {
        EOUserSponsor sponsorLeader = eOUserSponsor.getSponsorLeader();
        if ( sponsorLeader == null ) {
            return null;
        }
        return sponsorLeader.getSponsorId();
    }

    private String entityObjectSponsorLeaderFullName(EOUserSponsor eOUserSponsor) {
        EOUserSponsor sponsorLeader = eOUserSponsor.getSponsorLeader();
        if ( sponsorLeader == null ) {
            return null;
        }
        return sponsorLeader.getFullName();
    }
}
