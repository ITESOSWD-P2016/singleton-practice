package phones;

import com.iteso.singleton.PhoneLine;
import com.iteso.singleton.iPhone;
import com.iteso.singleton.phones.BedroomPhone;
import com.iteso.singleton.phones.GaragePhone;
import com.iteso.singleton.phones.KitchenPhone;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by alexabeas on 4/22/16.
 */
public class KitchenPhoneTest {
    iPhone kitchenphone;

    @Before
    public void setUp(){
        kitchenphone = new KitchenPhone();
    }

    @Test
    public void testDialNumberWhenAvailable(){
        assertEquals("Calling 12345", kitchenphone.dialNumber(12345));
    }

    @Test
    public void testDialNumberWhenBusy(){
        iPhone bedroomphone = new BedroomPhone();
        bedroomphone.dialNumber(12345);
        assertEquals("Line is busy", kitchenphone.dialNumber(6789));
        PhoneLine.getInstance().hangUp();
    }

    @Test
    public void testcheckAvailabilityOfPhoneLineWhenAvailable(){
        assertFalse(kitchenphone.checkAvailabilityOfPhoneLine(PhoneLine.getInstance()));
    }

    @Test
    public void testcheckAvailabilityOfPhoneLineWhenBusy(){
        iPhone garagephone = new GaragePhone();
        garagephone.dialNumber(12345);
        assertTrue(kitchenphone.checkAvailabilityOfPhoneLine(PhoneLine.getInstance()));
    }
}
