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
	
	//A simple test functution to check, whether the controller is working or not
	@GetMapping("/test")
	public String test()
	{
		return "Working";
	}
	
	//creating a GET request for getting all the records in the table from the table payment_track
	@GetMapping("/api/debtCollection/getloanusers")
	public ArrayList<PaymentTrack> getPtr()
	{
		return (ArrayList<PaymentTrack>) this.pts.getpayment();
	}
	
	/* This method calls the list of defaulters, 
	which stores the name of people who paid their dues after due date */
	@GetMapping("/api/debtCollection/listOfdefaulters")
	public ArrayList<String> dispdefaultersList()
	{
		return pts.displayDefaulterList();
	}
	
	//creating a GET request for getting a(singular) row of details from the table payment_track
	@GetMapping("/get/{paymentTrackId}")
	public PaymentTrack getpay(@PathVariable String paymentTrackId)
	{
		return this.pts.getpay(paymentTrackId);
	}
	
	//creating a POST request for adding data into the table payment_track
	@PostMapping("/api/debtCollection/create")
	public PaymentTrack addpay(@RequestBody PaymentTrack pt)
	{
		return this.pts.addpay(pt);
	}
	
}
