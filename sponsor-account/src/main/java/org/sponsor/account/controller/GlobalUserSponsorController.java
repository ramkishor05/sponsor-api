package org.sponsor.account.controller;

import org.brijframework.integration.spring.rest.crud.beans.Response;
import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.constants.SponsorStatus;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.model.UIUserSponsorModel;
import org.sponsor.account.service.UserSponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/api/global/user/sponsor")
@CrossOrigin("*")
public class GlobalUserSponsorController implements CrudController<UIUserSponsorModel, EOUserSponsor, Long> {

	@Autowired
	private UserSponsorService userSponsorService;

	@Override
	public CrudService<UIUserSponsorModel, EOUserSponsor, Long> getService() {
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
	
	@GetMapping("/tree")
	public Response<Object> fetchTree(
			@RequestHeader(required =false)  MultiValueMap<String,String> headers, 
			WebRequest webRequest){
		Response<Object> response=new Response<Object>();
		try {
			response.setData(userSponsorService.fetchTree(headers));
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
	
	@GetMapping("/current")
	public Response<Object> fetchCurrent(
			@RequestHeader(required =false)  MultiValueMap<String,String> headers, 
			WebRequest webRequest){
		Response<Object> response=new Response<Object>();
		try {
			response.setData(userSponsorService.fetchCurrent(headers));
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
	
	@PatchMapping("/change/status")
	public Response<Object> changeStatus(@RequestParam Long sponsorId, @RequestParam SponsorStatus status ){
		Response<Object> response=new Response<Object>();
		try {
			response.setData(userSponsorService.changeStatus(sponsorId, status));
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
