package com.example.kiosk.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/members")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@PostMapping()
	public Map save(MemberDto dto) {
		MemberDto d = service.save(dto);
		Map map = new HashMap();
		map.put("member", d);
		return map;
	}
	
	@GetMapping()
	public Map findAll() {
		ArrayList<MemberDto> dlist = service.getAll();
		Map map = new HashMap();
		map.put("memberlist", dlist);
		return map;
		
	}
	
	@GetMapping("/{id}")
	public Map findById(@PathVariable("id") String id) {
		MemberDto dto = service.getById(id);
		Map map = new HashMap();
		map.put("dtp", dto);
		return map;
	}
	
	
	@PatchMapping()
	public Map findById(MemberDto dto) {
		MemberDto d = service.save(dto);
		Map map = new HashMap();
		map.put("member", d);
		return map;
	}
	
	@DeleteMapping()
	public Map deleteId(String id) {
		boolean flag = true;
		if(flag) {
			service.delete(id);
		}else {
			flag=false;
		}
		Map map = new HashMap();
		map.put("flag", flag);
		return map;
	}
}
