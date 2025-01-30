package org.sponsor.form.view.service;

import java.util.ArrayList;
import java.util.List;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuGroup;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuItem;
import org.sponsor.form.role.repository.UserRoleMenuGroupRepository;
import org.sponsor.form.view.entities.menus.EOViewMenuGroup;
import org.sponsor.form.view.mapper.ViewMenuGroupMapper;
import org.sponsor.form.view.mapper.ViewMenuItemMapper;
import org.sponsor.form.view.model.menus.UIViewMenuGroup;
import org.sponsor.form.view.model.menus.UIViewMenuItem;
import org.sponsor.form.view.repository.ViewMenuGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ViewMenuGroupServiceImpl extends CrudServiceImpl<UIViewMenuGroup, EOViewMenuGroup, Long> implements ViewMenuGroupService {
	
	@Autowired
	private UserRoleMenuGroupRepository roleMenuGroupRepository;
	
	@Autowired
	private ViewMenuGroupRepository menuGroupRepository;
	
	@Autowired
	private ViewMenuGroupMapper menuGroupMapper;
	
	@Autowired
	private ViewMenuItemMapper menuItemMapper;
	
	@Override
	public JpaRepository<EOViewMenuGroup, Long> getRepository() {
		return menuGroupRepository;
	}

	@Override
	public GenericMapper<EOViewMenuGroup, UIViewMenuGroup> getMapper() {
		return menuGroupMapper;
	}

	@Override
	public List<UIViewMenuGroup> getMenuGroupListByRole(String roleId) {
		List<EOUserRoleMenuGroup> eoRoleMenuGroups = roleMenuGroupRepository.findAllByRoleId(roleId);
		List<UIViewMenuGroup> uiMenuGroups=new ArrayList<UIViewMenuGroup>();
		for(EOUserRoleMenuGroup eoRoleMenuGroup: eoRoleMenuGroups) {
			UIViewMenuGroup uiMenuGroup = menuGroupMapper.mapToDTO(eoRoleMenuGroup.getMenuGroup());
			for(EOUserRoleMenuItem eoRoleMenuItem: eoRoleMenuGroup.getRoleMenuItems()) {
				UIViewMenuItem uiMenuItem = menuItemMapper.mapToDTO(eoRoleMenuItem.getMenuItem());
				uiMenuItem.setHomePage(eoRoleMenuItem.isHomePage());
				uiMenuGroup.getMenuItems().add(uiMenuItem);
			}
			uiMenuGroup.getMenuItems().sort((m1,m2)->m1.getOrderSequence().compareTo(m2.getOrderSequence()));
			uiMenuGroups.add(uiMenuGroup);
		}
		uiMenuGroups.sort((m1,m2)->m1.getOrderSequence().compareTo(m2.getOrderSequence()));
		return uiMenuGroups;
	}

	
}
