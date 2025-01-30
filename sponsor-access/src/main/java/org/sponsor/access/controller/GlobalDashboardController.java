package org.sponsor.access.controller;

import org.brijframework.integration.spring.rest.crud.beans.Response;
import org.sponsor.access.model.UIGlobalDashboard;
import org.sponsor.access.service.GlobalDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @author ram kishor
 */
@RestController
@RequestMapping(value = "/api/global/dashboard")
@CrossOrigin("*")
public class GlobalDashboardController {
	
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
	private GlobalDashboardService globalDashboardService;
	
	@GetMapping
	public Response<UIGlobalDashboard> getGlobalClientDashboard() {
		Response<UIGlobalDashboard> response=new Response<UIGlobalDashboard>();
		try {
			response.setData(globalDashboardService.getDashboard());
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
