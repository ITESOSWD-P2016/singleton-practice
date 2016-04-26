package com.iteso.singleton;

import org.junit.Test;
import static org.junit.Assert.*;
import com.iteso.singleton.phones.KitchenPhone;
/**
 * Created by Sebastian on 26/04/16.
 */
public class PhoneLineTest {
    @Test
    public void testGetInstance(){
        assertNotNull(PhoneLine.getUniquePhoneLine());
    }

    @Test
    public void testCallNumber(){
        assertEquals("Calling 34234565", PhoneLine.getUniquePhoneLine().callNumber(34234565));
    }

    @Test
    public void testHangUp(){
        PhoneLine.getUniquePhoneLine().hangUp();
        assertFalse(PhoneLine.getUniquePhoneLine().isBusyLine());
    }

    @Test
    public void testisBusyLineWhenBusy(){
        iPhone kitphone= new KitchenPhone();
        kitphone.dialNumber(656565);
        assertTrue(PhoneLine.getUniquePhoneLine().isBusyLine());
    }

    @Test
    public void testisBusyLineWhenAvailable(){
        PhoneLine.getUniquePhoneLine().hangUp();
        assertFalse(PhoneLine.getUniquePhoneLine().isBusyLine());
    }

    @Test
    public void testSetBusyLineWhenTrue(){
        PhoneLine.getUniquePhoneLine().setBusyLine(true);
        assertTrue(PhoneLine.getUniquePhoneLine().isBusyLine());
    }

    @Test
    public void testSetBusyLineWhenFalse(){
        PhoneLine.getUniquePhoneLine().setBusyLine(false);
        assertFalse(PhoneLine.getUniquePhoneLine().isBusyLine());
    }

    @Test
    public void testGetLastNumber(){
        iPhone kitphone= new KitchenPhone();
        kitphone.dialNumber(00000);
        assertEquals(00000, PhoneLine.getUniquePhoneLine().getLastnumber());

    }
}
