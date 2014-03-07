package roombooking.uom.model.state;

import roombooking.uom.model.booking.Booking;
import roombooking.uom.model.booking.BookingOrder;
import roombooking.uom.view.*;

import java.text.ParseException;

/**
 * Created by Ruvin on 2/24/14.
 */
public class BookingContext {
    private BookingState state;
    private BookingOrder bookingOrder;
    private StartBookingState startBookingState;
    private RegistrationForBookingState registrationForBookingState;

    public BookingOrder getBookingOrder() {
        return bookingOrder;
    }

    public void setBookingOrder(BookingOrder bookingOrder) {
        this.bookingOrder = bookingOrder;
    }

    private StartBookingState start;

    public StartBookingState getStart() {
        return start;
    }

    public void setStart(StartBookingState start) {
        this.start = start;
    }

    public BookingContext(BookingState state){
        this.setState(state);
        bookingOrder = new BookingOrder();
    }

    /**
     * to
     * @throws ParseException
     */
    public void doAction() throws ParseException {
        state.doAction(this);
    }

    public BookingState getState() {
        return state;
    }

    public void setState(BookingState state) {
        this.state = state;
    }

    public StartBookingState getStartBookingState() {
        return startBookingState;
    }

    public void setStartBookingState(StartBookingState startBookingState) {
        this.startBookingState = startBookingState;
    }

    public RegistrationForBookingState getRegistrationForBookingState() {
        return registrationForBookingState;
    }

    public void setRegistrationForBookingState(RegistrationForBookingState registrationForBookingState) {
        this.registrationForBookingState = registrationForBookingState;
    }

}
