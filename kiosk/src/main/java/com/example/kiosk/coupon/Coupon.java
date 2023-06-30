package com.example.kiosk.coupon;

import java.util.Date;
import java.util.Random;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.kiosk.Member.Member;

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
	private int couponnum;
	
	@JoinColumn(name="id" ,nullable = false)
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Member id;
	private Date issueddate;
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
        couponnum = Integer.parseInt(sb.toString());
        issueddate = new Date();
		
	}
	
}
