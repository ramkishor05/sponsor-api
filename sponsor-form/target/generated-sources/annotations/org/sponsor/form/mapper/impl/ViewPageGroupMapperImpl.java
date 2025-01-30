package org.sponsor.form.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.form.view.entities.pages.EOViewPageGroup;
import org.sponsor.form.view.mapper.ViewPageGroupMapper;
import org.sponsor.form.view.model.pages.UIViewPageGroup;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T22:45:29+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ViewPageGroupMapperImpl implements ViewPageGroupMapper {

    @Override
    public UIViewPageGroup mapToDTO(EOViewPageGroup entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIViewPageGroup uIViewPageGroup = new UIViewPageGroup();

        if ( entityObject.getId() != null ) {
            uIViewPageGroup.setId( entityObject.getId() );
        }
        uIViewPageGroup.setIdenNo( entityObject.getIdenNo() );
        uIViewPageGroup.setTitle( entityObject.getTitle() );
        uIViewPageGroup.setUrl( entityObject.getUrl() );
        uIViewPageGroup.setType( entityObject.getType() );
        uIViewPageGroup.setIcon( entityObject.getIcon() );
        uIViewPageGroup.setOrderSequence( entityObject.getOrderSequence() );

        return uIViewPageGroup;
    }

    @Override
    public EOViewPageGroup mapToDAO(UIViewPageGroup dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOViewPageGroup eOViewPageGroup = new EOViewPageGroup();

        eOViewPageGroup.setId( dtoObject.getId() );
        eOViewPageGroup.setOrderSequence( dtoObject.getOrderSequence() );
        eOViewPageGroup.setIdenNo( dtoObject.getIdenNo() );
        eOViewPageGroup.setTitle( dtoObject.getTitle() );
        eOViewPageGroup.setUrl( dtoObject.getUrl() );
        eOViewPageGroup.setType( dtoObject.getType() );
        eOViewPageGroup.setIcon( dtoObject.getIcon() );

        return eOViewPageGroup;
    }

    @Override
    public List<EOViewPageGroup> mapToDAO(List<UIViewPageGroup> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOViewPageGroup> list = new ArrayList<EOViewPageGroup>( dtoObjectList.size() );
        for ( UIViewPageGroup uIViewPageGroup : dtoObjectList ) {
            list.add( mapToDAO( uIViewPageGroup ) );
        }

        return list;
    }

    @Override
    public List<UIViewPageGroup> mapToDTO(List<EOViewPageGroup> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIViewPageGroup> list = new ArrayList<UIViewPageGroup>( entityObjectList.size() );
        for ( EOViewPageGroup eOViewPageGroup : entityObjectList ) {
            list.add( mapToDTO( eOViewPageGroup ) );
        }

        return list;
    }
}
