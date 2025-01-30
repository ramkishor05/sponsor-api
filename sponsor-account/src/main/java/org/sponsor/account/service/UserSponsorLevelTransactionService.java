package org.sponsor.account.service;

import org.sponsor.account.entities.EOUserSponsor;

public interface UserSponsorLevelTransactionService extends TransactionService {

	void fillLevel(EOUserSponsor sponsorLeader);

	Double totalLevelIncome(Long id);

	void addLevelIncome(EOUserSponsor sponsorLeader, Long level, Double amount);

}
