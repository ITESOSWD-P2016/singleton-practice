package com.iteso.singleton.phones;

import com.iteso.singleton.PhoneLine;
import com.iteso.singleton.iPhone;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Sebastian on 26/04/16.
 */
public class LivingroomPhoneTest {
    iPhone livingroomphone;

    @Before
    public void setUp(){
        livingroomphone = new LivingroomPhone();
    }

    @Test
    public void testDialNumberWhenAvailable(){
        assertEquals("Calling 12345", livingroomphone.dialNumber(12345));
    }

    @Test
    public void testDialNumberWhenBusy(){
        iPhone bedroomphone = new BedroomPhone();
        bedroomphone.dialNumber(12345);
        assertEquals("Line is busy", livingroomphone.dialNumber(6789));
        PhoneLine.getUniquePhoneLine().hangUp();
    }

    @Test
    public void testcheckAvailabilityOfPhoneLineWhenAvailable(){
        assertFalse(livingroomphone.checkAvailabilityOfPhoneLine(PhoneLine.getUniquePhoneLine()));
    }

    @Test
    public void testcheckAvailabilityOfPhoneLineWhenBusy(){
        iPhone garagephone = new GaragePhone();
        garagephone.dialNumber(12345);
        assertTrue(livingroomphone.checkAvailabilityOfPhoneLine(PhoneLine.getUniquePhoneLine()));
    }
}
