package org.sponsor.account.controller;

import org.brijframework.integration.spring.rest.crud.beans.Response;
import org.brijframework.integration.spring.rest.crud.controller.CQRSController;
import org.sponsor.account.service.UserFinancialAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/api/global/user/financial/account")
@CrossOrigin("*")
public class GlobalUserFinancialAccountController {

	@Autowired
	private UserFinancialAccountService userFinancialAccountService;


	@GetMapping
	public Response<Object> fetchFinancialCurrent(
			@RequestHeader(required =false)  MultiValueMap<String,String> headers, 
			WebRequest webRequest){
		Response<Object> response=new Response<Object>();
		try {
			response.setData(userFinancialAccountService.fetchFinancialCurrent(headers));
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
