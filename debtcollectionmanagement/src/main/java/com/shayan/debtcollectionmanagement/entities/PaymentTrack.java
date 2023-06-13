package com.shayan.debtcollectionmanagement.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
//import jakarta.*;

//creating a class as an entity to store into the database

@Entity
@CrossOrigin(origins = "*")
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
	@NotNull
	private String custName;
	
	//@Min(value = 18, message = "Age should not be less than 18")
	private int loanAmt;
	
	//default value of status is set to Not Received
	
	//stores the status of payment, is either recieved or not recieved
	@Column(columnDefinition = "varchar(255) default 'Not Recieved'")
	@Pattern(regexp = "^(Recieved|Not Recieved)$" , message="Not Allowed")
	private String status;
	
	//stores the date before which payment must be made
	private LocalDate dueDateofPayment;
	
	//stores the date when payment gets recieved
	private LocalDate paymentRecieveDate;
	
	@Override
	public String toString() {
		return "PaymentTrack [paymentTrackId=" + paymentTrackId + ", loanAppId=" + loanAppId + ", month_no=" + month_no
				+ ", custName=" + custName + ", loanAmt=" + loanAmt + ", status=" + status + ", dueDateofPayment="
				+ dueDateofPayment + ", paymentRecieveDate=" + paymentRecieveDate + "]";
	}

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
	public LocalDate getDueDateofPayment() {
		return dueDateofPayment;
	}
	public void setDueDateofPayment(LocalDate dueDateofPayment) {
		this.dueDateofPayment = dueDateofPayment;
	}
	public LocalDate getPaymentRecieveDate() {
		return paymentRecieveDate;
	}
	public void setPaymentRecieveDate(LocalDate paymentRecieveDate) {
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
