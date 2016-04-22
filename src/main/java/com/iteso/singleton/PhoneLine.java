package com.iteso.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: rvillalobos
 * Date: 10/6/13
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */

public class PhoneLine {

    private boolean busyLine = false;
    private int lastnumber = 0;
    private static PhoneLine uniquePhoneLine;
    

    private PhoneLine (){ }
    
    public static PhoneLine getPhoneLine(){
    	if (uniquePhoneLine == null)
    		uniquePhoneLine = new PhoneLine();
    	return uniquePhoneLine;
    }

    public String callNumber(int phoneNumber){
        setLastnumber(phoneNumber);
        setBusyLine(true);
        
        return "Calling " + phoneNumber;
    }

    public void hangUp(){
        if(isBusyLine()){
            setBusyLine(false);
        }
    }

    public boolean isBusyLine() {
        return busyLine;
    }

    public void setBusyLine(boolean busyLine) {
        this.busyLine = busyLine;
    }

    public int getLastnumber() {
        return lastnumber;
    }

    public void setLastnumber(int lastnumber) {
        this.lastnumber = lastnumber;
    }
}
