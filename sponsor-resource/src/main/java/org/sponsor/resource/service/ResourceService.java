package org.sponsor.resource.service;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.resource.entities.EOResource;
import org.sponsor.resource.modal.UIResourceModel;
import org.springframework.core.io.Resource;

public interface ResourceService extends CrudService<UIResourceModel, EOResource, Long> {

	Resource getResource(String type, String url);

	/**
	 * @param url
	 * @return
	 */
	Resource getResource(String url);

}
