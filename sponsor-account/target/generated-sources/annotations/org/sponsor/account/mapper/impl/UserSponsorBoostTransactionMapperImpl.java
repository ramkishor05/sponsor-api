package org.sponsor.account.mapper.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.sponsor.account.entities.EOUserFinancialWalletTransaction;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.entities.EOUserSponsorBoostTransaction;
import org.sponsor.account.mapper.UserSponsorBoostTransactionMapper;
import org.sponsor.account.model.UIUserSponsorBoostTransaction;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T17:06:35+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserSponsorBoostTransactionMapperImpl implements UserSponsorBoostTransactionMapper {

    @Override
    public EOUserSponsorBoostTransaction mapToDAO(UIUserSponsorBoostTransaction dtoObject) {
        if ( dtoObject == null ) {
            return null;
        }

        EOUserSponsorBoostTransaction eOUserSponsorBoostTransaction = new EOUserSponsorBoostTransaction();

        eOUserSponsorBoostTransaction.setId( dtoObject.getId() );
        eOUserSponsorBoostTransaction.setOrderSequence( dtoObject.getOrderSequence() );
        eOUserSponsorBoostTransaction.setStatus( dtoObject.getStatus() );

        return eOUserSponsorBoostTransaction;
    }

    @Override
    public List<EOUserSponsorBoostTransaction> mapToDAO(List<UIUserSponsorBoostTransaction> dtoObjectList) {
        if ( dtoObjectList == null ) {
            return null;
        }

        List<EOUserSponsorBoostTransaction> list = new ArrayList<EOUserSponsorBoostTransaction>( dtoObjectList.size() );
        for ( UIUserSponsorBoostTransaction uIUserSponsorBoostTransaction : dtoObjectList ) {
            list.add( mapToDAO( uIUserSponsorBoostTransaction ) );
        }

        return list;
    }

    @Override
    public List<UIUserSponsorBoostTransaction> mapToDTO(List<EOUserSponsorBoostTransaction> entityObjectList) {
        if ( entityObjectList == null ) {
            return null;
        }

        List<UIUserSponsorBoostTransaction> list = new ArrayList<UIUserSponsorBoostTransaction>( entityObjectList.size() );
        for ( EOUserSponsorBoostTransaction eOUserSponsorBoostTransaction : entityObjectList ) {
            list.add( mapToDTO( eOUserSponsorBoostTransaction ) );
        }

        return list;
    }

    @Override
    public UIUserSponsorBoostTransaction mapToDTO(EOUserSponsorBoostTransaction entityObject) {
        if ( entityObject == null ) {
            return null;
        }

        UIUserSponsorBoostTransaction uIUserSponsorBoostTransaction = new UIUserSponsorBoostTransaction();

        uIUserSponsorBoostTransaction.setInvestAmount( entityObjectInvestTransactionAmount( entityObject ) );
        Date trsDate = entityObjectInvestTransactionTrsDate( entityObject );
        if ( trsDate != null ) {
            uIUserSponsorBoostTransaction.setInvestDate( new SimpleDateFormat().format( trsDate ) );
        }
        uIUserSponsorBoostTransaction.setReturnAmount( entityObjectReturnTransactionAmount( entityObject ) );
        Date trsDate1 = entityObjectReturnTransactionTrsDate( entityObject );
        if ( trsDate1 != null ) {
            uIUserSponsorBoostTransaction.setReturnDate( new SimpleDateFormat().format( trsDate1 ) );
        }
        uIUserSponsorBoostTransaction.setSponsorId( entityObjectUserSponsorSponsorId( entityObject ) );
        uIUserSponsorBoostTransaction.setId( entityObject.getId() );
        uIUserSponsorBoostTransaction.setOrderSequence( entityObject.getOrderSequence() );
        uIUserSponsorBoostTransaction.setStatus( entityObject.getStatus() );

        return uIUserSponsorBoostTransaction;
    }

    private Double entityObjectInvestTransactionAmount(EOUserSponsorBoostTransaction eOUserSponsorBoostTransaction) {
        EOUserFinancialWalletTransaction investTransaction = eOUserSponsorBoostTransaction.getInvestTransaction();
        if ( investTransaction == null ) {
            return null;
        }
        return investTransaction.getAmount();
    }

    private Date entityObjectInvestTransactionTrsDate(EOUserSponsorBoostTransaction eOUserSponsorBoostTransaction) {
        EOUserFinancialWalletTransaction investTransaction = eOUserSponsorBoostTransaction.getInvestTransaction();
        if ( investTransaction == null ) {
            return null;
        }
        return investTransaction.getTrsDate();
    }

    private Double entityObjectReturnTransactionAmount(EOUserSponsorBoostTransaction eOUserSponsorBoostTransaction) {
        EOUserFinancialWalletTransaction returnTransaction = eOUserSponsorBoostTransaction.getReturnTransaction();
        if ( returnTransaction == null ) {
            return null;
        }
        return returnTransaction.getAmount();
    }

    private Date entityObjectReturnTransactionTrsDate(EOUserSponsorBoostTransaction eOUserSponsorBoostTransaction) {
        EOUserFinancialWalletTransaction returnTransaction = eOUserSponsorBoostTransaction.getReturnTransaction();
        if ( returnTransaction == null ) {
            return null;
        }
        return returnTransaction.getTrsDate();
    }

    private Long entityObjectUserSponsorSponsorId(EOUserSponsorBoostTransaction eOUserSponsorBoostTransaction) {
        EOUserSponsor userSponsor = eOUserSponsorBoostTransaction.getUserSponsor();
        if ( userSponsor == null ) {
            return null;
        }
        return userSponsor.getSponsorId();
    }
}
