
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.shayan.debtcollectionmanagement.dao.PaymentTrackRepository;
import com.shayan.debtcollectionmanagement.service.PaymentTrackService;
import com.shayan.debtcollectionmanagement.service.PaymentTrackServiceImpl;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import com.shayan.debtcollectionmanagement.entities.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {PaymentTrackServiceTest.class})
public class PaymentTrackServiceTest {

	public List<PaymentTrack> pt;
	
    @Mock
    PaymentTrackRepository ptr;

    @InjectMocks 
    PaymentTrackServiceImpl paymentTrackService;

    @Test
    public void test_getpayment()
    {
    	List<PaymentTrack> pt=new ArrayList<PaymentTrack>();
    	pt.add(new PaymentTrack("11","11",10));
    	pt.add(new PaymentTrack("12","12",11));
    	when(ptr.findAll()).thenReturn(pt);
    	paymentTrackService.getpayment();
    	assertEquals(2,paymentTrackService.getpayment().size());
    }
    
    public void test_getpay()
    {
    	//List<PaymentTrack> pt=new ArrayList<PaymentTrack>();
    	PaymentTrack pt = new PaymentTrack("11","11",10);
    	String id="11";
    	when(ptr.findById(id)).thenReturn(pt);
    	assertEquals(pt,paymentTrackService.getpay(id));
    }
    
    public void test_addpay()
    {
    	PaymentTrack pt=new PaymentTrack("13","13",13);
    	when(ptr.save(pt)).thenReturn(pt);
    	assertEquals(pt,paymentTrackService.addpay(pt));
    }
}
