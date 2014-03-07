package roombooking.uom.strategy.payment;

import roombooking.uom.view.BookingCreditCardPayment;

/**
 * Created by Ruvin on 2/23/14.
 */
public class CreditCardPayment implements PaymentStrategy{

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;


    public CreditCardPayment() {

    }

    @Override
    public void pay(double amount) {

        amount = amount + amount*0.02;
        BookingCreditCardPayment bookingCreditCardPayment = new BookingCreditCardPayment();
        bookingCreditCardPayment.paidByCreditCard(amount);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCVV(String cvv) {
        this.cvv = cvv;
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }
}