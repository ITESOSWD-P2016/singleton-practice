package com.iteso.singleton.phones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.iteso.singleton.PhoneLine;
import com.iteso.singleton.iPhone;

public class GaragePhoneTest {
	iPhone oPhone;
	
	@Before
	public void setUp(){
		oPhone = new GaragePhone();
	}
    
    @Test
    public void testDialNumberWhenNotAvailable(){
    	iPhone oKitchenPhone = new KitchenPhone();
    	oKitchenPhone.dialNumber(9990);
        assertEquals("The line is busy.", oPhone.dialNumber(233322));
    }
    
    @Test
    public void testcheckAvailabilityOfPhoneLineWhenAvailable(){
        assertFalse(oPhone.checkAvailabilityOfPhoneLine(PhoneLine.getPhoneLine()));
    }
    
    @Test
    public void testcheckAvailabilityOfPhoneLineWhenBusy(){
    	iPhone oKitchenPhone = new KitchenPhone();
    	oKitchenPhone.dialNumber(8889);
        assertTrue(oPhone.checkAvailabilityOfPhoneLine(PhoneLine.getPhoneLine()));
    }
    
    @Test
    public void testDialNumberWhenAvailable(){
    	PhoneLine.getPhoneLine().setBusyLine(false);
        assertEquals("Calling 233322", oPhone.dialNumber(233322));
    }
}
