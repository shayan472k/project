package com.shayan.debtcollectionmanagement.service;

import java.util.List;

import com.shayan.debtcollectionmanagement.entities.*;

public interface PaymentTrackService {
	
	public List<PaymentTrack> getpayment();
	
	public PaymentTrack getpay(String paymentTrackId);
	
	public PaymentTrack addpay(PaymentTrack pt);
	
}
