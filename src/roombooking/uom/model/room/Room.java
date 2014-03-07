package roombooking.uom.model.room;

import roombooking.uom.model.booking.Booking;
import roombooking.uom.model.booking.BookingManager;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Ruvin on 2/23/14.
 */
public abstract class Room {

    //protected boolean hasBalcony;
    //protected boolean hasKitchen;
    //protected int roomFloor;
    //protected int numOfRooms;
    //protected boolean breakfast;
    //protected boolean hasWindow;
    private int numOfBeds;
    protected int roomNumber;
    protected double roomPrice;
    protected int numOfPeople;
    protected String roomType;
    protected List<Booking> bookingList = new ArrayList<Booking>();

    public Room(double roomPrice, int numOfPeople) {
        setRoomPrice(roomPrice);
        setNumOfPeople(numOfPeople);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isRoomSuitable(int preferNumOfPeople) {//think about price
        if (numOfPeople >= preferNumOfPeople) {
            return true;
        }
        return false;

    }

    public boolean isRoomAvailable(Calendar preferStartDate, Calendar preferEndDate) throws ParseException {

        for (Booking booking : getBookingList()) {
            //System.out.println(" prST " +preferStartDate.get(Calendar.DAY_OF_MONTH) + " " + preferStartDate.get(Calendar.MONTH) + " " + preferStartDate.get(Calendar.YEAR));
            //System.out.println(" prEnd " +preferEndDate.get(Calendar.DAY_OF_MONTH) + " " + preferEndDate.get(Calendar.MONTH) + " " + preferEndDate.get(Calendar.YEAR));
            //System.out.println(booking.getRoom().getRoomNumber() + " st " + booking.getStartDate().get(Calendar.DAY_OF_MONTH) + " " + booking.getStartDate().get(Calendar.MONTH) + " " + booking.getStartDate().get(Calendar.YEAR));
            //System.out.println(booking.getRoom().getRoomNumber() + " en " + booking.getEndDate().get(Calendar.DAY_OF_MONTH) + " " + booking.getEndDate().get(Calendar.MONTH) + " " + booking.getEndDate().get(Calendar.YEAR));

            if (preferEndDate.before(booking.getStartDate()) || preferStartDate.after(booking.getEndDate())) {
            } else {
                return false;
            }
        }

        return true;

    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void addBooking(Booking booking){
        this.bookingList.add(booking);
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public void setNumOfBeds(int numOfBeds) {
        this.numOfBeds = numOfBeds;
    }
}
