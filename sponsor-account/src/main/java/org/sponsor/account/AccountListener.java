package org.sponsor.account;

import java.util.Optional;

import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.repository.BusinessSponsorRepository;
import org.sponsor.account.repository.UserSponsorRepository;
import org.sponsor.account.service.BusinessFinancialCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AccountListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private BusinessSponsorRepository bussinessSponsorRepository;
	
	@Autowired
	private UserSponsorRepository userSponsorRepository;
	
	@Autowired
	private BusinessFinancialCouponService businessCouponService;
	
	@Value("${spring.db.datajson.upload}")
	boolean upload;
	
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
    	if(upload) {
    		Optional<EOBusinessSponsor> findBussinessResponser = bussinessSponsorRepository.findByUserAccountId(1l);
    		if(!findBussinessResponser.isPresent()) {
    			Long nextSponsorId = bussinessSponsorRepository.nextSponsorId();
    			if(nextSponsorId==null) {
    				nextSponsorId=100000l;
    			}
    			EOBusinessSponsor eoBussinessResponser= new EOBusinessSponsor();
	    		eoBussinessResponser.setSponsorId(nextSponsorId+1);
	    		eoBussinessResponser.setUserAccountId(1l);
	    		EOBusinessSponsor eoBussinessSponsor = bussinessSponsorRepository.saveAndFlush(eoBussinessResponser);
	    		
	    		Optional<EOUserSponsor> findUserResponser = userSponsorRepository.findByUserAccountId(1l);
	    		if(!findUserResponser.isPresent()) {
	    			EOUserSponsor eoUserResponser= new EOUserSponsor();
		    		eoUserResponser.setSponsorId(nextSponsorId+1);
		    		eoUserResponser.setUserAccountId(1l);
		    		eoUserResponser.setSponsorBussiness(eoBussinessSponsor);
		    		userSponsorRepository.saveAndFlush(eoUserResponser);
	    		} 
    		} 
    	}
    	businessCouponService.initLuckyDraw();
    	businessCouponService.initMegaDraw();
    }
}