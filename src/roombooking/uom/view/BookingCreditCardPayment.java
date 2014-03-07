package roombooking.uom.view;

import roombooking.uom.model.booking.BookingOrder;
import roombooking.uom.strategy.payment.CreditCardPayment;

import java.util.Scanner;

/**
 * Created by Ruvin on 3/1/14.
 */
public class BookingCreditCardPayment {

    public void start(BookingOrder bookingOrder) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your Name: ");
        //((CreditCardPayment)bookingOrder.getPaymentStrategy()).setName(scanner.nextLine());
        ((CreditCardPayment)bookingOrder.getBooking().getPaymentStrategy()).setName(scanner.nextLine());//new
        System.out.println();

        System.out.print("Your Card No: ");
        //((CreditCardPayment)bookingOrder.getPaymentStrategy()).setCardNumber(scanner.nextLine());
        ((CreditCardPayment)bookingOrder.getBooking().getPaymentStrategy()).setCardNumber(scanner.nextLine());//new
        System.out.println();

        System.out.print("Your Card Verification Value: ");
        //((CreditCardPayment)bookingOrder.getPaymentStrategy()).setCVV(scanner.nextLine());
        ((CreditCardPayment)bookingOrder.getBooking().getPaymentStrategy()).setCVV(scanner.nextLine());//new
        System.out.println();


        System.out.print("Card Date Of Expiry: ");
        //((CreditCardPayment)bookingOrder.getPaymentStrategy()).setDateOfExpiry(scanner.nextLine());
        ((CreditCardPayment)bookingOrder.getBooking().getPaymentStrategy()).setDateOfExpiry(scanner.nextLine());
        System.out.println();

        System.out.println("Authorising Payment... ");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Authorising was made successfully! "); System.out.println();


    }

    public void paidByCreditCard(double amount){
        System.out.println(amount + " was withdrawn using credit/debit card");
    }
}
