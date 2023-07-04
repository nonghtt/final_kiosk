package com.example.kiosk.Sellingtype;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.kiosk.Member.Member;
import com.example.kiosk.coupon.Coupon;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Sellingtype {
	
	@Id
	@SequenceGenerator(name="seq_sellingtype",sequenceName = "seq_sellingtype",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_sellingtype")
	private int tempnum;
	
	
	@JoinColumn(name="id", nullable=false)
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Member id;
	
	@JoinColumn(name="couponnum" ,nullable = false)
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Coupon couponnum;
	
	private int productnum;
	private int sellproduct;
	private String storeid;
	private Date wdate;

	@PrePersist
	private void sysdate() {
		wdate = new Date();
	}
	
	
}
