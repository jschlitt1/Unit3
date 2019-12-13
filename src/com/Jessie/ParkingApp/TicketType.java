package com.Jessie.ParkingApp;

import java.time.LocalTime;
/*
* To prevent magic numbers as well as tell what needs to be impimented across all of our classes
*@author Jessie
* @param MINIMUM_FEE the least amount you have to pay no matter the ticket
* @param HOURLY_CHARGE how much the garage charges an hour
* @param MAX_CHARGE the most it could ever be
* @param LOST_TICKET_FEE how much a lost ticket costs
* @param SPECIAL_EVENT how much a special event costs
 */
public interface TicketType{
    //To prevent "Magic Numbers"
    double MINIMUM_FEE = 5.00;
    double HOURLY_CHARGE = 1.00;
    double MAX_CHARGE = 15.00;
    double LOST_TICKET_FEE = 25.00;
    double SPECIAL_EVENT = 20;

    public double calcTotal();
    public void checkIn();
    public void checkOut();
    public void receipt();
}
