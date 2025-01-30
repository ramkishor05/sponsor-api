package org.sponsor.access.service;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.access.entities.EOUserRole;
import org.sponsor.access.mapper.UserRoleMapper;
import org.sponsor.access.model.UIUserRole;
import org.sponsor.access.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends CrudServiceImpl<UIUserRole, EOUserRole, Long> implements UserRoleService {
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public List<UIUserRole> getUserRoleList(String type) {
		return userRoleMapper.mapToDTO(userRoleRepository.findAllByRoleType(type));
	}
	
	@Override
	public List<UIUserRole> getUserRoleListByPositions(List<Integer> positions) {
		return userRoleMapper.mapToDTO(userRoleRepository.findByPositions(positions));
	}

	@Override
	public JpaRepository<EOUserRole, Long> getRepository() {
		return userRoleRepository;
	}

	@Override
	public GenericMapper<EOUserRole, UIUserRole> getMapper() {
		return userRoleMapper;
	}

}
