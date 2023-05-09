package com.shayan.debtcollectionmanagement.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shayan.debtcollectionmanagement.entities.PaymentTrack;

@SpringBootTest
class PaymentTrackRepositoryTest {
	
	//this annotation is used to create a Mockito test
	@MockBean
	private PaymentTrackRepository ptrepo;

	//This annotation specifies the tets function
	@Test
	void isPaymentExistById() {
		//PaymentTrack payment=new PaymentTrack("3","3",3);
		//ptrepo.save(payment);
		//this function returns true, if the paymentId provided exists
		when(ptrepo.isPaymentExistById("4")).thenReturn(true);
		Boolean actualResult=ptrepo.isPaymentExistById("3");
		//assertThat function checks with the corresponding when() function and match both of the results
		assertThat(actualResult).isTrue();
	}

}
