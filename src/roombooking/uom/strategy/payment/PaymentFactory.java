package roombooking.uom.strategy.payment;

import roombooking.uom.model.booking.Booking;
import roombooking.uom.model.booking.BookingManager;

import java.math.BigDecimal;

/**
 * Created by Ruvin on 3/1/14.
 */
public class PaymentFactory {
    private static PaymentFactory ourInstance = new PaymentFactory();

    public static PaymentFactory getInstance() {
        return ourInstance;
    }

    private PaymentFactory() {

    }

    public PaymentStrategy createPayment(PaymentMethod paymentMethod) {

        switch (paymentMethod) {
            case PAYPAl:
                return new PayPalPayment();
            case CREDITCARD:
                return new CreditCardPayment();
            default:
                return null;
        }
    }
}
