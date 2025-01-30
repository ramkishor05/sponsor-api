package org.sponsor.account.controller;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOBusinessFinancialCoupon;
import org.sponsor.account.model.UIBusinessFinancialCoupon;
import org.sponsor.account.service.BusinessFinancialCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/business/financial/coupon")
@CrossOrigin("*")
public class GlobalBusinessFinancialCouponController implements CrudController<UIBusinessFinancialCoupon, EOBusinessFinancialCoupon, Long> {

	@Autowired
	private BusinessFinancialCouponService businessFinancialCouponService;

	@Override
	public CrudService<UIBusinessFinancialCoupon, EOBusinessFinancialCoupon, Long> getService() {
		return businessFinancialCouponService;
	}

}
