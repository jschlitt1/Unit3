package com.Jessie.ParkingApp;

import java.time.LocalTime;

public class SpecialEvent implements TicketType{
    /*
    *@returns the special event fee
     */
    public double calcTotal(){
        return SPECIAL_EVENT;
    }
    /*
    Does not happen durung an event
     */
    public void checkIn(){}
    /*
    Does not happen durung an event
     */
    public void checkOut(){}
    /*
    Prints out the recipt of the Special event ticket
     */
    public void receipt() {
        System.out.println("Best Value Parking Garage");
        System.out.println("==========================");
        System.out.println("");
        System.out.println("$" + (calcTotal()));
    }
}
