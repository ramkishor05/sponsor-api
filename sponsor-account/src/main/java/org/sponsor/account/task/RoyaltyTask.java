package org.sponsor.account.task;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.repository.UserSponsorRepository;
import org.sponsor.account.service.UserSponsorRoyaltyTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class RoyaltyTask {
	
	@Autowired
	private UserSponsorRepository userSponsorRepository;
	
	@Autowired
	private UserSponsorRoyaltyTransactionService userSponsorRoyaltyTransactionService;

	@Scheduled(cron = "0 15 13 L * ?")
	public void addRoyalty() {
		List<EOUserSponsor> userSponsors = userSponsorRepository.findAllByLevel(10);
		Calendar calendar=Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		Date date = calendar.getTime();
		for(EOUserSponsor userSponsor: userSponsors) {
			userSponsorRoyaltyTransactionService.creditRoyalty(1000d,  year, month, date, userSponsor);
		}
	}

	
}
