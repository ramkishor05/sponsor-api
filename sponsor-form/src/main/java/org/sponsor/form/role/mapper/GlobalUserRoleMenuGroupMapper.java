package org.sponsor.form.role.mapper;

import static org.sponsor.form.constants.Constants.MAPPER_IMPL;
import static org.sponsor.form.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuGroup;
import org.sponsor.form.role.model.menus.UIUserRoleMenuGroup;

@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL)
public interface GlobalUserRoleMenuGroupMapper extends GenericMapper<EOUserRoleMenuGroup, UIUserRoleMenuGroup> {

}
