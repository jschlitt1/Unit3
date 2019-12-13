package com.Jessie.ParkingApp;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
/*
*This class sets and runs things that are specific for a normal Ticket.
* @author Jessie
* @param checkInTime When the car was checked in
* @param checkOutTime When the car was checked out
* @returns The total for the ticket
 */

public class NormalTicket implements TicketType{

    private LocalTime CheckInTime;
    private LocalTime CheckOutTime;

    /*
    *calculates the total of a normal Ticket
    * @returns the total for the ticket
     */
    public double calcTotal(){
        double Total;
        int numOfHours = calcDuration();
        if(numOfHours <= 3){
            Total = MINIMUM_FEE;
        } else{
            Total = (numOfHours * HOURLY_CHARGE) + MINIMUM_FEE;
        }
        if(Total > MAX_CHARGE){
            Total = MAX_CHARGE;
        }
        return Total;
    }
    public double LostTicket(){
        return LOST_TICKET_FEE;
    }
    /*
    Lets the program know that a car is checked in. For the purpose of this project it uses also generates a random time
     */
    public void checkIn(){
        //some time between 7 am and noon
        int hour = (int)((Math.random() * 5) + 7);
        int min = (int)(Math.random() * 60);
        int sec = (int)(Math.random() * 60);
        this.CheckInTime = LocalTime.of(hour, min, sec);
    }
    /*
    Lets the program know a car has been checked out. For the purpose of this project it also generates a random time for this
     */
    public void checkOut(){
        //some time between 1pm and 11 pm
        int hour = (int)((Math.random() * 10) + 13);
        int min = (int)(Math.random() * 60);
        int sec = (int)(Math.random() * 60);

        this.CheckOutTime = LocalTime.of(hour, min, sec);
    }
    /*
    Prints out the reciept after the car has been taken out of the garage
     */
    public void receipt(){
        System.out.println("Best Value Parking Garage");
        System.out.println("==========================");
        System.out.println("");
        System.out.println(calcDuration() + " hours parked " + getCheckInTime() + " am - " + getCheckOutTime() + " pm");
        System.out.println("$" + (calcTotal()));
    }
    /*
    @returns the time checkedIn, mostly for debugging purposes
     */
    public LocalTime getCheckInTime() {
        return this.CheckInTime;
    }

    /*
    @returns the time checkedOut, mostly for debugging purposes
     */
    public LocalTime getCheckOutTime() {
        return this.CheckOutTime;
    }

    /*
    @returns the number of hours parked, to prevent stale data
     */
    private int calcDuration(){
        Duration parkTime = Duration.between(getCheckInTime(), getCheckOutTime());
        return (int)(Math.ceil(parkTime.toHours()));
    }
}
