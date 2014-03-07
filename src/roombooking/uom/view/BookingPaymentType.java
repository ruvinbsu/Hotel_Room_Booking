package roombooking.uom.view;

import roombooking.uom.model.booking.BookingOrder;
import roombooking.uom.strategy.payment.PaymentMethod;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ruvin on 2/23/14.
 */
public class BookingPaymentType {

    public void start(BookingOrder bookingOrder) {
        boolean correctInput = false;
        while (!correctInput)
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Booking Payment");

                System.out.println("Amount to pay to the hotel: " + bookingOrder.getBooking().getTotalPrice()); System.out.println();

                System.out.println("Please choose payment method:");
                System.out.println("1. PayPal Payment");
                System.out.println("2. CreditCard Payment"); System.out.println();
                System.out.print("Payment method: ");

                int paymentType = scanner.nextInt(); System.out.println();

                if (paymentType > 2) {
                    System.out.println("Wrong Choice, try again!"); System.out.println();
                    continue;
                }

                bookingOrder.setPaymentMethod(PaymentMethod.values()[paymentType - 1]);
                correctInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong Input, try again!"); System.out.println();
            }
    }

}
