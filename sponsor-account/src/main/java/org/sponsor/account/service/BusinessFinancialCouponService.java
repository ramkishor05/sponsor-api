package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOBusinessFinancialCoupon;
import org.sponsor.account.model.UIBusinessFinancialCoupon;

public interface BusinessFinancialCouponService extends CrudService<UIBusinessFinancialCoupon, EOBusinessFinancialCoupon, Long>{

	Long getRemainingDaysForLuckyDraw();

	Long getRemainingDaysForMegaDraw();

	void initLuckyDraw();

	void initMegaDraw();

}
