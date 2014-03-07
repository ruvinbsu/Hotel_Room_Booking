package roombooking.uom.model.state;

import roombooking.uom.model.booking.BookingManager;
import roombooking.uom.view.BookingCommonMenu;

/**
 * Created by Ruvin on 2/24/14.
 */
public class FinishedBookingState implements BookingState{

    @Override
    public void doAction(BookingContext ctx) {

        BookingCommonMenu bookingCommonMenu = new BookingCommonMenu();
        bookingCommonMenu.bookingFinished();

        BookingManager bookingManager = BookingManager.getInstance();

        if (bookingManager.getBookingList().size() > 0)
            ctx.getBookingOrder().getBooking().setBookingID(bookingManager.getBookingList().get(bookingManager.getBookingList().size() - 1).getBookingID() + 1);
        else
            ctx.getBookingOrder().getBooking().setBookingID(1);

        ctx.getBookingOrder().getBooking().getRoom().addBooking(ctx.getBookingOrder().getBooking());

        bookingManager.addNewBooking(ctx.getBookingOrder().getBooking());

        bookingManager.saveBookings();
    }
}
