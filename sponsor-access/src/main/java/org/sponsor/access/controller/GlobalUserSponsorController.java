package org.sponsor.access.controller;

import java.util.HashMap;
import java.util.Map;

import org.brijframework.integration.spring.rest.crud.beans.QueryRequest;
import org.brijframework.integration.spring.rest.crud.beans.Response;
import org.brijframework.integration.spring.rest.crud.controller.CQRSController;
import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.access.entities.EOUserSponsor;
import org.sponsor.access.model.UIUserSponsor;
import org.sponsor.access.service.UserSponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/api/global/user/sponsor")
@CrossOrigin("*")
public class GlobalUserSponsorController implements CrudController<UIUserSponsor, EOUserSponsor, Long> {
	
	@Autowired
    private UserSponsorService userSponsorService;
	
	@Override
	public CrudService<UIUserSponsor, EOUserSponsor, Long> getService() {
		return userSponsorService;
	}
	
	@GetMapping("/exists/by/utr/{utrNumber}")
	public Response<Object> existsByUtrNumber(@PathVariable String utrNumber){
		Response<Object> response=new Response<Object>();
		try {
			response.setData(userSponsorService.existsByUtrNumber(utrNumber));
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
	
	@GetMapping("/account/{userAccountId}")
	Response<Object> findByUserAccountId(@PathVariable Long userAccountId, @RequestHeader(required =false)  MultiValueMap<String,String> headers , WebRequest webRequest){
		Response<Object> response=new Response<Object>();
		Map<String, Object> filters = CQRSController.getfilters(webRequest);
		Map<String, Object> actions = CQRSController.getActions(webRequest);
		Map<String, Object> sortOrders = CQRSController.getSortings(webRequest);
		Map<String, Object> params=new HashMap<String, Object>();
		QueryRequest queryRequest=new QueryRequest(params, headers, sortOrders, filters, FIND, "/{id}");
		try {
			response.setData(customizedResponse(userSponsorService.findByUserAccountId(userAccountId, headers, filters, actions), queryRequest));
			response.setSuccess(SUCCESS);
			response.setMessage(SUCCESSFULLY_PROCCEED);
			return response;
		}catch (Exception e) {
			response.setSuccess(FAILED);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
}
