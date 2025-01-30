package org.sponsor.form.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.form.view.entities.menus.EOViewMenuGroup;
import org.sponsor.form.view.mapper.ViewMenuGroupMapper;
import org.sponsor.form.view.model.menus.UIViewMenuGroup;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T22:45:29+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ViewMenuGroupMapperImpl implements ViewMenuGroupMapper {

    @Override
    public UIViewMenuGroup mapToDTO(EOViewMenuGroup entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIViewMenuGroup uIViewMenuGroup = new UIViewMenuGroup();

        if ( entityObject.getId() != null ) {
            uIViewMenuGroup.setId( entityObject.getId() );
        }
        uIViewMenuGroup.setIdenNo( entityObject.getIdenNo() );
        uIViewMenuGroup.setTitle( entityObject.getTitle() );
        uIViewMenuGroup.setUrl( entityObject.getUrl() );
        uIViewMenuGroup.setType( entityObject.getType() );
        uIViewMenuGroup.setIcon( entityObject.getIcon() );
        uIViewMenuGroup.setOrderSequence( entityObject.getOrderSequence() );

        return uIViewMenuGroup;
    }

    @Override
    public EOViewMenuGroup mapToDAO(UIViewMenuGroup dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOViewMenuGroup eOViewMenuGroup = new EOViewMenuGroup();

        eOViewMenuGroup.setId( dtoObject.getId() );
        eOViewMenuGroup.setOrderSequence( dtoObject.getOrderSequence() );
        eOViewMenuGroup.setIdenNo( dtoObject.getIdenNo() );
        eOViewMenuGroup.setTitle( dtoObject.getTitle() );
        eOViewMenuGroup.setUrl( dtoObject.getUrl() );
        eOViewMenuGroup.setType( dtoObject.getType() );
        eOViewMenuGroup.setIcon( dtoObject.getIcon() );

        return eOViewMenuGroup;
    }

    @Override
    public List<EOViewMenuGroup> mapToDAO(List<UIViewMenuGroup> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOViewMenuGroup> list = new ArrayList<EOViewMenuGroup>( dtoObjectList.size() );
        for ( UIViewMenuGroup uIViewMenuGroup : dtoObjectList ) {
            list.add( mapToDAO( uIViewMenuGroup ) );
        }

        return list;
    }

    @Override
    public List<UIViewMenuGroup> mapToDTO(List<EOViewMenuGroup> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIViewMenuGroup> list = new ArrayList<UIViewMenuGroup>( entityObjectList.size() );
        for ( EOViewMenuGroup eOViewMenuGroup : entityObjectList ) {
            list.add( mapToDTO( eOViewMenuGroup ) );
        }

        return list;
    }
}
