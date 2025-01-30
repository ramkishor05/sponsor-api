package org.sponsor.access.service;

import java.util.Map;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.access.entities.EOUserSponsor;
import org.sponsor.access.model.UIUserSponsor;
import org.springframework.util.MultiValueMap;

public interface UserSponsorService extends CrudService<UIUserSponsor, EOUserSponsor, Long>{

	UIUserSponsor findByUserAccountId(Long userAccountId, MultiValueMap<String, String> headers,
			Map<String, Object> filters, Map<String, Object> actions);

	boolean existsByUtrNumber(String utrNumber);


}
