package org.sponsor.access.mapper;

import static org.sponsor.access.constants.Constants.MAPPER_IMPL;
import static org.sponsor.access.constants.Constants.SPRING;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sponsor.access.constants.Authority;
import org.sponsor.access.entities.EOUserAccount;
import org.sponsor.access.entities.EOUserProfile;
import org.sponsor.access.entities.EOUserRole;
import org.sponsor.access.model.UIUserAccount;
import org.sponsor.access.model.UIUserDetail;
import org.sponsor.access.model.UIUserProfile;
import org.sponsor.access.model.UserDetailResponse;
import org.sponsor.access.model.UserRoleResponse;


@Mapper(componentModel = SPRING, implementationPackage = MAPPER_IMPL)
public interface UserDetailMapper extends GenericMapper<EOUserAccount, UserDetailResponse> {
	
	UIUserAccount mapToUI(EOUserAccount eoUserAccount);
	
	EOUserAccount mapToDBO(UIUserAccount uiUserAccount);

	@Override
	default UserDetailResponse mapToDTO(EOUserAccount eoUserAccount) {
		if ( eoUserAccount == null ) {
            return null;
        }

        UserDetailResponse userDetailResponse = new UserDetailResponse();

        if ( eoUserAccount.getId() != null ) {
            userDetailResponse.setId( eoUserAccount.getId() );
        }
        userDetailResponse.setUsername( eoUserAccount.getUsername() );
        userDetailResponse.setAccountName( eoUserAccount.getAccountName() );
        userDetailResponse.setRegisteredEmail( eoUserAccount.getRegisteredEmail() );
        userDetailResponse.setRegisteredMobile( eoUserAccount.getRegisteredMobile() );
        userDetailResponse.setUserRole( userRole( eoUserAccount.getUserRole() ) );
        return userDetailResponse;
	}

	
	UIUserProfile mapUserProfileToUserProfileDTO(EOUserProfile userProfile);

	UserRoleResponse userRole(EOUserRole eoUserRole);
	
	
	@Mapping(target = "authority", source = "userRole")
	UIUserDetail mapToDetailDTO(EOUserAccount eoUserAccount);
	
	default Authority authority(EOUserRole eoUserRole) {
		return Authority.valueOf(eoUserRole.getRoleId());
	}
	
}
