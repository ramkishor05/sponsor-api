package org.sponsor.access.controller;

import org.brijframework.integration.spring.rest.crud.beans.Response;
import org.brijframework.integration.spring.rest.crud.controller.QueryController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.access.entities.EOUserAccount;
import org.sponsor.access.model.GlobalRegisterRequest;
import org.sponsor.access.model.UIUserAccount;
import org.sponsor.access.model.UIUserProfile;
import org.sponsor.access.model.UserDetailResponse;
import org.sponsor.access.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/user/detail")
@CrossOrigin("*")
public class GlobalUserDetailController implements QueryController<UserDetailResponse, EOUserAccount, Long> {
	
	@Autowired
    private UserAccountService userAccountService;
	
	@Override
	public CrudService<UserDetailResponse, EOUserAccount, Long> getService() {
		return userAccountService;
	}
	
	@PostMapping
	public Response<Object> register(@RequestBody GlobalRegisterRequest registerRequest){
		Response<Object> response=new Response<Object>();
		try {
			response.setData(userAccountService.register(registerRequest));
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

	@PutMapping("/{id}")
	public Response<Object> updateUserAccount(@PathVariable Long id, @RequestBody UIUserAccount uiUserAccount){
		Response<Object> response=new Response<Object>();
		try {
			response.setData(userAccountService.updateUserAccount(uiUserAccount));
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

	@GetMapping("/exists/{username}")
	public Response<Object> isAlreadyExists(@PathVariable String username){
		Response<Object> response=new Response<Object>();
		try {
			response.setData(userAccountService.isAlreadyExists(username));
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
	
	@PutMapping("/profile")
	public Response<Object> updateUserProfile(@RequestBody UIUserProfile uiUserProfile){
		Response<Object> response=new Response<Object>();
		try {
			response.setData(userAccountService.updateUserProfile(uiUserProfile));
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

	@GetMapping("/profile/{id}")
	public Response<Object> getUserProfile(@PathVariable Long id){
		Response<Object> response=new Response<Object>();
		try {
			response.setData(userAccountService.getUserProfile(id));
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
	
	@DeleteMapping("/{id}")
	public Response<Object> getDelete(@PathVariable Long id){
		Response<Object> response=new Response<Object>();
		try {
			response.setData(userAccountService.deleteById(id));
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
