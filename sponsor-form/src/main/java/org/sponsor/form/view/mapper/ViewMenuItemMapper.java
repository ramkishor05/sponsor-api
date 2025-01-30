package org.sponsor.form.view.mapper;

import static org.sponsor.form.constants.Constants.MAPPER_IMPL;
import static org.sponsor.form.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.sponsor.form.view.entities.menus.EOViewMenuItem;
import org.sponsor.form.view.model.menus.UIViewMenuItem;

@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL)
public interface ViewMenuItemMapper extends GenericMapper<EOViewMenuItem, UIViewMenuItem> {

}
