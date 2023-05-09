package com.shayan.debtcollectionmanagement.entities;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Value;
//import jakarta.*;

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
	
	//stores the loanAppId from loanApplicationTable
	private String loanAppId;
	
	//stores the month number of giving the loan
	private int month_no;
	private String custName;
	
	//@Min(value = 18, message = "Age should not be less than 18")
	private int loanAmt;
	
	//default value of status is set to Not Received
	
	//stores the status of payment, is either recieved or not recieved
	@Column(columnDefinition = "varchar(255) default 'Not Recieved'")
	private String status;
	
	//stores the date before which payment must be made
	private Date dueDateofPayment;
	
	//stores the date when payment gets recieved
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
	public int getloanAmt()
	{
		return loanAmt;
	}
	public void setloanAmt(int loanAmt)
	{
		this.loanAmt=loanAmt;
	}
	public String getCustName()
	{
		return custName;
	}
	public void setCustName(String custName)
	{
		this.custName=custName;
	}

}
