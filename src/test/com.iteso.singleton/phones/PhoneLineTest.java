package phones;

import com.iteso.singleton.PhoneLine;
import com.iteso.singleton.iPhone;
import com.iteso.singleton.phones.BedroomPhone;
import com.iteso.singleton.phones.GaragePhone;
import com.iteso.singleton.phones.KitchenPhone;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alexabeas on 4/22/16.
 */
public class PhoneLineTest {

    @Test
    public void testGetInstance(){
        assertNotNull(PhoneLine.getInstance());
    }

    @Test
    public void testCallNumber(){
        assertEquals("Calling 12345", PhoneLine.getInstance().callNumber(12345));
    }

    @Test
    public void testHangUp(){
        PhoneLine.getInstance().hangUp();
        assertFalse(PhoneLine.getInstance().isBusyLine());
    }

    @Test
    public void testisBusyLineWhenBusy(){
        iPhone brphone= new BedroomPhone();
        brphone.dialNumber(1234567);
        assertTrue(PhoneLine.getInstance().isBusyLine());
    }

    @Test
    public void testisBusyLineWhenAvailable(){
        PhoneLine.getInstance().hangUp();
        assertFalse(PhoneLine.getInstance().isBusyLine());
    }

    @Test
    public void testSetBusyLineWhenTrue(){
        PhoneLine.getInstance().setBusyLine(true);
        assertTrue(PhoneLine.getInstance().isBusyLine());
    }

    @Test
    public void testSetBusyLineWhenFalse(){
        PhoneLine.getInstance().setBusyLine(false);
        assertFalse(PhoneLine.getInstance().isBusyLine());
    }

    @Test
    public void testGetLastNumber(){
        iPhone brphone= new BedroomPhone();
        brphone.dialNumber(1234567);
        assertEquals(1234567, PhoneLine.getInstance().getLastnumber());

    }
}
