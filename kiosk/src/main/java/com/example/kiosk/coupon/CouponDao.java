package com.example.kiosk.coupon;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import jakarta.transaction.Transactional;

@Repository
public interface CouponDao extends JpaRepository<Coupon, Integer>{
	
	@Modifying
	@Transactional
	@Query(value = "SELECT c.couponnum, c.userid, c.storeid, TO_CHAR(c.issueddate, 'YYYYMMDD') AS issueddate,TO_CHAR(c.useddate, 'YYYYMMDD') AS useddate,TO_CHAR(c.expiredate, 'YYYYMMDD') AS expiredate,c.used "
			+ "FROM Coupon c WHERE c.userid = :userid",nativeQuery = true )
	ArrayList<Map<String, String>> findByUserid(@Param("userid") String userid);

}