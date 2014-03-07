package roombooking.uom.view;

import roombooking.uom.model.booking.BookingOrder;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ruvin on 2/23/14.
 */
public class BookingRoomRequest {

    public void start(BookingOrder bookingOrder) {

        boolean correctInput = false;
        while (!correctInput)
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Booking Started");
            System.out.print("Choose prefer number of people: ");
            bookingOrder.setPreferNumOfPeople(scanner.nextInt()); System.out.println();

            System.out.print("Choose prefer date in format Day (1-30/31), Month (1-12), Year (2014, 2015): ");

            bookingOrder.setPreferStartDay(scanner.nextInt());
            bookingOrder.setPreferStartMonth(scanner.nextInt());
            bookingOrder.setPreferStartYear(scanner.nextInt());
            System.out.println();

            Calendar preferStartDate = new GregorianCalendar(bookingOrder.getPreferYear(), bookingOrder.getPreferMonth() - 1, bookingOrder.getPreferDay());

            Calendar todayDate = Calendar.getInstance();

            if (preferStartDate.before(todayDate)) {
                System.out.println("Impossible Date, try again!"); System.out.println();
                continue;
            }

            bookingOrder.setPreferStartDate(preferStartDate);

            Calendar preferEndDate = new GregorianCalendar(bookingOrder.getPreferStartDate().get(Calendar.YEAR), bookingOrder.getPreferStartDate().get(Calendar.MONTH), bookingOrder.getPreferStartDate().get(Calendar.DAY_OF_MONTH));

            System.out.print("Choose prefer number of nights: ");
            bookingOrder.setPreferNumOfNights(scanner.nextInt()); System.out.println();

            preferEndDate.add(Calendar.DATE, bookingOrder.getPreferNumOfNights() - 1);
            bookingOrder.setPreferEndDate(preferEndDate);
            correctInput = true;
        } catch (Exception e) {
            System.out.println("Wrong Input, try again!"); System.out.println();
        }


    }


}
