package com.shayan.debtcollectionmanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shayan.debtcollectionmanagement.dao.PaymentTrackRepository;
import com.shayan.debtcollectionmanagement.entities.PaymentTrack;

import antlr.collections.List;

@RestController
public class PaymentTrackController {
	
	@Autowired
	private PaymentTrackRepository ptrepository;
	
	ArrayList<PaymentTrack> ptr=new ArrayList<>();
	
	@GetMapping("/test")
	//@ResponseBody
	public String test()
	{
		PaymentTrack pt=new PaymentTrack();
		//pt.setPaymentTrackId("1");
		//pt.setLoanAppId("1");
		//pt.setMonth_no(1);
		//ptrepository.save(pt);
		return "Working";
	}
	
	@GetMapping("/get")
	public ArrayList<PaymentTrack> getPtr()
	{
		return ptr;
	}
	
	@PostMapping("ptr/add")
	public PaymentTrack addPtr(@RequestBody PaymentTrack ptrr) {
		ptr.add(ptrr);
		return ptrr;
	}
}
