package org.sponsor.form.forgin.repository;

import static org.sponsor.form.constants.Constants.AUTHORIZATION;

import org.sponsor.form.forgin.model.UserAccountModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name= "RESPONSER-AUTH" , url = "http://${server.gateway.host}:${server.gateway.port}/auth")
public interface UserClient {

	@GetMapping(value = "/api/device/authentication")
	public UserAccountModel findByToken(@RequestHeader(AUTHORIZATION) String token) ;
}
