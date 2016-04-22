package com.iteso.singleton.phones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.iteso.singleton.PhoneLine;
import com.iteso.singleton.iPhone;

public class LivingroomPhoneTest {
	iPhone oPhone;
	
	@Before
	public void setUp(){
		oPhone = new KitchenPhone();
	}
    
    @Test
    public void testDialNumberWhenNotAvailable(){
    	iPhone oGaragePhone = new GaragePhone();
    	oGaragePhone.dialNumber(9990);
        assertEquals("The line is busy.", oPhone.dialNumber(233322));
    }
    
    @Test
    public void testcheckAvailabilityOfPhoneLineWhenAvailable(){
        assertFalse(oPhone.checkAvailabilityOfPhoneLine(PhoneLine.getPhoneLine()));
    }
    
    @Test
    public void testcheckAvailabilityOfPhoneLineWhenBusy(){
    	iPhone oGaragePhone = new GaragePhone();
    	oGaragePhone.dialNumber(8889);
        assertTrue(oPhone.checkAvailabilityOfPhoneLine(PhoneLine.getPhoneLine()));
    }
    
    @Test
    public void testDialNumberWhenAvailable(){
    	PhoneLine.getPhoneLine().setBusyLine(false);
        assertEquals("Calling 233322", oPhone.dialNumber(233322));
    }
}
