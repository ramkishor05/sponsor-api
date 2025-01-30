package org.sponsor.form.view.service;

import java.util.ArrayList;
import java.util.List;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.form.role.entities.pages.EOUserRolePageGroup;
import org.sponsor.form.role.entities.pages.EOUserRolePageItem;
import org.sponsor.form.role.repository.UserRolePageGroupRepository;
import org.sponsor.form.view.entities.pages.EOViewPageGroup;
import org.sponsor.form.view.mapper.ViewPageGroupMapper;
import org.sponsor.form.view.mapper.ViewPageItemMapper;
import org.sponsor.form.view.model.pages.UIViewPageGroup;
import org.sponsor.form.view.model.pages.UIViewPageItem;
import org.sponsor.form.view.repository.ViewPageGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ViewPageGroupServiceImpl extends CrudServiceImpl<UIViewPageGroup, EOViewPageGroup, Long> implements ViewPageGroupService {
	
	@Autowired
	private UserRolePageGroupRepository userRolePageGroupRepository;
	
	@Autowired
	private ViewPageGroupRepository pageGroupRepository;
	
	@Autowired
	private ViewPageGroupMapper pageGroupMapper;
	
	@Autowired
	private ViewPageItemMapper pageItemMapper;
	
	@Override
	public JpaRepository<EOViewPageGroup, Long> getRepository() {
		return pageGroupRepository;
	}

	@Override
	public GenericMapper<EOViewPageGroup, UIViewPageGroup> getMapper() {
		return pageGroupMapper;
	}

	@Override
	public List<UIViewPageGroup> getPageGroupListByRole(Long roleId) {
		List<EOUserRolePageGroup> eoRolePageGroups = userRolePageGroupRepository.findAllByRoleId(roleId);
		List<UIViewPageGroup> uiPageGroups=new ArrayList<UIViewPageGroup>();
		for(EOUserRolePageGroup eoRolePageGroup: eoRolePageGroups) {
			UIViewPageGroup uiPageGroup = pageGroupMapper.mapToDTO(eoRolePageGroup.getPageGroup());
			for(EOUserRolePageItem eoRolePageItem: eoRolePageGroup.getRolePageItems()) {
				UIViewPageItem uiPageItem = pageItemMapper.mapToDTO(eoRolePageItem.getPageItem());
				uiPageItem.setHomePage(eoRolePageItem.isHomePage());
				uiPageGroup.getPageItems().add(uiPageItem);
			}
			uiPageGroup.getPageItems().sort((m1,m2)->m1.getOrderSequence().compareTo(m2.getOrderSequence()));
			uiPageGroups.add(uiPageGroup);
		}
		uiPageGroups.sort((m1,m2)->m1.getOrderSequence().compareTo(m2.getOrderSequence()));
		return uiPageGroups;
	}

	
}
