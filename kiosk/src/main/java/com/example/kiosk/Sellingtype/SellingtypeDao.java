package com.example.kiosk.Sellingtype;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SellingtypeDao extends JpaRepository<Sellingtype, Integer> {


//	매장별(storeid) 검색
	ArrayList<Sellingtype> findByStoreid(String storeid); 
	
	
//	서브쿼리 ~?
//	order by 
//	전달 판매순위 검색

}
