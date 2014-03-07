package roombooking.uom.view;

import roombooking.uom.model.booking.BookingOrder;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ruvin on 2/23/14.
 */
public class BookingRegistration {

    public void start(BookingOrder bookingOrder) {

        boolean correctInput = false;
        while (!correctInput)
            try {
                System.out.println("Customer Registration");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Your Name: ");
                bookingOrder.setCustomerName(scanner.nextLine()); System.out.println();

//        System.out.print("Your Surname: ");
//        bookingOrder.setCustomerName(scanner.nextLine());

                System.out.print("Your Passport No: ");
                bookingOrder.setCustomerID(scanner.nextLine()); System.out.println();

//        System.out.print("Your Email: ");
//        bookingOrder.setCustomerName(scanner.nextLine());
                correctInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong Input, try again!"); System.out.println();
            }

    }
}