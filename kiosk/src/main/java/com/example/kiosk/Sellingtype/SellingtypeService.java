package com.example.kiosk.Sellingtype;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kiosk.Member.Member;
import com.example.kiosk.coupon.Coupon;

@Service
public class SellingtypeService {

	@Autowired
	private SellingtypeDao dao;
	
	
	
	//0. Entity를 Dto로 변환해주는 메서드
	public ArrayList<SellingtypeDto> change(ArrayList<Sellingtype> list){
		ArrayList<SellingtypeDto> slist = new ArrayList<SellingtypeDto>();
		for(Sellingtype entity:list) {

			slist.add(new SellingtypeDto(entity.getTempnum(),entity.getId(),entity.getCouponnum(), entity.getProductnum(), entity.getSellproduct(), entity.getStoreid(), entity.getWdate()));

		}
		return slist;
	}
	

	//전체조회
	public ArrayList<SellingtypeDto> getAll(){
		ArrayList<Sellingtype> list = (ArrayList<Sellingtype>) dao.findAll(); 
		return change(list);
	}
	

	//삭제
	//pk값으로 해당 고객의 구매내역 전체 지우기
	public void del(int tempnum) {
		dao.deleteById(tempnum);
	}
	
	//매장별(storeid) 검색
	public ArrayList<SellingtypeDto> getByStoreid (String storeid){
		
		ArrayList<Sellingtype> sellingtypelist = dao.findByStoreid(storeid);
		ArrayList<SellingtypeDto> dtolist = new ArrayList<SellingtypeDto>();
		
		for(Sellingtype entity:sellingtypelist) {

			dtolist.add(new SellingtypeDto(entity.getTempnum(),entity.getId(),entity.getCouponnum(),entity.getProductnum(),entity.getSellproduct(),entity.getStoreid(),entity.getWdate()));

			}
		return dtolist;
		}
	

	
	
	public ArrayList<Map<String, String>> getTopSales(){
		ArrayList<Map<String, String>> list = dao.findTopSales();
		return list;
	}

	
	
//	기본적인 추가(생성), 수정
	public SellingtypeDto save(SellingtypeTempDto dto) {
		System.out.println("service1");
		Member member = new Member(dto.getId(),"","","","","");
		Coupon coupon = new Coupon( dto.getCouponnum(),member,"",null,null,null,false);
		System.out.println(coupon);	
		Sellingtype entity = dao.save(new Sellingtype(dto.getTempnum(),member,coupon,dto.getProductnum(),dto.getSellproduct(),dto.getStoreid(),dto.getWdate()));
		System.out.println(entity);
		SellingtypeDto sdto = new SellingtypeDto(entity.getTempnum(),entity.getId(),entity.getCouponnum(),entity.getProductnum(), entity.getSellproduct(), entity.getStoreid(), entity.getWdate());

		System.out.println(sdto);
		
		return sdto;
	}
	
	//String값만 추가해서 vue로 나가야함.
//	public SellingtypeDto save(SellingtypeDto dto){
//		Sellingtype entity = dao.save(new Sellingtype(dto.getTempnum(),"","","",""));
//		SellingtypeDto sdto = new SellingtypeDto(entity.getTempnum(),"","","","");
//		return sdto;
//	}



}
