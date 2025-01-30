package org.sponsor.account.service;

import org.sponsor.account.entities.EOUserSponsor;

public interface UserSponsorEntryTransactionService extends TransactionService{

	void addUserSponsorEntryTransaction(EOUserSponsor entity, String utrNumber, String receipt);

}
