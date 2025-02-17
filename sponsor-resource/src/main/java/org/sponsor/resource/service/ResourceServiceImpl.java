package org.sponsor.resource.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.brijframework.util.lang.StringUtil;
import org.sponsor.resource.entities.EOResource;
import org.sponsor.resource.mapper.ResourceMapper;
import org.sponsor.resource.modal.UIResourceModel;
import org.sponsor.resource.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import jakarta.xml.bind.DatatypeConverter;

@Service
public class ResourceServiceImpl extends CrudServiceImpl<UIResourceModel, EOResource, Long> implements ResourceService {

	@Autowired
	private ResourceUtil resourceUtil;

	@Autowired
	private ResourceMapper resourceMapper;

	@Autowired
	private ResourceRepository resourceRepository;

	@Override
	public JpaRepository<EOResource, Long> getRepository() {
		return resourceRepository;
	}

	@Override
	public GenericMapper<EOResource, UIResourceModel> getMapper() {
		return resourceMapper;
	}

	@Override
	public Resource getResource(String type, String url) {
		return resourceUtil.getResource(type, url);
	}

	@Override
	public Resource getResource(String url) {
		return resourceUtil.getResource(url);
	}

	@Override
	public void postAdd(UIResourceModel uiResource, EOResource entityResource) {
		try {
			uiResource.setId(entityResource.getId());
			Resource resource = resourceUtil.getResource();
			File resourceFile = resource.getFile();
			if(!resourceFile.exists()) {
				resourceFile.mkdirs();
			}
			File folderFile = getCurrentFolder(resourceFile, uiResource.getFolderName());
			if(!folderFile.exists()) {
				folderFile.mkdirs();
			}
			File parentFile = uiResource.getIncludeId()!=null && uiResource.getIncludeId()?   new File(folderFile, entityResource.getId()+""): folderFile;
			if(!parentFile.exists()) {
				parentFile.mkdirs();
			}
			if(StringUtil.isNotEmpty(uiResource.getFileContent()) && StringUtil.isNotEmpty(uiResource.getFileName())) {
				writeFile(parentFile, uiResource.getFileName(), uiResource.getFileContent());
			}
			if(StringUtil.isNotEmpty(uiResource.getPosterContent()) && StringUtil.isNotEmpty(uiResource.getPosterName())) {
				writeFile(parentFile, uiResource.getPosterName(), uiResource.getPosterContent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static File getCurrentFolder(File resourceFile, String folderNames) {
		File currentFile=resourceFile;
		for(String folderName: folderNames.split("/")) {
			currentFile=new File(currentFile, folderName);
			if(!currentFile.exists()) {
				currentFile.mkdirs();
			}
		}
		return currentFile;
	}

	private void writeFile(File parentFile, String fileName, String base64Content) throws IOException, FileNotFoundException {
		String[] fileContent = base64Content.split(",");
		byte[] fileBytes = DatatypeConverter.parseBase64Binary(fileContent[1]);
		File dataFile = new File(parentFile, fileName);
		try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(dataFile))) {
			outputStream.write(fileBytes);
		}
	}
	
	public static void main(String[] args) {
		String folderName="/ram/kishor";
		System.out.println(getCurrentFolder(new File("C:\\app_runs\\unlimits-resources\\resource"), folderName).getAbsolutePath());
	}

}
