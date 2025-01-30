package org.sponsor.form.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuGroup;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuItem;
import org.sponsor.form.role.mapper.GlobalUserRoleMenuItemMapper;
import org.sponsor.form.role.model.menus.UIUserRoleMenuGroup;
import org.sponsor.form.role.model.menus.UIUserRoleMenuItem;
import org.sponsor.form.view.entities.menus.EOViewMenuGroup;
import org.sponsor.form.view.entities.menus.EOViewMenuItem;
import org.sponsor.form.view.model.menus.UIViewMenuGroup;
import org.sponsor.form.view.model.menus.UIViewMenuItem;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T22:45:29+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class GlobalUserRoleMenuItemMapperImpl implements GlobalUserRoleMenuItemMapper {

    @Override
    public UIUserRoleMenuItem mapToDTO(EOUserRoleMenuItem entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserRoleMenuItem uIUserRoleMenuItem = new UIUserRoleMenuItem();

        uIUserRoleMenuItem.setId( entityObject.getId() );
        uIUserRoleMenuItem.setIdenNo( entityObject.getIdenNo() );
        uIUserRoleMenuItem.setUserRoleName( entityObject.getUserRoleName() );
        uIUserRoleMenuItem.setMenuItem( eOViewMenuItemToUIViewMenuItem( entityObject.getMenuItem() ) );
        uIUserRoleMenuItem.setRoleMenuGroup( eOUserRoleMenuGroupToUIUserRoleMenuGroup( entityObject.getRoleMenuGroup() ) );

        return uIUserRoleMenuItem;
    }

    @Override
    public EOUserRoleMenuItem mapToDAO(UIUserRoleMenuItem dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOUserRoleMenuItem eOUserRoleMenuItem = new EOUserRoleMenuItem();

        eOUserRoleMenuItem.setId( dtoObject.getId() );
        eOUserRoleMenuItem.setIdenNo( dtoObject.getIdenNo() );
        eOUserRoleMenuItem.setUserRoleName( dtoObject.getUserRoleName() );
        eOUserRoleMenuItem.setMenuItem( uIViewMenuItemToEOViewMenuItem( dtoObject.getMenuItem() ) );
        eOUserRoleMenuItem.setRoleMenuGroup( uIUserRoleMenuGroupToEOUserRoleMenuGroup( dtoObject.getRoleMenuGroup() ) );

        return eOUserRoleMenuItem;
    }

    @Override
    public List<EOUserRoleMenuItem> mapToDAO(List<UIUserRoleMenuItem> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserRoleMenuItem> list = new ArrayList<EOUserRoleMenuItem>( dtoObjectList.size() );
        for ( UIUserRoleMenuItem uIUserRoleMenuItem : dtoObjectList ) {
            list.add( mapToDAO( uIUserRoleMenuItem ) );
        }

        return list;
    }

    @Override
    public List<UIUserRoleMenuItem> mapToDTO(List<EOUserRoleMenuItem> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserRoleMenuItem> list = new ArrayList<UIUserRoleMenuItem>( entityObjectList.size() );
        for ( EOUserRoleMenuItem eOUserRoleMenuItem : entityObjectList ) {
            list.add( mapToDTO( eOUserRoleMenuItem ) );
        }

        return list;
    }

    protected UIViewMenuItem eOViewMenuItemToUIViewMenuItem(EOViewMenuItem eOViewMenuItem) {
        if ( eOViewMenuItem == null ) {
            return null;
        }

        UIViewMenuItem uIViewMenuItem = new UIViewMenuItem();

        uIViewMenuItem.setOnBoarding( eOViewMenuItem.getOnBoarding() );
        if ( eOViewMenuItem.getId() != null ) {
            uIViewMenuItem.setId( eOViewMenuItem.getId() );
        }
        uIViewMenuItem.setIdenNo( eOViewMenuItem.getIdenNo() );
        uIViewMenuItem.setTitle( eOViewMenuItem.getTitle() );
        uIViewMenuItem.setUrl( eOViewMenuItem.getUrl() );
        uIViewMenuItem.setType( eOViewMenuItem.getType() );
        uIViewMenuItem.setIcon( eOViewMenuItem.getIcon() );
        uIViewMenuItem.setOrderSequence( eOViewMenuItem.getOrderSequence() );

        return uIViewMenuItem;
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

    protected UIUserRoleMenuGroup eOUserRoleMenuGroupToUIUserRoleMenuGroup(EOUserRoleMenuGroup eOUserRoleMenuGroup) {
        if ( eOUserRoleMenuGroup == null ) {
            return null;
        }

        UIUserRoleMenuGroup uIUserRoleMenuGroup = new UIUserRoleMenuGroup();

        uIUserRoleMenuGroup.setId( eOUserRoleMenuGroup.getId() );
        uIUserRoleMenuGroup.setIdenNo( eOUserRoleMenuGroup.getIdenNo() );
        uIUserRoleMenuGroup.setUserRoleName( eOUserRoleMenuGroup.getUserRoleName() );
        uIUserRoleMenuGroup.setMenuGroup( eOViewMenuGroupToUIViewMenuGroup( eOUserRoleMenuGroup.getMenuGroup() ) );

        return uIUserRoleMenuGroup;
    }

    protected EOViewMenuItem uIViewMenuItemToEOViewMenuItem(UIViewMenuItem uIViewMenuItem) {
        if ( uIViewMenuItem == null ) {
            return null;
        }

        EOViewMenuItem eOViewMenuItem = new EOViewMenuItem();

        eOViewMenuItem.setId( uIViewMenuItem.getId() );
        eOViewMenuItem.setOrderSequence( uIViewMenuItem.getOrderSequence() );
        eOViewMenuItem.setTitle( uIViewMenuItem.getTitle() );
        eOViewMenuItem.setUrl( uIViewMenuItem.getUrl() );
        eOViewMenuItem.setType( uIViewMenuItem.getType() );
        eOViewMenuItem.setIcon( uIViewMenuItem.getIcon() );
        eOViewMenuItem.setIdenNo( uIViewMenuItem.getIdenNo() );
        eOViewMenuItem.setOnBoarding( uIViewMenuItem.getOnBoarding() );

        return eOViewMenuItem;
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

    protected EOUserRoleMenuGroup uIUserRoleMenuGroupToEOUserRoleMenuGroup(UIUserRoleMenuGroup uIUserRoleMenuGroup) {
        if ( uIUserRoleMenuGroup == null ) {
            return null;
        }

        EOUserRoleMenuGroup eOUserRoleMenuGroup = new EOUserRoleMenuGroup();

        eOUserRoleMenuGroup.setId( uIUserRoleMenuGroup.getId() );
        eOUserRoleMenuGroup.setIdenNo( uIUserRoleMenuGroup.getIdenNo() );
        eOUserRoleMenuGroup.setUserRoleName( uIUserRoleMenuGroup.getUserRoleName() );
        eOUserRoleMenuGroup.setMenuGroup( uIViewMenuGroupToEOViewMenuGroup( uIUserRoleMenuGroup.getMenuGroup() ) );

        return eOUserRoleMenuGroup;
    }
}
