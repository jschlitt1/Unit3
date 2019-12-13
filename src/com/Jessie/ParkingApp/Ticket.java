package com.Jessie.ParkingApp;

/*
*This is the "driver" class for all the tickets. Anything that a ticket may need, it will be here
 */
public class Ticket implements Fees{
    private double Total = 0;
    private TicketType ticketType;


    public void setTicketType(TicketType ticketType){
        this.ticketType = ticketType;
    }

    public static void LostTicketReceipt(){
        System.out.println("Best Value Parking Garage");
        System.out.println("==========================");
        System.out.println("");
        System.out.println("Lost Ticket");
        System.out.println("$" + LOST_TICKET_FEE);
    }
    public void checkIn(){
        if(ticketType != null){
            ticketType.checkIn();
        }
    }
    public void checkOut(){
        if(ticketType != null){
            ticketType.checkOut();
        }
    }

    public void Receipt() {
        if (ticketType != null) {
            ticketType.receipt();
        }
    }

    public double calcTotal(){
        if(ticketType != null){
            Total = ticketType.calcTotal();
        }
        return Total;
    }


}
