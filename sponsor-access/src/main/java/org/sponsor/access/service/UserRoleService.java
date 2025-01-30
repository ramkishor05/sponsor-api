package org.sponsor.access.service;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.access.entities.EOUserRole;
import org.sponsor.access.model.UIUserRole;

public interface UserRoleService extends CrudService<UIUserRole, EOUserRole, Long>{

	List<UIUserRole> getUserRoleList(String type);

	List<UIUserRole> getUserRoleListByPositions(List<Integer> positions);

}
