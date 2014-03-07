package roombooking.uom.view;

import roombooking.uom.model.booking.BookingOrder;
import roombooking.uom.strategy.payment.CreditCardPayment;
import roombooking.uom.strategy.payment.PayPalPayment;

import java.util.Scanner;

/**
 * Created by Ruvin on 3/1/14.
 */
public class BookingPayPalPayment {

    public void start(BookingOrder bookingOrder) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your E-mail Address: ");
        //((PayPalPayment)bookingOrder.getPaymentStrategy()).setEmailId(scanner.nextLine());
        ((PayPalPayment)bookingOrder.getBooking().getPaymentStrategy()).setEmailId(scanner.nextLine());
        System.out.println();

        System.out.print("Your PayPal Account Password: ");
        //((PayPalPayment)bookingOrder.getPaymentStrategy()).setPassword(scanner.nextLine());
        ((PayPalPayment)bookingOrder.getBooking().getPaymentStrategy()).setPassword(scanner.nextLine());
        System.out.println();

        System.out.println("Connecting to PayPal Server... ");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("Connection was made successfully! "); System.out.println();

    }

    public void paidByPayPal(double amount){
        System.out.println(amount + " was withdrawn using PayPal.");

    }

}
