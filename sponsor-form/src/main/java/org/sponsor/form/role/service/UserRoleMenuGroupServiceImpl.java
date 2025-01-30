package org.sponsor.form.role.service;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuGroup;
import org.sponsor.form.role.mapper.GlobalUserRoleMenuGroupMapper;
import org.sponsor.form.role.model.menus.UIUserRoleMenuGroup;
import org.sponsor.form.role.repository.UserRoleMenuGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRoleMenuGroupServiceImpl extends CrudServiceImpl<UIUserRoleMenuGroup, EOUserRoleMenuGroup, Long> implements UserRoleMenuGroupService {
	
	@Autowired
	private UserRoleMenuGroupRepository roleMenuGroupRepository;
	
	@Autowired
	private GlobalUserRoleMenuGroupMapper roleMenuGroupMapper;

	@Override
	public JpaRepository<EOUserRoleMenuGroup, Long> getRepository() {
		return roleMenuGroupRepository;
	}

	@Override
	public GenericMapper<EOUserRoleMenuGroup, UIUserRoleMenuGroup> getMapper() {
		return roleMenuGroupMapper;
	}


	@Override
	public List<UIUserRoleMenuGroup> getRoleMenuGroupList(String type) {
		return roleMenuGroupMapper.mapToDTO(roleMenuGroupRepository.findAllByRoleId(type));
	}

	
}
