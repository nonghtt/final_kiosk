package com.example.kiosk.Sellingtype;


import java.util.ArrayList;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.kiosk.coupon.Coupon;


@Repository
public interface SellingtypeDao extends JpaRepository<Sellingtype, Integer> {


//	매장별(storeid) 검색
	ArrayList<Sellingtype> findByStoreid(String storeid); 
	ArrayList<Sellingtype> findByCouponnum(Coupon couponnum); 
	
@Modifying
@Transactional
@Query(value="select productnum from (select sum(amount) as totalsales , productnum from sellingtype group by productnum order by totalsales desc) where rownum <=6",nativeQuery = true)
ArrayList<Map<String, String>> findTopSales();
//	서브쿼리 ~?
//	order by 
//	전달 판매순위 검색

}
