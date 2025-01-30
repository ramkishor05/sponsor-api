package org.sponsor.account.forgin.repository;

import org.brijframework.integration.spring.rest.crud.beans.Response;
import org.sponsor.account.constants.Constants;
import org.sponsor.account.forgin.model.GlobalAuthDataDTO;
import org.sponsor.account.forgin.model.GlobalRegisterRequest;
import org.sponsor.account.forgin.model.UserAccountModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name= "SPONSOR-ACCESS" , url = "http://${server.gateway.host}:${server.gateway.port}/access")
public interface UserClient {

	@GetMapping(value = "/api/global/authentication")
	public UserAccountModel findByToken(@RequestHeader(Constants.AUTHORIZATION) String token) ;

	@PostMapping(value = "/api/global/authentication/register")
	public Response<GlobalAuthDataDTO> doRegister(@RequestBody GlobalRegisterRequest userAccount);;
	
	@GetMapping(value = "/api/global/user/detail/{userAccountId}")
	public Response<UserAccountModel> doUserDetail(@PathVariable Long userAccountId);
}
