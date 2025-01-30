package org.sponsor.form.role.service;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuItem;
import org.sponsor.form.role.mapper.GlobalUserRoleMenuItemMapper;
import org.sponsor.form.role.model.menus.UIUserRoleMenuItem;
import org.sponsor.form.role.repository.UserRoleMenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRoleMenuItemServiceImpl extends CrudServiceImpl<UIUserRoleMenuItem, EOUserRoleMenuItem, Long> implements UserRoleMenuItemService {
	
	@Autowired
	private UserRoleMenuItemRepository roleMenuItemRepository;
	
	@Autowired
	private GlobalUserRoleMenuItemMapper roleMenuItemMapper;

	@Override
	public List<UIUserRoleMenuItem> getRoleMenuItemList(String type) {
		return roleMenuItemMapper.mapToDTO(roleMenuItemRepository.findAllByType(type));
	}

	@Override
	public JpaRepository<EOUserRoleMenuItem, Long> getRepository() {
		return roleMenuItemRepository;
	}

	@Override
	public GenericMapper<EOUserRoleMenuItem, UIUserRoleMenuItem> getMapper() {
		return roleMenuItemMapper;
	}

}
