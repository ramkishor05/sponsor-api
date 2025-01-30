package org.sponsor.account.repository;

import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOBusinessFinancialCoupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BusinessFinancialCouponRepository extends CustomRepository<EOBusinessFinancialCoupon, Long>{

	@Query(nativeQuery = true,  value="select * from BUSINESS_FINANCIAL_COUPON US where US.TYPE = :type and US.STATUS = :status")
	Optional<EOBusinessFinancialCoupon> findByTypeAndStatus(String type, String status);

}
