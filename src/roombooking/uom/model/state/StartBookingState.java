package roombooking.uom.model.state;

import roombooking.uom.model.booking.Booking;
import roombooking.uom.model.room.Room;
import roombooking.uom.model.room.RoomManager;
import roombooking.uom.view.BookingCommonMenu;
import roombooking.uom.view.BookingRoomRequest;
import roombooking.uom.view.BookingRoomSelection;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Ruvin on 2/24/14.
 */
public class StartBookingState implements BookingState {

    BookingCommonMenu bookingCommonMenu = new BookingCommonMenu();

    @Override
    public void doAction(BookingContext ctx) throws ParseException {

        //if Starting state wasn't created before
        if (ctx.getStartBookingState() == null) {
            RoomManager roomManager = RoomManager.getInstance();

            BookingRoomSelection bookingRoomSelection = new BookingRoomSelection();

            BookingRoomRequest bookingRoomRequest = new BookingRoomRequest();
            bookingRoomRequest.start(ctx.getBookingOrder());//start to ask parameters for the room

            roomManager.findUniqueSuitableRooms(ctx.getBookingOrder());//find all the unique types of rooms based on customer choice

            bookingRoomSelection.start(ctx.getBookingOrder());//select the concrete room
        } else if (ctx.getStartBookingState() != null) {
            bookingCommonMenu.roomSelectionSummary(ctx.getBookingOrder());//provide already inputted data
        }

        bookingCommonMenu.start();

        if (bookingCommonMenu.getCustomerChoice() == 1) {//go to next state
            ctx.setStartBookingState(this);

            if (ctx.getRegistrationForBookingState() != null)
                ctx.setState(ctx.getRegistrationForBookingState());
            else
                ctx.setState(new RegistrationForBookingState());

            RoomManager roomManager = RoomManager.getInstance();
            Room room = roomManager.getUniqueSuitableRoomList().get(ctx.getBookingOrder().getRoomOption() - 1);
            ctx.getBookingOrder().setBooking(new Booking(room, ctx.getBookingOrder().getPreferStartDate(), ctx.getBookingOrder().getPreferNumOfNights()));
            ctx.getBookingOrder().getBooking().setEndDate(ctx.getBookingOrder().getPreferEndDate());

        } else if (bookingCommonMenu.getCustomerChoice() < 4) {//repeat the state and make null all the previous fields
            ctx.getBookingOrder().setBooking(null);
            ctx.setStartBookingState(null);
            RoomManager roomManager = RoomManager.getInstance();
            roomManager.getUniqueSuitableRoomList().clear();//new!!!

            ctx.setState(new StartBookingState());//thing about what to provide if choice > 4
        } else {

            ctx.setState(new CancelBookingState());
        }
    }

}
