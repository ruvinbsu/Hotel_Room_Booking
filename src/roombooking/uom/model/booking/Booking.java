package roombooking.uom.model.booking;

import roombooking.uom.model.room.Room;
import roombooking.uom.strategy.payment.PaymentStrategy;
import java.util.Calendar;

/**
 * Created by Ruvin on 2/23/14.
 */
public class Booking {

    //private int roomNumber;
    //private double roomPrice

    private Room room;
    private String cutomerID; //like passport ID
    private Calendar startDate;
    private int numOfNights;
    private Calendar endDate;
    public static int assignedID;
    private int bookingID;
    private double totalPrice;
    private PaymentStrategy paymentStrategy;//new

    public Booking(Room room, String cutomerID, Calendar startDate, int numOfNights) {

        this.setRoom(room);
        this.cutomerID = cutomerID;
        this.numOfNights = numOfNights;
        this.startDate = startDate;
    }

    public Booking(Room room, Calendar startDate, int numOfNights) {

        this.setRoom(room);
        this.numOfNights = numOfNights;
        this.startDate = startDate;
    }

    public double getTotalPrice() {
        return getRoomPrice()*getNumOfNights();
    }

    public void pay(PaymentStrategy paymentMethod) {

        double amount = getTotalPrice();
        paymentMethod.pay(amount);
    }

    public String getCutomerID() {
        return cutomerID;
    }

    public void setCutomerID(String cutomerID) {
        this.cutomerID = cutomerID;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public int getNumOfNights() {

        return numOfNights;
    }

    public void setNumOfNights(int numOfNights) {
        this.numOfNights = numOfNights;

    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public double getRoomPrice() {
        return getRoom().getRoomPrice();
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    //new
    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
