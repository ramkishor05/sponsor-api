package org.sponsor.form.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.form.view.entities.pages.EOViewPageItem;
import org.sponsor.form.view.mapper.ViewPageItemMapper;
import org.sponsor.form.view.model.pages.UIViewPageItem;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T22:45:29+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ViewPageItemMapperImpl implements ViewPageItemMapper {

    @Override
    public UIViewPageItem mapToDTO(EOViewPageItem entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIViewPageItem uIViewPageItem = new UIViewPageItem();

        uIViewPageItem.setOnBoarding( entityObject.getOnBoarding() );
        if ( entityObject.getId() != null ) {
            uIViewPageItem.setId( entityObject.getId() );
        }
        uIViewPageItem.setIdenNo( entityObject.getIdenNo() );
        uIViewPageItem.setTitle( entityObject.getTitle() );
        uIViewPageItem.setUrl( entityObject.getUrl() );
        uIViewPageItem.setType( entityObject.getType() );
        uIViewPageItem.setIcon( entityObject.getIcon() );
        uIViewPageItem.setOrderSequence( entityObject.getOrderSequence() );

        return uIViewPageItem;
    }

    @Override
    public EOViewPageItem mapToDAO(UIViewPageItem dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOViewPageItem eOViewPageItem = new EOViewPageItem();

        eOViewPageItem.setId( dtoObject.getId() );
        eOViewPageItem.setOrderSequence( dtoObject.getOrderSequence() );
        eOViewPageItem.setIdenNo( dtoObject.getIdenNo() );
        eOViewPageItem.setTitle( dtoObject.getTitle() );
        eOViewPageItem.setUrl( dtoObject.getUrl() );
        eOViewPageItem.setType( dtoObject.getType() );
        eOViewPageItem.setIcon( dtoObject.getIcon() );
        eOViewPageItem.setOnBoarding( dtoObject.getOnBoarding() );

        return eOViewPageItem;
    }

    @Override
    public List<EOViewPageItem> mapToDAO(List<UIViewPageItem> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOViewPageItem> list = new ArrayList<EOViewPageItem>( dtoObjectList.size() );
        for ( UIViewPageItem uIViewPageItem : dtoObjectList ) {
            list.add( mapToDAO( uIViewPageItem ) );
        }

        return list;
    }

    @Override
    public List<UIViewPageItem> mapToDTO(List<EOViewPageItem> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIViewPageItem> list = new ArrayList<UIViewPageItem>( entityObjectList.size() );
        for ( EOViewPageItem eOViewPageItem : entityObjectList ) {
            list.add( mapToDTO( eOViewPageItem ) );
        }

        return list;
    }
}
