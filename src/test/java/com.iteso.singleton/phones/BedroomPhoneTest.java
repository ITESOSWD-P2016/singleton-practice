package com.iteso.singleton.phones;

import com.iteso.singleton.PhoneLine;
import com.iteso.singleton.iPhone;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Sebastian on 26/04/16.
 */
public class BedroomPhoneTest {
    iPhone bedroomphone;

    @Before
    public void setUp(){
        bedroomphone = new BedroomPhone();
    }

    @Test
    public void testDialNumberWhenAvailable(){
        assertEquals("Calling 8787", bedroomphone.dialNumber(8787));
    }

    @Test
    public void testDialNumberWhenBusy(){
        iPhone livingroomphone = new LivingroomPhone();
        livingroomphone.dialNumber(123);
        assertEquals("Line is busy", bedroomphone.dialNumber(789));
        PhoneLine.getUniquePhoneLine().hangUp();
    }

    @Test
    public void testcheckAvailabilityOfPhoneLineWhenAvailable(){
        assertFalse(bedroomphone.checkAvailabilityOfPhoneLine(PhoneLine.getUniquePhoneLine()));
    }

    @Test
    public void testcheckAvailabilityOfPhoneLineWhenBusy(){
        iPhone kitchenphone = new KitchenPhone();
        kitchenphone.dialNumber(456);
        assertTrue(bedroomphone.checkAvailabilityOfPhoneLine(PhoneLine.getUniquePhoneLine()));
    }
}
