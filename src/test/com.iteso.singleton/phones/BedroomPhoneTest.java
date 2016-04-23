package phones;

/**
 * Created by alexabeas on 4/22/16.
 */
import static org.junit.Assert.*;

import com.iteso.singleton.PhoneLine;
import com.iteso.singleton.iPhone;
import com.iteso.singleton.phones.BedroomPhone;
import com.iteso.singleton.phones.GaragePhone;
import com.iteso.singleton.phones.KitchenPhone;
import com.iteso.singleton.phones.LivingroomPhone;
import org.junit.Test;
import org.junit.Before;

public class BedroomPhoneTest {

    iPhone bedroomphone;

    @Before
    public void setUp(){
        bedroomphone = new BedroomPhone();
    }

    @Test
    public void testDialNumberWhenAvailable(){
        assertEquals("Calling 12345", bedroomphone.dialNumber(12345));
    }

    @Test
    public void testDialNumberWhenBusy(){
        iPhone livingroomphone = new LivingroomPhone();
        livingroomphone.dialNumber(12345);
        assertEquals("Line is busy", bedroomphone.dialNumber(6789));
        PhoneLine.getInstance().hangUp();
    }

    @Test
    public void testcheckAvailabilityOfPhoneLineWhenAvailable(){
        assertFalse(bedroomphone.checkAvailabilityOfPhoneLine(PhoneLine.getInstance()));
    }

    @Test
    public void testcheckAvailabilityOfPhoneLineWhenBusy(){
        iPhone kitchenphone = new KitchenPhone();
        kitchenphone.dialNumber(12345);
        assertTrue(bedroomphone.checkAvailabilityOfPhoneLine(PhoneLine.getInstance()));
    }
}
