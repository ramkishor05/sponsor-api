package org.sponsor.account.service;

import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.entities.EOBusinessSponsorEntryTransaction;
import org.sponsor.account.entities.EOUserSponsor;

public interface BusinessSponsorEntryTransactionService extends TransactionService{

	EOBusinessSponsorEntryTransaction addBussinessSponsorEntryTransaction(EOBusinessSponsor sponsorBussiness, EOUserSponsor sponsorLink,
			String utrNumber);

}
