package org.sponsor.form.view.service;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.view.entities.pages.EOViewPageGroup;
import org.sponsor.form.view.model.pages.UIViewPageGroup;

public interface ViewPageGroupService extends CrudService<UIViewPageGroup, EOViewPageGroup, Long>{

	List<UIViewPageGroup> getPageGroupListByRole(Long roleId);
}
