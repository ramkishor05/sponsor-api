package org.sponsor.access.mapper;

import static org.sponsor.access.constants.Constants.MAPPER_IMPL;
import static org.sponsor.access.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.sponsor.access.entities.EOUserRole;
import org.sponsor.access.model.UIUserRole;

@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL)
public interface UserRoleMapper extends GenericMapper<EOUserRole, UIUserRole> {

}
