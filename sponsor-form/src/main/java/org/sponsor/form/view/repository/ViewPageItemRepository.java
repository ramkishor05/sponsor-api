package org.sponsor.form.view.repository;
import static org.sponsor.form.view.constants.ViewTableConstants.VIEW_PAGE_ITEM;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.form.view.entities.pages.EOViewPageItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ViewPageItemRepository  extends CustomRepository<EOViewPageItem, Long>{

	@Query(nativeQuery = true,  value="select * from "+VIEW_PAGE_ITEM+" UE where UE.TITLE = :title")
	Optional<EOViewPageItem> findByTitle(@Param("title")String title);
	
	@Query(nativeQuery = true,  value="select * from "+VIEW_PAGE_ITEM+" UE where UE.URL = :url")
	Optional<EOViewPageItem> findByUrl(@Param("url")String url);

	@Query(nativeQuery = true,  value="select * from "+VIEW_PAGE_ITEM+" UE where UE.TYPE = :type")
	List<EOViewPageItem> findAllByType(@Param("type")String type);

	@Query(nativeQuery = true,  value="select * from "+VIEW_PAGE_ITEM+" UE where UE.URL in (:urls)")
	List<EOViewPageItem> findByUrls(@Param("urls")List<String> urls);

}
