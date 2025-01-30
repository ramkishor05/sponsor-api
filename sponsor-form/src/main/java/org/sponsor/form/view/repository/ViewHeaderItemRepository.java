package org.sponsor.form.view.repository;
import static org.sponsor.form.view.constants.ViewTableConstants.VIEW_HEADER_ITEM;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.form.view.entities.headers.EOViewHeaderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ViewHeaderItemRepository  extends CustomRepository<EOViewHeaderItem, Long>{

	
	@Query(nativeQuery = true,  value="select * from "+VIEW_HEADER_ITEM+" HI where HI.TITLE = :title")
	Optional<EOViewHeaderItem> findByTitle(@Param("title")String title);
	
	@Query(nativeQuery = true,  value="select * from "+VIEW_HEADER_ITEM+" HI where HI.URL = :url")
	Optional<EOViewHeaderItem> findByUrl(@Param("url")String url);

	@Query(nativeQuery = true,  value="select * from "+VIEW_HEADER_ITEM+" HI where HI.TYPE = :type")
	List<EOViewHeaderItem> findAllByType(@Param("type")String type);

	@Query(nativeQuery = true,  value="select * from "+VIEW_HEADER_ITEM+" HI where HI.URL in (:urls)")
	List<EOViewHeaderItem> findByUrls(@Param("urls")List<String> urls);

}
