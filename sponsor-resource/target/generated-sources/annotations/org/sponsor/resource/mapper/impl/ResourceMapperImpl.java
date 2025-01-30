package org.sponsor.resource.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.resource.entities.EOResource;
import org.sponsor.resource.mapper.ResourceMapper;
import org.sponsor.resource.modal.UIResourceModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-28T15:21:31+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ResourceMapperImpl implements ResourceMapper {

    @Override
    public UIResourceModel mapToDTO(EOResource entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIResourceModel uIResourceModel = new UIResourceModel();

        uIResourceModel.setId( entityObject.getId() );
        uIResourceModel.setOrderSequence( entityObject.getOrderSequence() );
        uIResourceModel.setRecordState( entityObject.getRecordState() );
        uIResourceModel.setFolderName( entityObject.getFolderName() );
        uIResourceModel.setFileName( entityObject.getFileName() );
        uIResourceModel.setFileContent( entityObject.getFileContent() );
        uIResourceModel.setPosterName( entityObject.getPosterName() );
        uIResourceModel.setPosterContent( entityObject.getPosterContent() );

        return uIResourceModel;
    }

    @Override
    public EOResource mapToDAO(UIResourceModel dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOResource eOResource = new EOResource();

        eOResource.setId( dtoObject.getId() );
        eOResource.setRecordState( dtoObject.getRecordState() );
        eOResource.setOrderSequence( dtoObject.getOrderSequence() );
        eOResource.setFolderName( dtoObject.getFolderName() );
        eOResource.setFileName( dtoObject.getFileName() );
        eOResource.setFileContent( dtoObject.getFileContent() );
        eOResource.setPosterName( dtoObject.getPosterName() );
        eOResource.setPosterContent( dtoObject.getPosterContent() );

        return eOResource;
    }

    @Override
    public List<EOResource> mapToDAO(List<UIResourceModel> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOResource> list = new ArrayList<EOResource>( dtoObjectList.size() );
        for ( UIResourceModel uIResourceModel : dtoObjectList ) {
            list.add( mapToDAO( uIResourceModel ) );
        }

        return list;
    }

    @Override
    public List<UIResourceModel> mapToDTO(List<EOResource> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIResourceModel> list = new ArrayList<UIResourceModel>( entityObjectList.size() );
        for ( EOResource eOResource : entityObjectList ) {
            list.add( mapToDTO( eOResource ) );
        }

        return list;
    }
}
