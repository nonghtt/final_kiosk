package com.example.kiosk.coupon;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kiosk.Member.Member;

@Repository
public interface CouponDao extends JpaRepository<Coupon, Integer>{
	ArrayList<Coupon> findByUserid(Member userid);

}
