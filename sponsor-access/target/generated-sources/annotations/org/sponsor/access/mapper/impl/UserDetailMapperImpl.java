package org.sponsor.access.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.access.entities.EOUserAccount;
import org.sponsor.access.entities.EOUserProfile;
import org.sponsor.access.entities.EOUserRole;
import org.sponsor.access.mapper.UserDetailMapper;
import org.sponsor.access.model.UIUserAccount;
import org.sponsor.access.model.UIUserDetail;
import org.sponsor.access.model.UIUserProfile;
import org.sponsor.access.model.UserDetailResponse;
import org.sponsor.access.model.UserRoleResponse;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T20:51:18+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserDetailMapperImpl implements UserDetailMapper {

    @Override
    public EOUserAccount mapToDAO(UserDetailResponse dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOUserAccount eOUserAccount = new EOUserAccount();

        eOUserAccount.setId( dtoObject.getId() );
        eOUserAccount.setUsername( dtoObject.getUsername() );
        eOUserAccount.setPassword( dtoObject.getPassword() );
        eOUserAccount.setAccountName( dtoObject.getAccountName() );
        eOUserAccount.setRegisteredMobile( dtoObject.getRegisteredMobile() );
        eOUserAccount.setRegisteredEmail( dtoObject.getRegisteredEmail() );
        eOUserAccount.setUserRole( userRoleResponseToEOUserRole( dtoObject.getUserRole() ) );

        return eOUserAccount;
    }

    @Override
    public List<EOUserAccount> mapToDAO(List<UserDetailResponse> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserAccount> list = new ArrayList<EOUserAccount>( dtoObjectList.size() );
        for ( UserDetailResponse userDetailResponse : dtoObjectList ) {
            list.add( mapToDAO( userDetailResponse ) );
        }

        return list;
    }

    @Override
    public List<UserDetailResponse> mapToDTO(List<EOUserAccount> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UserDetailResponse> list = new ArrayList<UserDetailResponse>( entityObjectList.size() );
        for ( EOUserAccount eOUserAccount : entityObjectList ) {
            list.add( mapToDTO( eOUserAccount ) );
        }

        return list;
    }

    @Override
    public UIUserAccount mapToUI(EOUserAccount eoUserAccount) {
        if ( eoUserAccount == null ) {
            return null;
        }

        UIUserAccount uIUserAccount = new UIUserAccount();

        uIUserAccount.setId( eoUserAccount.getId() );
        uIUserAccount.setPassword( eoUserAccount.getPassword() );
        uIUserAccount.setUsername( eoUserAccount.getUsername() );
        uIUserAccount.setRegisteredEmail( eoUserAccount.getRegisteredEmail() );
        uIUserAccount.setAccountName( eoUserAccount.getAccountName() );

        return uIUserAccount;
    }

    @Override
    public EOUserAccount mapToDBO(UIUserAccount uiUserAccount) {
        if ( uiUserAccount == null ) {
            return null;
        }

        EOUserAccount eOUserAccount = new EOUserAccount();

        eOUserAccount.setId( uiUserAccount.getId() );
        eOUserAccount.setUsername( uiUserAccount.getUsername() );
        eOUserAccount.setPassword( uiUserAccount.getPassword() );
        eOUserAccount.setAccountName( uiUserAccount.getAccountName() );
        eOUserAccount.setRegisteredEmail( uiUserAccount.getRegisteredEmail() );

        return eOUserAccount;
    }

    @Override
    public UIUserProfile mapUserProfileToUserProfileDTO(EOUserProfile userProfile) {
        if ( userProfile == null ) {
            return null;
        }

        UIUserProfile uIUserProfile = new UIUserProfile();

        if ( userProfile.getId() != null ) {
            uIUserProfile.setId( userProfile.getId() );
        }
        uIUserProfile.setTitle( userProfile.getTitle() );
        uIUserProfile.setFullName( userProfile.getFullName() );
        uIUserProfile.setPreferredName( userProfile.getPreferredName() );
        uIUserProfile.setPictureURL( userProfile.getPictureURL() );
        uIUserProfile.setDescription( userProfile.getDescription() );
        uIUserProfile.setDateOfBirth( userProfile.getDateOfBirth() );

        return uIUserProfile;
    }

    @Override
    public UserRoleResponse userRole(EOUserRole eoUserRole) {
        if ( eoUserRole == null ) {
            return null;
        }

        UserRoleResponse userRoleResponse = new UserRoleResponse();

        if ( eoUserRole.getId() != null ) {
            userRoleResponse.setId( eoUserRole.getId() );
        }
        userRoleResponse.setPosition( eoUserRole.getPosition() );
        userRoleResponse.setRoleName( eoUserRole.getRoleName() );
        userRoleResponse.setRoleId( eoUserRole.getRoleId() );

        return userRoleResponse;
    }

    @Override
    public UIUserDetail mapToDetailDTO(EOUserAccount eoUserAccount) {
        if ( eoUserAccount == null ) {
            return null;
        }

        UIUserDetail uIUserDetail = new UIUserDetail();

        uIUserDetail.setAuthority( authority( eoUserAccount.getUserRole() ) );
        uIUserDetail.setId( eoUserAccount.getId() );
        uIUserDetail.setOrderSequence( eoUserAccount.getOrderSequence() );
        uIUserDetail.setUsername( eoUserAccount.getUsername() );
        uIUserDetail.setRegisteredMobile( eoUserAccount.getRegisteredMobile() );
        uIUserDetail.setRegisteredEmail( eoUserAccount.getRegisteredEmail() );
        uIUserDetail.setAccountName( eoUserAccount.getAccountName() );

        return uIUserDetail;
    }

    protected EOUserRole userRoleResponseToEOUserRole(UserRoleResponse userRoleResponse) {
        if ( userRoleResponse == null ) {
            return null;
        }

        EOUserRole eOUserRole = new EOUserRole();

        eOUserRole.setId( userRoleResponse.getId() );
        eOUserRole.setPosition( userRoleResponse.getPosition() );
        eOUserRole.setRoleName( userRoleResponse.getRoleName() );
        eOUserRole.setRoleId( userRoleResponse.getRoleId() );

        return eOUserRole;
    }
}
