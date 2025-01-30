package org.sponsor.form.view.controller;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.view.entities.pages.EOViewPageItem;
import org.sponsor.form.view.model.pages.UIViewPageItem;
import org.sponsor.form.view.service.ViewPageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/page/item")
@CrossOrigin("*")
public class ViewPageItemController implements CrudController<UIViewPageItem, EOViewPageItem, Long>{
	
	@Autowired
    private ViewPageItemService pageItemService;

	@Override
	public CrudService<UIViewPageItem, EOViewPageItem, Long> getService() {
		return pageItemService;
	}
	
}
