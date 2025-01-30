package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.model.UIBusinessSponsorModel;

public interface BusinessSponsorService extends CrudService<UIBusinessSponsorModel, EOBusinessSponsor, Long>{

}
