package org.sponsor.access.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.access.entities.EOUserRole;
import org.sponsor.access.mapper.UserRoleMapper;
import org.sponsor.access.model.UIUserRole;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T20:51:18+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public UIUserRole mapToDTO(EOUserRole entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserRole uIUserRole = new UIUserRole();

        if ( entityObject.getId() != null ) {
            uIUserRole.setId( entityObject.getId() );
        }
        uIUserRole.setPosition( entityObject.getPosition() );
        uIUserRole.setRoleName( entityObject.getRoleName() );
        uIUserRole.setRoleId( entityObject.getRoleId() );

        return uIUserRole;
    }

    @Override
    public EOUserRole mapToDAO(UIUserRole dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOUserRole eOUserRole = new EOUserRole();

        eOUserRole.setId( dtoObject.getId() );
        eOUserRole.setPosition( dtoObject.getPosition() );
        eOUserRole.setRoleName( dtoObject.getRoleName() );
        eOUserRole.setRoleId( dtoObject.getRoleId() );

        return eOUserRole;
    }

    @Override
    public List<EOUserRole> mapToDAO(List<UIUserRole> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserRole> list = new ArrayList<EOUserRole>( dtoObjectList.size() );
        for ( UIUserRole uIUserRole : dtoObjectList ) {
            list.add( mapToDAO( uIUserRole ) );
        }

        return list;
    }

    @Override
    public List<UIUserRole> mapToDTO(List<EOUserRole> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserRole> list = new ArrayList<UIUserRole>( entityObjectList.size() );
        for ( EOUserRole eOUserRole : entityObjectList ) {
            list.add( mapToDTO( eOUserRole ) );
        }

        return list;
    }
}
