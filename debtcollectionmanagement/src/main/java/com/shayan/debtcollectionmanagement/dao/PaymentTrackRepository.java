package com.shayan.debtcollectionmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shayan.debtcollectionmanagement.entities.PaymentTrack;

public interface PaymentTrackRepository extends JpaRepository<PaymentTrack, String>{
	
}
