package org.sponsor.account.service;

import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.model.UIUserSponsorModel;

public interface UserSponsorLinkTransactionService extends TransactionService{

	void addUserSponsorLinkTransaction(EOUserSponsor entity, String utrNumber, String receipt);

	void fillTransactionDetail(Long id, UIUserSponsorModel dtoObject);


}
