package roombooking.uom.model.booking;

import csv.handling.GenerateBookingCSV;
import csv.handling.ReadFromCSV;
import roombooking.uom.model.room.Room;
import roombooking.uom.model.room.RoomManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Ruvin on 2/24/14.
 */
public class BookingManager {
    private List<Booking> bookingList = new ArrayList<Booking>();

    private static BookingManager ourInstance = new BookingManager();

    public static BookingManager getInstance() {
        return ourInstance;
    }

    private BookingManager() {
    }

    /**
     * When all the data was taken from csv, put it in memory/list
     */
    public void InitializeBookings() {
        ReadFromCSV readCSV = new ReadFromCSV();
        RoomManager roomManager = RoomManager.getInstance();
        String csvFile = "Booking.csv";
        List<String> bookingStringList = readCSV.returnSuitableList(csvFile);

        for (String line : bookingStringList) {
            String[] bookingString = line.split(","); // use comma as separator

            Integer roomNumber = Integer.parseInt(bookingString[0]);//make int

            Room room = roomManager.findRoom(roomNumber);

            String customerID = bookingString[1];
            String[] startDateString = bookingString[2].split("/");
            int day = Integer.parseInt(startDateString[0]);
            int month = Integer.parseInt(startDateString[1]) - 1;
            int year = Integer.parseInt(startDateString[2]);
            Calendar startDate = new GregorianCalendar(year, month, day);

            Integer numOfNights = Integer.parseInt(bookingString[3]);
            int bookingID = Integer.parseInt(bookingString[5]);

            Booking booking = new Booking(room, customerID, startDate, numOfNights);
            booking.setBookingID(bookingID);
            //System.out.println("1st " + startDate.get(Calendar.DAY_OF_MONTH));
            Calendar endDate = new GregorianCalendar(year, month, day);

            endDate.add(Calendar.DATE, numOfNights - 1);  // number of days to add. Think about last day -1!!!
            booking.setEndDate(endDate);

            //System.out.println("2nd " + startDate.get(Calendar.DAY_OF_MONTH));
            //System.out.println(booking.getNumOfNights());
            room.addBooking(booking); //from view
            getBookingList().add(booking);

            //roomList.add(factory.createRoom(room)); //http://howtodoinjava.com/2012/10/23/implementing-factory-design-pattern-in-java/
        }

    }

    /**
     * Add new booking to the booking list
     * @param booking
     */
    public void addNewBooking(Booking booking) {

        bookingList.add(booking);
    }

    /**
     * save all bookings back to csv
     */
    public void saveBookings() {
        GenerateBookingCSV csv = new GenerateBookingCSV();
        csv.generate("Booking.csv", bookingList);//or better use getter for this case

    }

    public List<Booking> getBookingList() {
        return bookingList;
    }
}