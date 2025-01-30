package org.sponsor.form.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuGroup;
import org.sponsor.form.role.mapper.GlobalUserRoleMenuGroupMapper;
import org.sponsor.form.role.model.menus.UIUserRoleMenuGroup;
import org.sponsor.form.view.entities.menus.EOViewMenuGroup;
import org.sponsor.form.view.model.menus.UIViewMenuGroup;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T22:45:29+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class GlobalUserRoleMenuGroupMapperImpl implements GlobalUserRoleMenuGroupMapper {

    @Override
    public UIUserRoleMenuGroup mapToDTO(EOUserRoleMenuGroup entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserRoleMenuGroup uIUserRoleMenuGroup = new UIUserRoleMenuGroup();

        uIUserRoleMenuGroup.setId( entityObject.getId() );
        uIUserRoleMenuGroup.setIdenNo( entityObject.getIdenNo() );
        uIUserRoleMenuGroup.setUserRoleName( entityObject.getUserRoleName() );
        uIUserRoleMenuGroup.setMenuGroup( eOViewMenuGroupToUIViewMenuGroup( entityObject.getMenuGroup() ) );

        return uIUserRoleMenuGroup;
    }

    @Override
    public EOUserRoleMenuGroup mapToDAO(UIUserRoleMenuGroup dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOUserRoleMenuGroup eOUserRoleMenuGroup = new EOUserRoleMenuGroup();

        eOUserRoleMenuGroup.setId( dtoObject.getId() );
        eOUserRoleMenuGroup.setIdenNo( dtoObject.getIdenNo() );
        eOUserRoleMenuGroup.setUserRoleName( dtoObject.getUserRoleName() );
        eOUserRoleMenuGroup.setMenuGroup( uIViewMenuGroupToEOViewMenuGroup( dtoObject.getMenuGroup() ) );

        return eOUserRoleMenuGroup;
    }

    @Override
    public List<EOUserRoleMenuGroup> mapToDAO(List<UIUserRoleMenuGroup> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserRoleMenuGroup> list = new ArrayList<EOUserRoleMenuGroup>( dtoObjectList.size() );
        for ( UIUserRoleMenuGroup uIUserRoleMenuGroup : dtoObjectList ) {
            list.add( mapToDAO( uIUserRoleMenuGroup ) );
        }

        return list;
    }

    @Override
    public List<UIUserRoleMenuGroup> mapToDTO(List<EOUserRoleMenuGroup> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserRoleMenuGroup> list = new ArrayList<UIUserRoleMenuGroup>( entityObjectList.size() );
        for ( EOUserRoleMenuGroup eOUserRoleMenuGroup : entityObjectList ) {
            list.add( mapToDTO( eOUserRoleMenuGroup ) );
        }

        return list;
    }

    protected UIViewMenuGroup eOViewMenuGroupToUIViewMenuGroup(EOViewMenuGroup eOViewMenuGroup) {
        if ( eOViewMenuGroup == null ) {
            return null;
        }

        UIViewMenuGroup uIViewMenuGroup = new UIViewMenuGroup();

        if ( eOViewMenuGroup.getId() != null ) {
            uIViewMenuGroup.setId( eOViewMenuGroup.getId() );
        }
        uIViewMenuGroup.setIdenNo( eOViewMenuGroup.getIdenNo() );
        uIViewMenuGroup.setTitle( eOViewMenuGroup.getTitle() );
        uIViewMenuGroup.setUrl( eOViewMenuGroup.getUrl() );
        uIViewMenuGroup.setType( eOViewMenuGroup.getType() );
        uIViewMenuGroup.setIcon( eOViewMenuGroup.getIcon() );
        uIViewMenuGroup.setOrderSequence( eOViewMenuGroup.getOrderSequence() );

        return uIViewMenuGroup;
    }

    protected EOViewMenuGroup uIViewMenuGroupToEOViewMenuGroup(UIViewMenuGroup uIViewMenuGroup) {
        if ( uIViewMenuGroup == null ) {
            return null;
        }

        EOViewMenuGroup eOViewMenuGroup = new EOViewMenuGroup();

        eOViewMenuGroup.setId( uIViewMenuGroup.getId() );
        eOViewMenuGroup.setOrderSequence( uIViewMenuGroup.getOrderSequence() );
        eOViewMenuGroup.setIdenNo( uIViewMenuGroup.getIdenNo() );
        eOViewMenuGroup.setTitle( uIViewMenuGroup.getTitle() );
        eOViewMenuGroup.setUrl( uIViewMenuGroup.getUrl() );
        eOViewMenuGroup.setType( uIViewMenuGroup.getType() );
        eOViewMenuGroup.setIcon( uIViewMenuGroup.getIcon() );

        return eOViewMenuGroup;
    }
}
