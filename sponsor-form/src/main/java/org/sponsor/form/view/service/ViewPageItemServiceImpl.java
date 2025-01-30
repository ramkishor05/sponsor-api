package org.sponsor.form.view.service;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.form.view.entities.pages.EOViewPageItem;
import org.sponsor.form.view.mapper.ViewPageItemMapper;
import org.sponsor.form.view.model.pages.UIViewPageItem;
import org.sponsor.form.view.repository.ViewPageItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ViewPageItemServiceImpl extends CrudServiceImpl<UIViewPageItem, EOViewPageItem, Long> implements ViewPageItemService {
	
	@Autowired
	private ViewPageItemRepository pageItemRepository;
	
	@Autowired
	private ViewPageItemMapper pageItemMapper;

	@Override
	public List<UIViewPageItem> getPageItemList(String type) {
		return pageItemMapper.mapToDTO(pageItemRepository.findAllByType(type));
	}

	@Override
	public JpaRepository<EOViewPageItem, Long> getRepository() {
		return pageItemRepository;
	}

	@Override
	public GenericMapper<EOViewPageItem, UIViewPageItem> getMapper() {
		return pageItemMapper;
	}

}
