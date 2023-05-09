package com.shayan.debtcollectionmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shayan.debtcollectionmanagement.entities.PaymentTrack;

/*this repository in the form of an interface is used to create an access layer between the database
and the service layer
extends the JpaRepository to help create that layer
(which takes the table name and the data type of primary key) */
public interface PaymentTrackRepository extends JpaRepository<PaymentTrack, String>{

	//this query is used to check, whether the paymentTrackId given by the user exists in the table or not
	@Query("SELECT CASE WHEN COUNT(p)>0 THEN TRUE ELSE FALSE END FROM PaymentTrack p WHERE p.paymentTrackId=:paymentTrackId")
	
	//This is the Mockito testing function, used to Mock the PaymentTrackRepository
	Boolean isPaymentExistById(String paymentTrackId);
}
