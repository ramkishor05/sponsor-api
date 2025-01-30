
package org.sponsor.account.service;

import java.util.Date;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.entities.EOUserSponsorRoyaltyTransaction;
import org.sponsor.account.model.UIUserSponsorRoyaltyTransaction;

public interface UserSponsorRoyaltyTransactionService extends CrudService<UIUserSponsorRoyaltyTransaction, EOUserSponsorRoyaltyTransaction, Long>{

	EOUserSponsorRoyaltyTransaction creditRoyalty(double amount, int year, int month, Date date, EOUserSponsor userSponsor);
}
