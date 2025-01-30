package org.sponsor.resource.mapper;
import static org.sponsor.resource.constants.Constants.APP_RESOURCE_PACKAGE_IMPL;
import static org.sponsor.resource.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.sponsor.resource.entities.EOResource;
import org.sponsor.resource.modal.UIResourceModel;

@Mapper(componentModel = SPRING, implementationPackage = APP_RESOURCE_PACKAGE_IMPL)
public interface ResourceMapper  extends GenericMapper<EOResource, UIResourceModel>{

}
