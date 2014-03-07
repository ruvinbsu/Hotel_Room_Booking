package roombooking.uom.strategy.payment;

import roombooking.uom.view.BookingPayPalPayment;

/**
 * Created by Ruvin on 2/23/14.
 */
public class PayPalPayment implements PaymentStrategy {

    private String emailId;
    private String password;

    public PayPalPayment() {

    }

    @Override
    public void pay(double amount) {

        amount = amount + amount*0.01;
        BookingPayPalPayment bookingPayPalPayment = new BookingPayPalPayment();
        bookingPayPalPayment.paidByPayPal(amount);
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
