package org.sponsor.form.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.form.view.entities.menus.EOViewMenuItem;
import org.sponsor.form.view.mapper.ViewMenuItemMapper;
import org.sponsor.form.view.model.menus.UIViewMenuItem;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T22:45:28+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ViewMenuItemMapperImpl implements ViewMenuItemMapper {

    @Override
    public UIViewMenuItem mapToDTO(EOViewMenuItem entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIViewMenuItem uIViewMenuItem = new UIViewMenuItem();

        uIViewMenuItem.setOnBoarding( entityObject.getOnBoarding() );
        if ( entityObject.getId() != null ) {
            uIViewMenuItem.setId( entityObject.getId() );
        }
        uIViewMenuItem.setIdenNo( entityObject.getIdenNo() );
        uIViewMenuItem.setTitle( entityObject.getTitle() );
        uIViewMenuItem.setUrl( entityObject.getUrl() );
        uIViewMenuItem.setType( entityObject.getType() );
        uIViewMenuItem.setIcon( entityObject.getIcon() );
        uIViewMenuItem.setOrderSequence( entityObject.getOrderSequence() );

        return uIViewMenuItem;
    }

    @Override
    public EOViewMenuItem mapToDAO(UIViewMenuItem dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOViewMenuItem eOViewMenuItem = new EOViewMenuItem();

        eOViewMenuItem.setId( dtoObject.getId() );
        eOViewMenuItem.setOrderSequence( dtoObject.getOrderSequence() );
        eOViewMenuItem.setTitle( dtoObject.getTitle() );
        eOViewMenuItem.setUrl( dtoObject.getUrl() );
        eOViewMenuItem.setType( dtoObject.getType() );
        eOViewMenuItem.setIcon( dtoObject.getIcon() );
        eOViewMenuItem.setIdenNo( dtoObject.getIdenNo() );
        eOViewMenuItem.setOnBoarding( dtoObject.getOnBoarding() );

        return eOViewMenuItem;
    }

    @Override
    public List<EOViewMenuItem> mapToDAO(List<UIViewMenuItem> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOViewMenuItem> list = new ArrayList<EOViewMenuItem>( dtoObjectList.size() );
        for ( UIViewMenuItem uIViewMenuItem : dtoObjectList ) {
            list.add( mapToDAO( uIViewMenuItem ) );
        }

        return list;
    }

    @Override
    public List<UIViewMenuItem> mapToDTO(List<EOViewMenuItem> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIViewMenuItem> list = new ArrayList<UIViewMenuItem>( entityObjectList.size() );
        for ( EOViewMenuItem eOViewMenuItem : entityObjectList ) {
            list.add( mapToDTO( eOViewMenuItem ) );
        }

        return list;
    }
}
