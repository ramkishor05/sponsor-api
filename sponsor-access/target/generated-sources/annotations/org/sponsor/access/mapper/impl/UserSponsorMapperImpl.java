package org.sponsor.access.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.access.entities.EOUserAccount;
import org.sponsor.access.entities.EOUserSponsor;
import org.sponsor.access.entities.EOUserSponsorActivity;
import org.sponsor.access.mapper.UserSponsorActivityMapper;
import org.sponsor.access.mapper.UserSponsorMapper;
import org.sponsor.access.model.UIUserAccount;
import org.sponsor.access.model.UIUserSponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T20:51:18+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserSponsorMapperImpl implements UserSponsorMapper {

    @Autowired
    private UserSponsorActivityMapper userSponsorActivityMapper;

    @Override
    public List<EOUserSponsor> mapToDAO(List<UIUserSponsor> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserSponsor> list = new ArrayList<EOUserSponsor>( dtoObjectList.size() );
        for ( UIUserSponsor uIUserSponsor : dtoObjectList ) {
            list.add( mapToDAO( uIUserSponsor ) );
        }

        return list;
    }

    @Override
    public List<UIUserSponsor> mapToDTO(List<EOUserSponsor> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserSponsor> list = new ArrayList<UIUserSponsor>( entityObjectList.size() );
        for ( EOUserSponsor eOUserSponsor : entityObjectList ) {
            list.add( mapToDTO( eOUserSponsor ) );
        }

        return list;
    }

    @Override
    public UIUserSponsor mapToDTO(EOUserSponsor entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserSponsor uIUserSponsor = new UIUserSponsor();

        uIUserSponsor.setUserAccountId( entityObjectUserAccountId( entityObject ) );
        uIUserSponsor.setStatus( entityObjectActivityStatus( entityObject ) );
        uIUserSponsor.setId( entityObject.getId() );
        uIUserSponsor.setOrderSequence( entityObject.getOrderSequence() );
        uIUserSponsor.setSponsorLeaderId( entityObject.getSponsorLeaderId() );
        if ( entityObject.getUtrNumber() != null ) {
            uIUserSponsor.setUtrNumber( Long.parseLong( entityObject.getUtrNumber() ) );
        }
        uIUserSponsor.setPaymentReceipt( entityObject.getPaymentReceipt() );
        uIUserSponsor.setActivity( userSponsorActivityMapper.mapToDTO( entityObject.getActivity() ) );
        uIUserSponsor.setUserAccount( eOUserAccountToUIUserAccount( entityObject.getUserAccount() ) );

        return uIUserSponsor;
    }

    @Override
    public EOUserSponsor mapToDAO(UIUserSponsor entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        EOUserSponsor eOUserSponsor = new EOUserSponsor();

        eOUserSponsor.setUserAccount( uIUserSponsorToEOUserAccount( entityObject ) );
        eOUserSponsor.setId( entityObject.getId() );
        eOUserSponsor.setOrderSequence( entityObject.getOrderSequence() );
        eOUserSponsor.setSponsorLeaderId( entityObject.getSponsorLeaderId() );
        eOUserSponsor.setPaymentReceipt( entityObject.getPaymentReceipt() );
        if ( entityObject.getUtrNumber() != null ) {
            eOUserSponsor.setUtrNumber( String.valueOf( entityObject.getUtrNumber() ) );
        }
        eOUserSponsor.setActivity( userSponsorActivityMapper.mapToDAO( entityObject.getActivity() ) );

        return eOUserSponsor;
    }

    private Long entityObjectUserAccountId(EOUserSponsor eOUserSponsor) {
        EOUserAccount userAccount = eOUserSponsor.getUserAccount();
        if ( userAccount == null ) {
            return null;
        }
        return userAccount.getId();
    }

    private String entityObjectActivityStatus(EOUserSponsor eOUserSponsor) {
        EOUserSponsorActivity activity = eOUserSponsor.getActivity();
        if ( activity == null ) {
            return null;
        }
        return activity.getStatus();
    }

    protected UIUserAccount eOUserAccountToUIUserAccount(EOUserAccount eOUserAccount) {
        if ( eOUserAccount == null ) {
            return null;
        }

        UIUserAccount uIUserAccount = new UIUserAccount();

        uIUserAccount.setId( eOUserAccount.getId() );
        uIUserAccount.setPassword( eOUserAccount.getPassword() );
        uIUserAccount.setUsername( eOUserAccount.getUsername() );
        uIUserAccount.setRegisteredEmail( eOUserAccount.getRegisteredEmail() );
        uIUserAccount.setAccountName( eOUserAccount.getAccountName() );

        return uIUserAccount;
    }

    protected EOUserAccount uIUserSponsorToEOUserAccount(UIUserSponsor uIUserSponsor) {
        if ( uIUserSponsor == null ) {
            return null;
        }

        EOUserAccount eOUserAccount = new EOUserAccount();

        eOUserAccount.setId( uIUserSponsor.getUserAccountId() );

        return eOUserAccount;
    }
}
