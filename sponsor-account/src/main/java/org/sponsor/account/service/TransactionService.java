package org.sponsor.account.service;

public interface TransactionService {

	static final String TRANSACTION_FEES = "Transaction fees";

	static final double FEES_10D = 10d;


	public default double finalAmount(double amount) {
		return amount>60?  amount-FEES_10D: amount;
	}
	
	public default double finalFees(double amount) {
		return amount>60?  FEES_10D: 0d;
	}

}
