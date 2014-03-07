package roombooking.uom.view;

import roombooking.uom.model.booking.BookingOrder;
import roombooking.uom.model.state.BookingContext;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ruvin on 2/28/14.
 */
public class BookingCommonMenu {

    private int customerMenuChoice;

    public void start() {

        boolean correctInput = false;
        while (!correctInput)
            try {
                System.out.print("Please choose your next action 1) Continue 2) Back 3) Refill details 4) Cancel: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt(); System.out.println();

                if (choice > 4) {
                    System.out.println("Wrong Choice, try again!");
                    System.out.println();

                    continue;
                }
                setCustomerChoice(choice);
                correctInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong Input, try again!");
                System.out.println();

            }
    }

    public void registrationSummary(BookingOrder bookingOrder) {
        System.out.println("Your Registration Details: ");
        System.out.println("Full Name: " + bookingOrder.getCustomerName());
        System.out.println("Passport ID: " + bookingOrder.getCustomerID());
        System.out.println();
    }

    public void roomSelectionSummary(BookingOrder bookingOrder) {
        System.out.println("Your Room Selected Details: ");
        System.out.println("Selected Number Of People: " + bookingOrder.getPreferNumOfPeople());
        System.out.println("Selected Start Date: " + bookingOrder.getPreferDay() + " " + bookingOrder.getPreferMonth() + " " + bookingOrder.getPreferYear());
        System.out.println("Selected Number Of Nights: " + bookingOrder.getPreferNumOfNights());
        System.out.println("Selected Room Type: " + bookingOrder.getBooking().getRoom().getRoomType());
        System.out.println();
    }

    public void bookingCancelled() {
        System.out.println("Booking Cancelled");
    }

    public  void  bookingFinished(){
        System.out.println("Booking Finished");
    }

    public int getCustomerChoice() {
        return customerMenuChoice;
    }

    public void setCustomerChoice(int customerChoice) {
        this.customerMenuChoice = customerChoice;
    }
}
