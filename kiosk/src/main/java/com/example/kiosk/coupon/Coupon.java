package com.example.kiosk.coupon;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.kiosk.Member.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
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
public class Coupon {
	
	@Id
	private String couponnum;
	
	@JoinColumn(name="id" ,nullable = false)
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Member userid;
	private String storeid;
	private Date issueddate;
	@Column(nullable = true)
	private Date useddate;
	private Date expiredate;
	private boolean used;
	
	@PrePersist
	public void prepersist() {
		int LENGTH = 15;
		Random random = new Random();
        StringBuilder sb = new StringBuilder(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            int randomDigit = random.nextInt(10);
            sb.append(randomDigit);
        }
        couponnum = sb.toString();
        issueddate = new Date();
        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.DATE, 365); // 일 계산	
        expiredate = new Date(cal1.getTimeInMillis());
        
        
        		
		
	}
	
}
