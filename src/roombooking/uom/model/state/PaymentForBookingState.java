package roombooking.uom.model.state;

import roombooking.uom.model.booking.Booking;
import roombooking.uom.model.booking.BookingManager;
import roombooking.uom.strategy.payment.*;
import roombooking.uom.view.BookingCommonMenu;
import roombooking.uom.view.BookingCreditCardPayment;
import roombooking.uom.view.BookingPayPalPayment;
import roombooking.uom.view.BookingPaymentType;

/**
 * Created by Ruvin on 2/24/14.
 */
public class PaymentForBookingState implements BookingState {
    @Override
    public void doAction(BookingContext ctx) {

        BookingPaymentType bookingPaymentType = new BookingPaymentType();
        bookingPaymentType.start(ctx.getBookingOrder());

        PaymentFactory paymentFactory = PaymentFactory.getInstance();

        PaymentMethod paymentMethod = ctx.getBookingOrder().getPaymentMethod();

        /*ctx.getBookingOrder().setPaymentStrategy(paymentFactory.createPayment(paymentMethod));

        if (ctx.getBookingOrder().getPaymentStrategy() instanceof CreditCardPayment){
            BookingCreditCardPayment bookingCreditCardPayment = new BookingCreditCardPayment();
            bookingCreditCardPayment.start(ctx.getBookingOrder());
        }
        else{
            BookingPayPalPayment bookingPayPalPayment = new BookingPayPalPayment();
            bookingPayPalPayment.start(ctx.getBookingOrder());
        }

        ctx.getBookingOrder().getBooking().pay(ctx.getBookingOrder().getPaymentStrategy());*/

        //new
        ctx.getBookingOrder().getBooking().setPaymentStrategy(paymentFactory.createPayment(paymentMethod));

        if (ctx.getBookingOrder().getBooking().getPaymentStrategy() instanceof CreditCardPayment){
            BookingCreditCardPayment bookingCreditCardPayment = new BookingCreditCardPayment();
            bookingCreditCardPayment.start(ctx.getBookingOrder());
        }
        else{
            BookingPayPalPayment bookingPayPalPayment = new BookingPayPalPayment();
            bookingPayPalPayment.start(ctx.getBookingOrder());
        }

        ctx.getBookingOrder().getBooking().pay(ctx.getBookingOrder().getBooking().getPaymentStrategy());


        ctx.setState(new FinishedBookingState());//go to finish


    }
}
