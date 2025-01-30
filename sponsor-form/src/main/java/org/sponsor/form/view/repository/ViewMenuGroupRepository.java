package org.sponsor.form.view.repository;
import static org.sponsor.form.view.constants.ViewTableConstants.VIEW_MENU_GROUP;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.form.view.entities.menus.EOViewMenuGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ViewMenuGroupRepository  extends CustomRepository<EOViewMenuGroup, Long>{


	@Query(nativeQuery = true,  value="select * from "+VIEW_MENU_GROUP+" UE where UE.TITLE = :title")
	Optional<EOViewMenuGroup> findByTitle(@Param("title")String title);
	
	@Query(nativeQuery = true,  value="select * from "+VIEW_MENU_GROUP+" UE where UE.URL = :url")
	Optional<EOViewMenuGroup> findByUrl(@Param("url")String url);

	@Query(nativeQuery = true,  value="select * from "+VIEW_MENU_GROUP+" UE where UE.TYPE = :type")
	List<EOViewMenuGroup> findAllByType(@Param("type")String type);

	@Query(nativeQuery = true,  value="select * from "+VIEW_MENU_GROUP+" UE where UE.URL in (:urls)")
	List<EOViewMenuGroup> findByUrls(@Param("urls")List<String> urls);


}
