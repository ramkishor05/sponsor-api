package org.sponsor.account.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class UIBusinessDashboard {

	private long totalUsers;

	private long totalSponsors;

	private double totalSponsorIncome;
	
	private double totalLevelIncome;
	
	private double totalRoyaltyIncome;
	
	private double totalBoostIncome;
	
	private Long remainingDaysForLuckyDraw;
	
	private Long remainingDaysForMegaDraw;

	public long getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(long totalUsers) {
		this.totalUsers = totalUsers;
	}

	public long getTotalSponsors() {
		return totalSponsors;
	}

	public void setTotalSponsors(long totalSponsors) {
		this.totalSponsors = totalSponsors;
	}

	public void setTotalSponsorIncome(double totalSponsorIncome) {
		this.totalSponsorIncome=totalSponsorIncome;
	}

	public double getTotalSponsorIncome() {
		return totalSponsorIncome;
	}

	public double getTotalLevelIncome() {
		return totalLevelIncome;
	}

	public void setTotalLevelIncome(double totalLevelIncome) {
		this.totalLevelIncome = totalLevelIncome;
	}

	public double getTotalRoyaltyIncome() {
		return totalRoyaltyIncome;
	}

	public void setTotalRoyaltyIncome(double totalRoyaltyIncome) {
		this.totalRoyaltyIncome = totalRoyaltyIncome;
	}

	public double getTotalBoostIncome() {
		return totalBoostIncome;
	}

	public void setTotalBoostIncome(double totalBoostIncome) {
		this.totalBoostIncome = totalBoostIncome;
	}

	public Long getRemainingDaysForLuckyDraw() {
		return remainingDaysForLuckyDraw;
	}

	public void setRemainingDaysForLuckyDraw(Long remainingDaysForLuckyDraw) {
		this.remainingDaysForLuckyDraw = remainingDaysForLuckyDraw;
	}

	public Long getRemainingDaysForMegaDraw() {
		return remainingDaysForMegaDraw;
	}

	public void setRemainingDaysForMegaDraw(Long remainingDaysForMegaDraw) {
		this.remainingDaysForMegaDraw = remainingDaysForMegaDraw;
	}
	
}
