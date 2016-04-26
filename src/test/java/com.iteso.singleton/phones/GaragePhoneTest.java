package com.iteso.singleton.phones;

import com.iteso.singleton.PhoneLine;
import com.iteso.singleton.iPhone;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Sebastian on 26/04/16.
 */
public class GaragePhoneTest {
    iPhone garagephone;

    @Before
    public void setUp(){
        garagephone = new GaragePhone();
    }

    @Test
    public void testDialNumberWhenAvailable(){
        PhoneLine.getUniquePhoneLine().hangUp();
        assertEquals("Calling 12345", garagephone.dialNumber(12345));
    }

    @Test
    public void testDialNumberWhenBusy(){
        iPhone livingroomphone = new LivingroomPhone();
        livingroomphone.dialNumber(12345);
        assertEquals("Line is busy", garagephone.dialNumber(6789));
        PhoneLine.getUniquePhoneLine().hangUp();
    }

    @Test
    public void testcheckAvailabilityOfPhoneLineWhenAvailable(){
        assertFalse(garagephone.checkAvailabilityOfPhoneLine(PhoneLine.getUniquePhoneLine()));
    }

    @Test
    public void testcheckAvailabilityOfPhoneLineWhenBusy(){
        iPhone kitchenphone = new KitchenPhone();
        kitchenphone.dialNumber(12345);
        assertTrue(garagephone.checkAvailabilityOfPhoneLine(PhoneLine.getUniquePhoneLine()));
    }

}
