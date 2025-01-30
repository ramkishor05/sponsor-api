package org.sponsor.access.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.access.entities.EOUserProfile;
import org.sponsor.access.mapper.UserProfileMapper;
import org.sponsor.access.model.UIUserProfile;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T20:51:19+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserProfileMapperImpl implements UserProfileMapper {

    @Override
    public UIUserProfile mapToDTO(EOUserProfile entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserProfile uIUserProfile = new UIUserProfile();

        if ( entityObject.getId() != null ) {
            uIUserProfile.setId( entityObject.getId() );
        }
        uIUserProfile.setTitle( entityObject.getTitle() );
        uIUserProfile.setFullName( entityObject.getFullName() );
        uIUserProfile.setPreferredName( entityObject.getPreferredName() );
        uIUserProfile.setPictureURL( entityObject.getPictureURL() );
        uIUserProfile.setDescription( entityObject.getDescription() );
        uIUserProfile.setDateOfBirth( entityObject.getDateOfBirth() );

        return uIUserProfile;
    }

    @Override
    public EOUserProfile mapToDAO(UIUserProfile dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOUserProfile eOUserProfile = new EOUserProfile();

        eOUserProfile.setId( dtoObject.getId() );
        eOUserProfile.setTitle( dtoObject.getTitle() );
        eOUserProfile.setFullName( dtoObject.getFullName() );
        eOUserProfile.setPreferredName( dtoObject.getPreferredName() );
        eOUserProfile.setPictureURL( dtoObject.getPictureURL() );
        eOUserProfile.setDescription( dtoObject.getDescription() );
        eOUserProfile.setDateOfBirth( dtoObject.getDateOfBirth() );

        return eOUserProfile;
    }

    @Override
    public List<EOUserProfile> mapToDAO(List<UIUserProfile> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserProfile> list = new ArrayList<EOUserProfile>( dtoObjectList.size() );
        for ( UIUserProfile uIUserProfile : dtoObjectList ) {
            list.add( mapToDAO( uIUserProfile ) );
        }

        return list;
    }

    @Override
    public List<UIUserProfile> mapToDTO(List<EOUserProfile> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserProfile> list = new ArrayList<UIUserProfile>( entityObjectList.size() );
        for ( EOUserProfile eOUserProfile : entityObjectList ) {
            list.add( mapToDTO( eOUserProfile ) );
        }

        return list;
    }
}
