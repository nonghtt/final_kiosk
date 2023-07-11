package com.example.kiosk.Sellingtype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("sellingtype")
public class SellingtypeController {


	@Autowired
	private SellingtypeService service;
	
	
	//추가, 생성
	@PostMapping("")
	public Map standardsave(SellingtypeTempDto dto) {
		SellingtypeDto d = service.save(dto);
		System.out.println(d);
		Map map = new HashMap();
		map.put("sellingtype", d);
		return map;
	}

	
	
	
	@GetMapping("")
	public Map findAll(){
		ArrayList<SellingtypeDto> dto= service.getAll();
		Map map = new HashMap();
		map.put("dto", dto);
		return map;
	}
	
	@GetMapping("/{storeid}")
	public Map findBySellproduct(@PathVariable("storeid") String storeid) {
		ArrayList<SellingtypeDto> dto = service.getByStoreid(storeid);
		Map map = new HashMap();
		map.put("dto", dto);
		return map;
	}
	
	
	@DeleteMapping("")
	public void delSellingtype(int tempnum) {
		service.del(tempnum);
	}
	
	@GetMapping("/topsales")
	public Map getTopSales() {
			ArrayList<Map<String, String>> list = service.getTopSales();
			Map map = new HashMap();
			map.put("toplist", list);
			return map;
		
	}
	
	@GetMapping("/coupon/{couponnum}")
	public Map getByCouponnum(@PathVariable("couponnum") String couponnum) {
		ArrayList<SellingtypeDto> list = service.getByCouponnum(couponnum);
		Map map = new HashMap();
		map.put("list", list);
		return map;
		
	}
}