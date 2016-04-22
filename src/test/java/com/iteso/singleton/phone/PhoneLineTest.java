package com.iteso.singleton.phone;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iteso.singleton.PhoneLine;

public class PhoneLineTest {
	
	@Test
    public void testGetPhoneLine(){
        assertNotNull(PhoneLine.getPhoneLine());
    }
	
	@Test
    public void testWhenPhoneLineIsBusy(){
		PhoneLine.getPhoneLine().callNumber(12221212);
        assertTrue(PhoneLine.getPhoneLine().isBusyLine());
    }
	
	@Test
    public void testWhenPhoneLineIsNotBusy(){
		PhoneLine.getPhoneLine().callNumber(12221212);
		PhoneLine.getPhoneLine().hangUp();
        assertFalse(PhoneLine.getPhoneLine().isBusyLine());
    }
	
	@Test
    public void testGetLastNumber(){
		PhoneLine.getPhoneLine().callNumber(12221212);
        assertEquals(12221212, PhoneLine.getPhoneLine().getLastnumber());
    }
	
}
