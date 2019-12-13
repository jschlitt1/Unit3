package com.Jessie.ParkingApp;

import java.util.Scanner;
/*
*This is the main class that runs the program. it keeps track of info that would be wanted by the owner at the end of the
* @author Jessie
* @param choice is the menu driver. It keeps hold of the user choice and tells the program what to do in the switch statement
* @param CarIm The menu changes based off if a car is in the garage or not. Because that decides what options are available
* @param Ticket This is where alot of the computeing goes on
* @param LostTicketCount Number of lost Tickets
* @param NumOfCheckIns How many people checked into the garage
* @param NumOfSpecialEvents Number of event Tickets
* @param TicketTotal Total amount of money paid for by tickets
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner keyboard = new Scanner(System.in);

        int choice = 0;
        boolean CarIn = false;
        Ticket ticket = new Ticket();
        int LostTicketCount = 0;
        int NumOfCheckIns = 0;
        int NumOfSpecialEvents = 0;
        double TicketTotal = 0;

        while (choice != 3){
            printMenu(CarIn);

            String s = keyboard.nextLine();

            try{
                choice = Integer.parseInt(s);
                switch (choice){
                    case 1:
                        if(CarIn){
                            ticket.checkOut();
                            ticket.Receipt();
                            TicketTotal = TicketTotal + ticket.calcTotal();
                            CarIn = false;
                        }else{
                            ticket.setTicketType(new NormalTicket());
                            ticket.checkIn();
                            NumOfCheckIns++;
                            CarIn = true;
                        }

                        break;
                    case 2:
                        //System.out.println("Lost Ticket");
                        Ticket.LostTicketReceipt();
                        LostTicketCount++;
                        CarIn =false;
                        break;
                    case 3:
                        //System.out.println("Close Garage");
                        System.out.println("Best Value Parking Garage");
                        System.out.println("==========================");
                        System.out.println("Activity To Date");
                        System.out.println("");
                        System.out.println("$" + TicketTotal + " was collected from " + NumOfCheckIns + " Tickets");
                        System.out.println("$" + (LostTicketCount*TicketType.LOST_TICKET_FEE)+ " from " + LostTicketCount + " Lost Ticket(s)");
                        System.out.println("$" + (NumOfSpecialEvents * TicketType.SPECIAL_EVENT) + " from " + NumOfSpecialEvents + " Special Event Ticket(s)");
                        break;
                    case 4:
                        NumOfSpecialEvents++;
                        ticket.setTicketType(new SpecialEvent());
                        ticket.Receipt();
                        break;
                }
            }catch(NumberFormatException e){
                System.out.println("Invalid Choice");
            }


        }
    }
/*
*Prints out the menu for the user
* @author Jessie
* @param CarIn If the car is checked in, this desides how the menu is displayed
 */
    private static void printMenu(boolean CarIn) {
        System.out.println();
        System.out.println("Best Value Parking Garage");
        System.out.println("==========================");
        System.out.println("1. Check/" + (CarIn?"Out":"In"));
        if(CarIn){
            System.out.println("2. Lost Ticket");
        }else {
            System.out.println("3. Close Garage");
            System.out.println("4. Special Event");
        }

        System.out.println("=>");
    }
}
