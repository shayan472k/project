package com.shayan.debtcollectionmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shayan.debtcollectionmanagement.dao.PaymentTrackRepository;
import com.shayan.debtcollectionmanagement.entities.PaymentTrack;

@Service
public class PaymentTrackServiceImpl implements PaymentTrackService {
	
	@Autowired
	private PaymentTrackRepository ptr;

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
	
	public void deletepay(String key)
	{
		PaymentTrack entity=ptr.getReferenceById(key);
		ptr.delete(entity);
	}

	@Override
	public PaymentTrack getpay(String paymentTrackId) {
		return ptr.getReferenceById(paymentTrackId);
	}

	@Override
	public PaymentTrack addpay(PaymentTrack pt) {
		ptr.save(pt);
		return pt;
	}
}
