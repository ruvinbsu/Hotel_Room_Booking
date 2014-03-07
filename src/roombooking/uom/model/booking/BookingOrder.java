package roombooking.uom.model.booking;

import roombooking.uom.strategy.payment.PaymentMethod;
import roombooking.uom.strategy.payment.PaymentStrategy;

import java.util.Calendar;

/**
 * Created by Ruvin on 3/1/14.
 */
public class BookingOrder {

    private int preferNumOfPeople;
    private int preferDay;
    private int preferMonth;
    private int preferYear;
    private int preferNumOfNights;
    private Calendar preferStartDate;
    private Calendar preferEndDate;
    private int roomOption;


    //private PaymentStrategy paymentStrategy;

    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private String customerID;
    private PaymentMethod paymentMethod;
    private Booking booking;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getRoomOption() {
        return roomOption;
    }

    public void setRoomOption(int roomOption) {
        this.roomOption = roomOption;
    }

    public int getPreferNumOfPeople() {
        return preferNumOfPeople;
    }

    public void setPreferNumOfPeople(int preferNumOfPeople) {
        this.preferNumOfPeople = preferNumOfPeople;
    }

    public int getPreferDay() {
        return preferDay;
    }

    public void setPreferStartDay(int preferDay) {
        this.preferDay = preferDay;
    }

    public int getPreferMonth() {
        return preferMonth;
    }

    public void setPreferStartMonth(int preferMonth) {
        this.preferMonth = preferMonth;
    }

    public int getPreferYear() {
        return preferYear;
    }

    public void setPreferStartYear(int preferYear) {
        this.preferYear = preferYear;
    }

    public int getPreferNumOfNights() {
        return preferNumOfNights;
    }

    public void setPreferNumOfNights(int preferNumOfNights) {
        this.preferNumOfNights = preferNumOfNights;
    }

    public Calendar getPreferStartDate() {
        return preferStartDate;
    }

    public void setPreferStartDate(Calendar preferStartDate) {
        this.preferStartDate = preferStartDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /*public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }*/

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Calendar getPreferEndDate() {
        return preferEndDate;
    }

    public void setPreferEndDate(Calendar preferEndDate) {
        this.preferEndDate = preferEndDate;
    }
}
