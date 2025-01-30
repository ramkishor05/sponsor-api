package org.sponsor.account.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.constants.CouponStatus;
import org.sponsor.account.constants.CouponType;
import org.sponsor.account.constants.RecordStatus;
import org.sponsor.account.entities.EOBusinessFinancialCoupon;
import org.sponsor.account.mapper.BusinessFinancialCouponMapper;
import org.sponsor.account.model.UIBusinessFinancialCoupon;
import org.sponsor.account.repository.BusinessFinancialCouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessFinancialCouponServiceImpl extends CrudServiceImpl<UIBusinessFinancialCoupon, EOBusinessFinancialCoupon, Long> implements BusinessFinancialCouponService {

	@Autowired
	private BusinessFinancialCouponRepository businessFinancialCouponRepository;
	
	@Autowired
	private BusinessFinancialCouponMapper businessFinancialCouponMapper;
	
	@Override
	public JpaRepository<EOBusinessFinancialCoupon, Long> getRepository() {
		return businessFinancialCouponRepository;
	}

	@Override
	public GenericMapper<EOBusinessFinancialCoupon, UIBusinessFinancialCoupon> getMapper() {
		return businessFinancialCouponMapper;
	}
	
	@Override
	public void postFetch(EOBusinessFinancialCoupon findObject, UIBusinessFinancialCoupon dtoObject) {
		dtoObject.setRemainingDays(calculateRemainingDays(findObject.getEndDate()));
	}
	
	private static long calculateRemainingDays(Date date) {
	    final Calendar c = Calendar.getInstance();
	    c.setTimeInMillis(date.getTime());
	    final Calendar today = Calendar.getInstance();
	    final long millis = c.getTimeInMillis()
	            - today.getTimeInMillis();
	    // Convert to days
	    final long days = millis / 86400000;
	    return days;
	}
	
	public static void main(String[] args) {
		System.out.println(calculateRemainingDays(new Date()));
	}

	@Override
	public Long getRemainingDaysForLuckyDraw() {
		Optional<EOBusinessFinancialCoupon> findBussinessSponsor= businessFinancialCouponRepository.findByTypeAndStatus(CouponType.LukcyDraw.toString(), CouponStatus.Inprocess.toString());
		if(findBussinessSponsor.isPresent()) {
			EOBusinessFinancialCoupon eoBusinessCoupon = findBussinessSponsor.get();
			return calculateRemainingDays(eoBusinessCoupon.getEndDate());
		}
		return null;
	}

	@Override
	public Long getRemainingDaysForMegaDraw() {
		Optional<EOBusinessFinancialCoupon> findBussinessSponsor= businessFinancialCouponRepository.findByTypeAndStatus(CouponType.MegaDraw.toString(), CouponStatus.Inprocess.toString());
		if(findBussinessSponsor.isPresent()) {
			EOBusinessFinancialCoupon eoBusinessCoupon = findBussinessSponsor.get();
			return calculateRemainingDays(eoBusinessCoupon.getEndDate());
		}
		return null;
	}
	
	@Override
	public void initLuckyDraw() {
		Optional<EOBusinessFinancialCoupon> findBussinessSponsor= businessFinancialCouponRepository.findByTypeAndStatus(CouponType.LukcyDraw.toString(), CouponStatus.Inprocess.toString());
		if(!findBussinessSponsor.isPresent()) {
			final Calendar currentDate = Calendar.getInstance();
			EOBusinessFinancialCoupon eoBusinessCoupon = new EOBusinessFinancialCoupon();
			eoBusinessCoupon.setRecordState(RecordStatus.ACTIVETED.getStatus());
			eoBusinessCoupon.setStartDate(new Date());
			final Calendar futureDate = Calendar.getInstance();
			futureDate.add(Calendar.MONTH, 3);
			eoBusinessCoupon.setEndDate(futureDate.getTime());
			eoBusinessCoupon.setStatus(CouponStatus.Inprocess.toString());
			eoBusinessCoupon.setType(CouponType.LukcyDraw.toString());
			DateFormat dateFormat=new SimpleDateFormat("MMM, yyyy");
			eoBusinessCoupon.setName("Lucky Draw "+dateFormat.format(currentDate.getTime())+" to "+dateFormat.format(futureDate.getTime()));
			eoBusinessCoupon.setDescription("Lucky Draw "+dateFormat.format(currentDate.getTime())+" to "+dateFormat.format(futureDate.getTime()));
			businessFinancialCouponRepository.saveAndFlush(eoBusinessCoupon);
		}
	}

	@Override
	public void initMegaDraw() {
		Optional<EOBusinessFinancialCoupon> findBussinessSponsor= businessFinancialCouponRepository.findByTypeAndStatus(CouponType.MegaDraw.toString(), CouponStatus.Inprocess.toString());
		if(!findBussinessSponsor.isPresent()) {
			final Calendar currentDate = Calendar.getInstance();
			EOBusinessFinancialCoupon eoBusinessCoupon = new EOBusinessFinancialCoupon();
			eoBusinessCoupon.setRecordState(RecordStatus.ACTIVETED.getStatus());
			eoBusinessCoupon.setStartDate(new Date());
			final Calendar futureDate = Calendar.getInstance();
			futureDate.add(Calendar.MONTH, 6);
			eoBusinessCoupon.setEndDate(futureDate.getTime());
			eoBusinessCoupon.setStatus(CouponStatus.Inprocess.toString());
			eoBusinessCoupon.setType(CouponType.MegaDraw.toString());
			DateFormat dateFormat=new SimpleDateFormat("MMM, yyyy");
			eoBusinessCoupon.setName("Mega Draw "+dateFormat.format(currentDate.getTime())+" to "+dateFormat.format(futureDate.getTime()));
			eoBusinessCoupon.setDescription("Mega Draw "+dateFormat.format(currentDate.getTime())+" to "+dateFormat.format(futureDate.getTime()));
			businessFinancialCouponRepository.saveAndFlush(eoBusinessCoupon);
		}
	}
}
