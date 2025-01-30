package org.sponsor.account.service;

import org.sponsor.account.entities.EOUserSponsor;

public interface UserSponsorProductTransactionService {

	void addUserSponsorProductTransaction(EOUserSponsor entity, String utrNumber, String transactionReceipt);

}
