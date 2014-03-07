package roombooking.uom.model.state;

import roombooking.uom.model.booking.Booking;
import roombooking.uom.model.booking.BookingManager;
import roombooking.uom.model.room.Room;
import roombooking.uom.model.room.RoomManager;
import roombooking.uom.view.BookingCommonMenu;
import roombooking.uom.view.BookingRegistration;

/**
 * Created by Ruvin on 2/24/14.
 */
public class RegistrationForBookingState implements BookingState {

    BookingCommonMenu bookingCommonMenu = new BookingCommonMenu();

    @Override
    public void doAction(BookingContext ctx) {
        if (ctx.getRegistrationForBookingState() == null) {

            BookingRegistration bookingRegistration = new BookingRegistration();

            bookingRegistration.start(ctx.getBookingOrder());

            ctx.getBookingOrder().getBooking().setCutomerID(ctx.getBookingOrder().getCustomerID());

        } else if (ctx.getStartBookingState() != null) {
            ctx.getBookingOrder().getBooking().setCutomerID(ctx.getBookingOrder().getCustomerID());

            bookingCommonMenu.registrationSummary(ctx.getBookingOrder());//provide already inputted data
        }

        bookingCommonMenu.start();

        if (bookingCommonMenu.getCustomerChoice() == 1) {//go to payment state
            ctx.setRegistrationForBookingState(this);
            ctx.setState(new PaymentForBookingState());
        } else if (bookingCommonMenu.getCustomerChoice() == 2) {//repeat the state

            ctx.setRegistrationForBookingState(this);

            ctx.setState(ctx.getStartBookingState());//thing about what to provide if choice > 4

        } else if (bookingCommonMenu.getCustomerChoice() == 3) {
            ctx.setRegistrationForBookingState(null);
            ctx.setState(new RegistrationForBookingState());

        } else ctx.setState(new CancelBookingState());

    }
}