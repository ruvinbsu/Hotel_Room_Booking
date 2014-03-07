package StartPoint;

import roombooking.uom.model.booking.BookingManager;
import roombooking.uom.model.room.RoomManager;
import roombooking.uom.model.state.BookingContext;
import roombooking.uom.model.state.CancelBookingState;
import roombooking.uom.model.state.FinishedBookingState;
import roombooking.uom.model.state.StartBookingState;

import java.text.ParseException;

/**
 * Created by Ruvin on 2/23/14.
 */
public class RoomBookingApplication {

    //public static List<Customer> customerList = new ArrayList<Customer>();

    public static void main(String[] args) throws ParseException {
        ///////////////////////////////Finding the rooms which are suitable for customer's parameters. Or timetabling algo...?

        ///////////////////////////////Retrieve all the bookings from Booking.csv

        BookingContext ctx = new BookingContext(new StartBookingState());

        RoomManager roomManager = RoomManager.getInstance();
        roomManager.initializeRooms();

        BookingManager bookingManager = BookingManager.getInstance();
        bookingManager.InitializeBookings();

        boolean isFinish = false;
        while (!isFinish) {
            if (ctx.getState() instanceof FinishedBookingState || ctx.getState() instanceof CancelBookingState)
                isFinish = true;
            ctx.doAction();
        }

    }


}
