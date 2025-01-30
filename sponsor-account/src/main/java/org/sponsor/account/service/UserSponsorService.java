package org.sponsor.account.service;

import java.util.List;
import java.util.Map;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.constants.SponsorStatus;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.model.UIUserSponsorModel;
import org.sponsor.account.model.UIUserSponsorTreeModel;

public interface UserSponsorService extends CrudService<UIUserSponsorModel, EOUserSponsor, Long>{

	List<UIUserSponsorModel> findAllByCurrent(Map<String, List<String>> headers);

	UIUserSponsorTreeModel fetchTree(Map<String, List<String>> headers);

	UIUserSponsorModel fetchCurrent(Map<String, List<String>> headers);

	EOUserSponsor findSponsor(Long sponsorId);

	EOUserSponsor getCurrentSponsor(Map<String, List<String>> headers);

	boolean changeStatus(Long sponsorId, SponsorStatus sponsorStatus);

	boolean existsByUtrNumber(String utrNumber);
}
