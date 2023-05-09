package com.shayan.debtcollectionmanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shayan.debtcollectionmanagement.dao.PaymentTrackRepository;
import com.shayan.debtcollectionmanagement.entities.PaymentTrack;
import com.shayan.debtcollectionmanagement.service.PaymentTrackService;

import antlr.collections.List;

//creating a controller class to send requests from users to service layers and so forth

@RestController
public class PaymentTrackController {
	
	//creating a dependency object of the service layer
	@Autowired
	private PaymentTrackService pts;
	
	//@Autowired
	//private PaymentTrackRepository ptrepository;
	
	//ArrayList<PaymentTrack> ptr=new ArrayList<>();
	
	@GetMapping("/test")
	//@ResponseBody
	public String test()
	{
		//PaymentTrack pt=new PaymentTrack();
		//pt.setPaymentTrackId("1");
		//pt.setLoanAppId("1");
		//pt.setMonth_no(1);
		//ptrepository.save(pt);
		return "Working";
	}
	
	//creating a GET request for getting all the records in the table from the table payment_track
	@GetMapping("/get")
	public ArrayList<PaymentTrack> getPtr()
	{
		return (ArrayList<PaymentTrack>) this.pts.getpayment();
	}
	
	@GetMapping("/api/debtCollection/listOfdefaulters")
	public ArrayList<String> dispdefaultersList()
	{
		return pts.displayDefaulterList();
	}
	
	//creating a GET request for getting a row from the table payment_track
	@GetMapping("/get/{paymentTrackId}")
	public PaymentTrack getpay(@PathVariable String paymentTrackId)
	{
		return this.pts.getpay(paymentTrackId);
	}
	
	//creating a POST request for adding data into the table payment_track
	@PostMapping("/postpay")
	public PaymentTrack addpay(@RequestBody PaymentTrack pt)
	{
		return this.pts.addpay(pt);
	}
	
	/*@PostMapping("ptr/add")
	public PaymentTrack addPtr(@RequestBody PaymentTrack ptrr) {
		ptr.add(ptrr);
		return ptrr;
	}*/
}
