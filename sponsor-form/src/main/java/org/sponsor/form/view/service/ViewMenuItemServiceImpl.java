package org.sponsor.form.view.service;

import java.util.ArrayList;
import java.util.List;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuItem;
import org.sponsor.form.role.repository.UserRoleMenuItemRepository;
import org.sponsor.form.view.entities.menus.EOViewMenuItem;
import org.sponsor.form.view.mapper.ViewMenuItemMapper;
import org.sponsor.form.view.model.menus.UIViewMenuItem;
import org.sponsor.form.view.repository.ViewMenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ViewMenuItemServiceImpl extends CrudServiceImpl<UIViewMenuItem, EOViewMenuItem, Long> implements ViewMenuItemService {
	
	@Autowired
	private UserRoleMenuItemRepository roleMenuItemRepository;
	
	@Autowired
	private ViewMenuItemRepository menuItemRepository;
	
	@Autowired
	private ViewMenuItemMapper menuItemMapper;

	@Override
	public List<UIViewMenuItem> getMenuItemList(String type) {
		return menuItemMapper.mapToDTO(menuItemRepository.findAllByType(type));
	}

	@Override
	public JpaRepository<EOViewMenuItem, Long> getRepository() {
		return menuItemRepository;
	}

	@Override
	public GenericMapper<EOViewMenuItem, UIViewMenuItem> getMapper() {
		return menuItemMapper;
	}

	@Override
	public List<UIViewMenuItem> getMenuItemListByRole(String roleId) {
		List<EOUserRoleMenuItem> eoRoleMenuGroups = roleMenuItemRepository.findAllByRoleId(roleId);
		List<UIViewMenuItem> uiMenuItems=new ArrayList<UIViewMenuItem>();
		for(EOUserRoleMenuItem eoRoleMenuItem: eoRoleMenuGroups) {
			UIViewMenuItem uiMenuItem = menuItemMapper.mapToDTO(eoRoleMenuItem.getMenuItem());
			uiMenuItem.setHomePage(eoRoleMenuItem.isHomePage());
			uiMenuItems.add(uiMenuItem);
		}
		uiMenuItems.sort((m1,m2)->m1.getOrderSequence().compareTo(m2.getOrderSequence()));
		return uiMenuItems;
	}

}
