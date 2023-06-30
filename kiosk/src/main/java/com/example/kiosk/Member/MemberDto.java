package com.example.kiosk.Member;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
	private String id;
	private String pwd;
	private int phonenum;
	private Date birthday;
	private String email;
}
