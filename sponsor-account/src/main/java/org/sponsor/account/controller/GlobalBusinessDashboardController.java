package org.sponsor.account.controller;

import org.brijframework.integration.spring.rest.crud.beans.Response;
import org.sponsor.account.model.UIBusinessDashboard;
import org.sponsor.account.service.BusinessDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 *  @author ram kishor
 */
@RestController
@RequestMapping(value = "/api/global/business/dashboard")
@CrossOrigin("*")
public class GlobalBusinessDashboardController {
	
	/**
	 * 
	 */
	public static final String SUCCESSFULLY_PROCCEED = "Successfully procceed";
	/**
	 * 
	 */
	public static final String FAILED = "0";
	/**
	 * 
	 */
	public static final String SUCCESS = "1";
	
	@Autowired
	private BusinessDashboardService globalBusinessDashboardService;
	
	@GetMapping
	public Response<UIBusinessDashboard> getGlobalClientDashboard(
			@RequestHeader(required =false)  MultiValueMap<String,String> headers, 
			WebRequest webRequest) {
		Response<UIBusinessDashboard> response=new Response<UIBusinessDashboard>();
		try {
			response.setData(globalBusinessDashboardService.getDashboard(headers));
			response.setSuccess(SUCCESS);
			response.setMessage(SUCCESSFULLY_PROCCEED);
			return response;
		}catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(FAILED);
			response.setMessage(e.getMessage());
			return response;
		}
	}

}
