package com.example.kiosk.coupon;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kiosk.Member.Member;

@Service
public class CouponService {
	
	@Autowired
	private CouponDao dao;
	
	private ArrayList<CouponDto> change(ArrayList<Coupon> list){
		ArrayList<CouponDto> dlist = new ArrayList<>();
		for(Coupon entity : list) {
			CouponDto dto = new CouponDto(entity.getCouponnum(), entity.getUserid(),entity.getStoreid(),entity.getIssueddate(),entity.getUseddate(),entity.getExpiredate(),entity.isUsed());
			dlist.add(dto);
			
					
		}
		return dlist;
	}
	
	public CouponDto save(CouponDto dto) {
		Coupon entity = dao.save(new Coupon(dto.getCouponnum(),dto.getId(),dto.getStoreid(),dto.getIssueddate(),dto.getUseddate(),dto.getExpiredate(),dto.isUsed()));	
		dto.setCouponnum(entity.getCouponnum());
		dto.setId(entity.getUserid());
		dto.setStoreid(entity.getStoreid());
		dto.setIssueddate(entity.getIssueddate());
		dto.setUseddate(entity.getUseddate());
		dto.setExpiredate(entity.getExpiredate());
		dto.setUsed(entity.isUsed());
		return dto;
		
		
	}
	
	public CouponDto getByCouponnum(int couponnum) {
		Coupon entity = dao.findById(couponnum).orElse(null);
		CouponDto dto = new CouponDto(entity.getCouponnum(), entity.getUserid(),entity.getStoreid(),entity.getIssueddate(),entity.getUseddate(),entity.getExpiredate(),entity.isUsed());
		return dto;
	}
	
	public ArrayList<CouponDto> getAll(){
		ArrayList<Coupon> list = (ArrayList<Coupon>) dao.findAll();
		return change(list);
	}
	
	public ArrayList<Map<String, String>> getByUserid(String id){
				
		ArrayList<Map<String, String>> list = dao.findByUserid(id);
		return list;
		
	}
	
	
	
}
