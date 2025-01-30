package org.sponsor.form.view.mapper;

import static org.sponsor.form.constants.Constants.MAPPER_IMPL;
import static org.sponsor.form.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.sponsor.form.view.entities.menus.EOViewMenuGroup;
import org.sponsor.form.view.model.menus.UIViewMenuGroup;

@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL)
public interface ViewMenuGroupMapper extends GenericMapper<EOViewMenuGroup, UIViewMenuGroup> {

}
