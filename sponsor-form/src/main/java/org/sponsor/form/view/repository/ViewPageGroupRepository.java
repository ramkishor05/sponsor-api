package org.sponsor.form.view.repository;
import static org.sponsor.form.view.constants.ViewTableConstants.VIEW_PAGE_GROUP;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.form.view.entities.pages.EOViewPageGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ViewPageGroupRepository  extends CustomRepository<EOViewPageGroup, Long>{

	@Query(nativeQuery = true,  value="select * from "+VIEW_PAGE_GROUP+" UE where UE.TITLE = :title")
	Optional<EOViewPageGroup> findByTitle(@Param("title")String title);
	
	@Query(nativeQuery = true,  value="select * from "+VIEW_PAGE_GROUP+" UE where UE.URL = :url")
	Optional<EOViewPageGroup> findByUrl(@Param("url")String url);

	@Query(nativeQuery = true,  value="select * from "+VIEW_PAGE_GROUP+" UE where UE.TYPE = :type")
	List<EOViewPageGroup> findAllByType(@Param("type")String type);

	@Query(nativeQuery = true,  value="select * from "+VIEW_PAGE_GROUP+" UE where UE.URL in (:urls)")
	List<EOViewPageGroup> findByUrls(@Param("urls")List<String> urls);


}
