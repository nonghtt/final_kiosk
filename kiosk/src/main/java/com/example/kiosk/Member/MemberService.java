package com.example.kiosk.Member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	private ArrayList<MemberDto> change(ArrayList<Member> list){
		ArrayList<MemberDto> dlist = new ArrayList<MemberDto>();
		for(Member entity : list) {
			MemberDto dto = new MemberDto(entity.getId(),entity.getPwd(), entity.getPhonenum(), entity.getBirthday(), entity.getEmail());
			
			dlist.add(dto);
		}
		return dlist;
	}
	
	public MemberDto save(MemberDto dto) {
		Member entity = dao.save(new Member(dto.getId(),dto.getPwd(),dto.getPhonenum(),dto.getBirthday(),dto.getEmail()));
		dto.setId(entity.getId());
		dto.setPwd(entity.getPwd());
		dto.setPhonenum(entity.getPhonenum());
		dto.setBirthday(entity.getBirthday());
		dto.setEmail(entity.getEmail());
		
		return dto;
	}
	
	public MemberDto getById(String id) {
		Member entity = dao.findById(id).orElse(null);
		MemberDto dto = new MemberDto(entity.getId(),entity.getPwd(), entity.getPhonenum(), entity.getBirthday(), entity.getEmail());
		return dto;
		
	}
	public ArrayList<MemberDto> getAll(){
		ArrayList<Member> list = (ArrayList<Member>) dao.findAll();
		return change(list);
	}
	
	public void delete(String id) {
		dao.deleteById(id);
	}
	
	
}
