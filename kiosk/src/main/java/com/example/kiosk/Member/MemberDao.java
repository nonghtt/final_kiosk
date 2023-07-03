package com.example.kiosk.Member;

import java.util.HashMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends JpaRepository<Member, String>{
	Member findByEmail(String Email);
}
