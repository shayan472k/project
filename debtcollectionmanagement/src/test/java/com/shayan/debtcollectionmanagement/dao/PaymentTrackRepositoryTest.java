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
	
	@MockBean
	private PaymentTrackRepository ptrepo;

	@Test
	void isPaymentExistById() {
		//PaymentTrack payment=new PaymentTrack("3","3",3);
		//ptrepo.save(payment);
		when(ptrepo.isPaymentExistById("4")).thenReturn(true);
		Boolean actualResult=ptrepo.isPaymentExistById("3");
		assertThat(actualResult).isTrue();
	}

}
