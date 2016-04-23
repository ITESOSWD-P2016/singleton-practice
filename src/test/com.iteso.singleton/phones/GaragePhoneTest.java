package phones;

import com.iteso.singleton.PhoneLine;
import com.iteso.singleton.iPhone;
import com.iteso.singleton.phones.GaragePhone;
import com.iteso.singleton.phones.KitchenPhone;
import com.iteso.singleton.phones.LivingroomPhone;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by alexabeas on 4/22/16.
 */
public class GaragePhoneTest {
    iPhone garagephone;

    @Before
    public void setUp(){
        garagephone = new GaragePhone();
    }

    @Test
    public void testDialNumberWhenAvailable(){
        PhoneLine.getInstance().hangUp();
        assertEquals("Calling 12345", garagephone.dialNumber(12345));
    }

    @Test
    public void testDialNumberWhenBusy(){
        iPhone livingroomphone = new LivingroomPhone();
        livingroomphone.dialNumber(12345);
        assertEquals("Line is busy", garagephone.dialNumber(6789));
        PhoneLine.getInstance().hangUp();
    }

    @Test
    public void testcheckAvailabilityOfPhoneLineWhenAvailable(){
        assertFalse(garagephone.checkAvailabilityOfPhoneLine(PhoneLine.getInstance()));
    }

    @Test
    public void testcheckAvailabilityOfPhoneLineWhenBusy(){
        iPhone kitchenphone = new KitchenPhone();
        kitchenphone.dialNumber(12345);
        assertTrue(garagephone.checkAvailabilityOfPhoneLine(PhoneLine.getInstance()));
    }
}
