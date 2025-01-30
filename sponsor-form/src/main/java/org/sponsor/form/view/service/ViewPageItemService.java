package org.sponsor.form.view.service;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.view.entities.pages.EOViewPageItem;
import org.sponsor.form.view.model.pages.UIViewPageItem;

public interface ViewPageItemService extends CrudService<UIViewPageItem, EOViewPageItem, Long>{

	List<UIViewPageItem> getPageItemList(String type);

}
