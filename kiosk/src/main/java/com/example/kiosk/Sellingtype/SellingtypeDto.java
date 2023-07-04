package com.example.kiosk.Sellingtype;


import java.util.Date;

import com.example.kiosk.Member.Member;
import com.example.kiosk.coupon.Coupon;

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
public class SellingtypeDto {

	private int tempnum;
	private Member id;
	private Coupon couponnum;
	private int productnum;
	private int sellproduct;
	private String storeid;
	private Date wdate;

}
