package org.sponsor.account.forgin.repository;

import org.sponsor.account.forgin.config.FeignClientConfig;
import org.sponsor.account.forgin.model.ResourceFileModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "SPONSOR-RESOURCE", configuration = FeignClientConfig.class, url = "http://${server.gateway.host}:${server.gateway.port}/resource")
public interface ResourceClient {

	//@PostMapping(value = "/resource/{type}/{name}")
	public ResourceFileModel add(@PathVariable String type, @PathVariable String name, @RequestBody String content);

}