package com.iteso.singleton.phones;

import com.iteso.singleton.PhoneLine;
import com.iteso.singleton.iPhone;

/**
 * Created by rvillalobos on 4/22/16.
 */
public class LivingroomPhone implements iPhone {

    public String dialNumber(int number) {
        PhoneLine phoneLine = PhoneLine.getPhoneLine();
        if (!checkAvailabilityOfPhoneLine(phoneLine)) 
        	return phoneLine.callNumber(number);
        else 
        	return "The line is busy.";
    }

    public boolean checkAvailabilityOfPhoneLine(PhoneLine phoneLine) {
        return phoneLine.isBusyLine();
    }
}
