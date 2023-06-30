package com.example.kiosk.Member;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
	
	@Id
	@OnDelete(action = OnDeleteAction.CASCADE)
	private String id;
	private String pwd;
	private int phonenum;
	private Date birthday;
	private String email;
	
	
}
