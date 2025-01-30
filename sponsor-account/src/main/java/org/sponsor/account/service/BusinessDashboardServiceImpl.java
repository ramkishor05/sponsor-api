package org.sponsor.account.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sponsor.account.model.UIBusinessDashboard;
import org.sponsor.account.model.UIUserSponsorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessDashboardServiceImpl implements BusinessDashboardService {

	private static final Logger LOGGER= LoggerFactory.getLogger(BusinessDashboardServiceImpl.class);

	@Autowired
	private UserSponsorService userSponsorService;
	
	@Autowired
	private BusinessFinancialCouponService businessFinancialCouponService;

	@Override
	public UIBusinessDashboard getDashboard(Map<String, List<String>> headers) {
		LOGGER.warn("Start geting the data for dashboard");
		UIBusinessDashboard clientDashboard=new UIBusinessDashboard();
		List<UIUserSponsorModel> findAll = userSponsorService.findAllByCurrent(headers);
		clientDashboard.setTotalSponsors(findAll.size());
		
		double totalSponsorIncome = findAll.stream().filter(sponsor->sponsor.getSponsorIncome()!=null).map(sponsor->sponsor.getSponsorIncome()).collect(Collectors.summarizingDouble(a->a)).getSum();
		clientDashboard.setTotalSponsorIncome(totalSponsorIncome);
		
		double totalLevelIncome=findAll.stream().filter(sponsor->sponsor.getLevelIncome()!=null).map(sponsor->sponsor.getLevelIncome()).collect(Collectors.summarizingDouble(a->a)).getSum();
		clientDashboard.setTotalLevelIncome(totalLevelIncome);
		
		double totalRoyaltyIncome=findAll.stream().filter(sponsor->sponsor.getRoyaltyIncome()!=null).map(sponsor->sponsor.getRoyaltyIncome()).collect(Collectors.summarizingDouble(a->a)).getSum();
		clientDashboard.setTotalRoyaltyIncome(totalRoyaltyIncome);
		
		double totalBoostIncome=findAll.stream().filter(sponsor->sponsor.getBoostIncome()!=null).map(sponsor->sponsor.getBoostIncome()).collect(Collectors.summarizingDouble(a->a)).getSum();
		clientDashboard.setTotalBoostIncome(totalBoostIncome);
		
		clientDashboard.setRemainingDaysForLuckyDraw(businessFinancialCouponService.getRemainingDaysForLuckyDraw());
		
		clientDashboard.setRemainingDaysForMegaDraw(businessFinancialCouponService.getRemainingDaysForMegaDraw());

		LOGGER.warn("End geting the data for dashboard");
		return clientDashboard;
	}
	
}
