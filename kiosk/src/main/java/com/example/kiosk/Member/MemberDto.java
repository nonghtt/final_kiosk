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
	private String name;
	private String pwd;
	private String phonenum;
	private String birthday;
	private String email;
}
