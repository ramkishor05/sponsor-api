package org.sponsor.account.controller;

import org.brijframework.integration.spring.rest.crud.beans.Response;
import org.brijframework.integration.spring.rest.crud.controller.CQRSController;
import org.sponsor.account.service.BusinessFinancialWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/api/global/business/financial/wallet")
@CrossOrigin("*")
public class GlobalBusinessFinancialWalletController {

	@Autowired
	private BusinessFinancialWalletService businessFinancialWalletService;

	@GetMapping
	public Response<Object> fetchCurrent(
			@RequestHeader(required =false)  MultiValueMap<String,String> headers, 
			WebRequest webRequest){
		Response<Object> response=new Response<Object>();
		try {
			response.setData(businessFinancialWalletService.fetchCurrent());
			response.setSuccess(CQRSController.SUCCESS);
			response.setMessage(CQRSController.SUCCESSFULLY_PROCCEED);
			return response;
		}catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(CQRSController.FAILED);
			response.setMessage(e.getMessage());
			return response;
		}
	}
}
