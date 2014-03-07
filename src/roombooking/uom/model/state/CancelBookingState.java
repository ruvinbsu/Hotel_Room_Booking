package roombooking.uom.model.state;

import roombooking.uom.view.BookingCommonMenu;

/**
 * Created by Ruvin on 2/24/14.
 */
public class CancelBookingState implements BookingState{
    @Override
    public void doAction(BookingContext ctx) {
        BookingCommonMenu bookingCommonMenu = new BookingCommonMenu();
        bookingCommonMenu.bookingCancelled();
    }
}
