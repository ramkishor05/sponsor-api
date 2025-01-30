package org.sponsor.account.repository;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOUserSponsorEntryTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserSponsorEntryTransactionRepository  extends CustomRepository<EOUserSponsorEntryTransaction, Long>{

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR_ENTRY_TRANSACTION US where US.USER_SPONSOR_ID = :userSponsorId")
	Optional<List<EOUserSponsorEntryTransaction>> findByUserSponsorId(Long userSponsorId);
}
