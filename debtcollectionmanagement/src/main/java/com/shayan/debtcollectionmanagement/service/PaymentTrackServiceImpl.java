package com.shayan.debtcollectionmanagement.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shayan.debtcollectionmanagement.dao.PaymentTrackRepository;
import com.shayan.debtcollectionmanagement.entities.PaymentTrack;

//creating an implementation class of the Service layer's interface for loose coupling

@Service
public class PaymentTrackServiceImpl implements PaymentTrackService {
	
	//calling the dependency into the dependable class using autowired annotation 
	@Autowired
	private PaymentTrackRepository ptr;
	
	ArrayList <String> defaulterslist =new ArrayList<>();

	//@Override annotation to call the interface methods for implementation
	
	/* This function is used for retrieving
	 * all the details from the payment_track table
	 * and sending the details(object of repository) to the controller function(getPtr())
	 */
	@Override
	public List<PaymentTrack> getpayment() {
		return ptr.findAll();
	}
	
	
	/*public PaymentTrack updatepay(PaymentTrack pt)
	{
		ptr.save(pt);
		return pt;
	}*/
	
	/* This function is used for
	 * retrieving a particular row from the payment_track table
	 * and returning the value to the controller function(getpay())
	 */
	@Override
	public PaymentTrack getpay(String paymentTrackId) {
		PaymentTrack pt=ptr.findById(paymentTrackId).orElseThrow(()->new RuntimeException());
		return pt;
	}
	
	//used to add new details to the payment_track table
	@Override
	public PaymentTrack addpay(PaymentTrack pt) {
		/*
		 * Over here, we are checking, if the loan amount is above 0 and status of loan paid is recieved or not recieved
		 * Other wise it won't store the detail into the payment_track table 
		 */
		if(pt.getloanAmt()>0 && (pt.getStatus().equalsIgnoreCase("Recieved") || pt.getStatus().equalsIgnoreCase("Not Recieved")))
		{
			int datecomp=(pt.getPaymentRecieveDate()).compareTo(pt.getDueDateofPayment());
			/*
			 * here we are creating a condtion for getting the names for defaulters list
			 * The compareTo function is used to compare the dates and give a value
			 */
			if(datecomp<=0 && pt.getStatus().equalsIgnoreCase("Recieved")) {
		    ptr.save(pt);}
			else if((datecomp>0 && pt.getStatus().equalsIgnoreCase("Not Recieved"))||(datecomp>0 && pt.getStatus().equalsIgnoreCase("Recieved")))
			{
				//here we are adding the names of customer who fall in the defaulters category
				defaulterslist.add(pt.getCustName());
				ptr.save(pt);
			}
		}
		return pt;
	}
	
	//This function passes the ArrayList name defaultersList to controller's function dispdefaultersList()
	@Override
	public ArrayList<String> displayDefaulterList()
	{
		return defaulterslist;
	}
}
