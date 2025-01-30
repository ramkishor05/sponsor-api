package org.sponsor.account.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOUserFinancialWalletTransaction;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.entities.EOUserSponsorRoyaltyTransaction;
import org.sponsor.account.mapper.UserSponsorRoyaltyTransactionMapper;
import org.sponsor.account.model.UIUserSponsorRoyaltyTransaction;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:34+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserSponsorRoyaltyTransactionMapperImpl implements UserSponsorRoyaltyTransactionMapper {

    @Override
    public EOUserSponsorRoyaltyTransaction mapToDAO(UIUserSponsorRoyaltyTransaction dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOUserSponsorRoyaltyTransaction eOUserSponsorRoyaltyTransaction = new EOUserSponsorRoyaltyTransaction();

        eOUserSponsorRoyaltyTransaction.setId( dtoObject.getId() );
        eOUserSponsorRoyaltyTransaction.setOrderSequence( dtoObject.getOrderSequence() );
        eOUserSponsorRoyaltyTransaction.setMonth( dtoObject.getMonth() );
        eOUserSponsorRoyaltyTransaction.setYear( dtoObject.getYear() );
        eOUserSponsorRoyaltyTransaction.setTrsDate( dtoObject.getTrsDate() );

        return eOUserSponsorRoyaltyTransaction;
    }

    @Override
    public List<EOUserSponsorRoyaltyTransaction> mapToDAO(List<UIUserSponsorRoyaltyTransaction> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserSponsorRoyaltyTransaction> list = new ArrayList<EOUserSponsorRoyaltyTransaction>( dtoObjectList.size() );
        for ( UIUserSponsorRoyaltyTransaction uIUserSponsorRoyaltyTransaction : dtoObjectList ) {
            list.add( mapToDAO( uIUserSponsorRoyaltyTransaction ) );
        }

        return list;
    }

    @Override
    public List<UIUserSponsorRoyaltyTransaction> mapToDTO(List<EOUserSponsorRoyaltyTransaction> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserSponsorRoyaltyTransaction> list = new ArrayList<UIUserSponsorRoyaltyTransaction>( entityObjectList.size() );
        for ( EOUserSponsorRoyaltyTransaction eOUserSponsorRoyaltyTransaction : entityObjectList ) {
            list.add( mapToDTO( eOUserSponsorRoyaltyTransaction ) );
        }

        return list;
    }

    @Override
    public UIUserSponsorRoyaltyTransaction mapToDTO(EOUserSponsorRoyaltyTransaction entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserSponsorRoyaltyTransaction uIUserSponsorRoyaltyTransaction = new UIUserSponsorRoyaltyTransaction();

        uIUserSponsorRoyaltyTransaction.setAmount( entityObjectUserWalletTransactionAmount( entityObject ) );
        Long sponsorId = entityObjectUserSponsorSponsorId( entityObject );
        if ( sponsorId != null ) {
            uIUserSponsorRoyaltyTransaction.setSponsorId( String.valueOf( sponsorId ) );
        }
        uIUserSponsorRoyaltyTransaction.setId( entityObject.getId() );
        uIUserSponsorRoyaltyTransaction.setOrderSequence( entityObject.getOrderSequence() );
        uIUserSponsorRoyaltyTransaction.setMonth( entityObject.getMonth() );
        uIUserSponsorRoyaltyTransaction.setYear( entityObject.getYear() );
        uIUserSponsorRoyaltyTransaction.setTrsDate( entityObject.getTrsDate() );

        return uIUserSponsorRoyaltyTransaction;
    }

    private Double entityObjectUserWalletTransactionAmount(EOUserSponsorRoyaltyTransaction eOUserSponsorRoyaltyTransaction) {
        EOUserFinancialWalletTransaction userWalletTransaction = eOUserSponsorRoyaltyTransaction.getUserWalletTransaction();
        if ( userWalletTransaction == null ) {
            return null;
        }
        return userWalletTransaction.getAmount();
    }

    private Long entityObjectUserSponsorSponsorId(EOUserSponsorRoyaltyTransaction eOUserSponsorRoyaltyTransaction) {
        EOUserSponsor userSponsor = eOUserSponsorRoyaltyTransaction.getUserSponsor();
        if ( userSponsor == null ) {
            return null;
        }
        return userSponsor.getSponsorId();
    }
}
