package com.shayan.debtcollectionmanagement.service;

import java.util.ArrayList;
import java.util.List;

import com.shayan.debtcollectionmanagement.entities.*;

//creating an interface of service layer implementation for loose coupling  
public interface PaymentTrackService {
	
	public List<PaymentTrack> getpayment();
	
	public PaymentTrack getpay(String paymentTrackId);
	
	public PaymentTrack addpay(PaymentTrack pt);

	public ArrayList<String> displayDefaulterList();
	
}
