package com.shayan.debtcollectionmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shayan.debtcollectionmanagement.entities.PaymentTrack;

/*this repository in the form of an interface is used to create an access layer between the database
and the service layer
extends the JpaRepository to help create that layer
(which takes the table name and the data type of primary key) */
public interface PaymentTrackRepository extends JpaRepository<PaymentTrack, String>{

	
	@Query("SELECT CASE WHEN COUNT(p)>0 THEN TRUE ELSE FALSE END FROM PaymentTrack p WHERE p.paymentTrackId=:paymentTrackId")
	Boolean isPaymentExistById(String paymentTrackId);
	//Boolean isPaymentExistById(String paymentTrackId);

	//Boolean isPaymentExistById(String paymentTrackId);
}
