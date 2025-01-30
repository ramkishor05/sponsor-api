package org.sponsor.access.mapper;

import static org.sponsor.access.constants.Constants.MAPPER_IMPL;
import static org.sponsor.access.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.sponsor.access.entities.EOUserProfile;
import org.sponsor.access.model.UIUserProfile;

@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL)
public interface UserProfileMapper extends GenericMapper<EOUserProfile, UIUserProfile> {

}
