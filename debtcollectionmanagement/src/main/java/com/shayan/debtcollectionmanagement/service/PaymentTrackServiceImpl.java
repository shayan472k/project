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
	
	//to get all the details from the payment_track table
	@Override
	public List<PaymentTrack> getpayment() {
		return ptr.findAll();
	}
	
	/*public PaymentTrack getpay(String key)
	{
		return ptr.getReferenceById(key);
	}*/
	
	/*public PaymentTrack addpay(PaymentTrack pt)
	{
		ptr.save(pt);
		return pt;
	}*/
	
	public PaymentTrack updatepay(PaymentTrack pt)
	{
		ptr.save(pt);
		return pt;
	}
	
	/*public void deletepay(String paymentTrackId)
	{
		PaymentTrack entity=ptr.findById(paymentTrackId);
		ptr.delete(entity);
	}*/
	
	//used to retrieve a particular row from the payment_track table
	@Override
	public PaymentTrack getpay(String paymentTrackId) {
		PaymentTrack pt=ptr.findById(paymentTrackId).orElseThrow(()->new RuntimeException());
		return pt;
	}
	
	//used to add new details to the payment_track table
	@Override
	public PaymentTrack addpay(PaymentTrack pt) {
		if(pt.getloanAmt()>0 && (pt.getStatus().equalsIgnoreCase("Recieved") || pt.getStatus().equalsIgnoreCase("Not Recieved")))
		{
			int datecomp=(pt.getPaymentRecieveDate()).compareTo(pt.getDueDateofPayment());
			if(datecomp<=0 && pt.getStatus().equalsIgnoreCase("Recieved")) {
		    ptr.save(pt);}
			else if((datecomp>0 && pt.getStatus().equalsIgnoreCase("Not Recieved"))||(datecomp>0 && pt.getStatus().equalsIgnoreCase("Recieved")))
			{
				defaulterslist.add(pt.getCustName());
				ptr.save(pt);
			}
		}
		return pt;
	}
	
	@Override
	public ArrayList<String> displayDefaulterList()
	{
		return defaulterslist;
	}
}
