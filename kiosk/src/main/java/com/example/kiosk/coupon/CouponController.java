package com.example.kiosk.coupon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/coupons")
public class CouponController {
	
	@Autowired
	private CouponService service;
	
	@GetMapping()
	public Map getAll() {
		ArrayList<CouponDto> dlist = service.getAll();
		Map map = new HashMap();
		map.put("couponlist",dlist);
		return map;
		
	}
	
	@PostMapping()
	public Map add(CouponDto dto) {
		System.out.println("adddto:" +dto);
		CouponDto d = service.save(dto);
		Map map = new HashMap();
		map.put("dto", d);
		return map;
		
	}
	
	@GetMapping("/mycoupon/{userid}")
	public Map getByUserid(@PathVariable("userid") String userid) {
		ArrayList<Map<String, String>> dlist = service.getByUserid(userid);
		Map map = new HashMap();
		map.put("mycouponlist",dlist);
		return map;
		
	}
}
