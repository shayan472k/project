package com.shayan.debtcollectionmanagement.entities;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Value;

//creating a class as an entity to store into the database

@Entity
@Table(name="paymentTrack")
public class PaymentTrack {
	
	public PaymentTrack() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PaymentTrack(String paymentTrackId, String loanAppId,int month_no)
	{
		this.paymentTrackId=paymentTrackId;
		this.loanAppId=loanAppId;
		this.month_no=month_no;
	}
	
	//declaring the primary key
	@Id
	private String paymentTrackId;
	
	private String loanAppId;
	private int month_no;
	
	//default value of status is set to Not Received
	
	@Value("Not Received")
	private String status;
	
	private Date dueDateofPayment;
	private Date paymentRecieveDate;
	
	//creating getters and setters for the class variables
	public String getPaymentTrackId() {
		return paymentTrackId;
	}
	public void setPaymentTrackId(String paymentTrackId) {
		this.paymentTrackId = paymentTrackId;
	}
	public String getLoanAppId() {
		return loanAppId;
	}
	public void setLoanAppId(String loanAppId) {
		this.loanAppId = loanAppId;
	}
	public int getMonth_no() {
		return month_no;
	}
	public void setMonth_no(int month_no) {
		this.month_no = month_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDueDateofPayment() {
		return dueDateofPayment;
	}
	public void setDueDateofPayment(Date dueDateofPayment) {
		this.dueDateofPayment = dueDateofPayment;
	}
	public Date getPaymentRecieveDate() {
		return paymentRecieveDate;
	}
	public void setPaymentRecieveDate(Date paymentRecieveDate) {
		this.paymentRecieveDate = paymentRecieveDate;
	}

}
