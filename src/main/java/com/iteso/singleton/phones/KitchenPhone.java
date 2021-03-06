package com.iteso.singleton.phones;

import com.iteso.singleton.PhoneLine;
import com.iteso.singleton.iPhone;

/**
 * Created by rvillalobos on 4/22/16.
 */
public class KitchenPhone implements iPhone {

    public void dialNumber(int number) {
        PhoneLine phoneLine = new PhoneLine();
        if (!checkAvailabilityOfPhoneLine(phoneLine)){
            phoneLine.callNumber(number);
        }
    }

    public boolean checkAvailabilityOfPhoneLine(PhoneLine phoneLine) {
        return phoneLine.isBusyLine();
    }
}
