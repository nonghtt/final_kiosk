package com.example.kiosk.coupon;

import java.util.Date;

import com.example.kiosk.Member.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CouponDto {
	private String couponnum;
	private Member id;
	private String storeid;
	private Date issueddate;
	private Date useddate;
	private Date expiredate;
	private boolean used;
}
