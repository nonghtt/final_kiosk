package com.example.kiosk.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends JpaRepository<Member, String>{
	
}
