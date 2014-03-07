package csv.handling;


import roombooking.uom.model.booking.Booking;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Ruvin on 2/23/14.
 */
public class GenerateBookingCSV{
    public void generate(String fileName, List<Booking> bookingList) {
        try {
            FileWriter writer = new FileWriter(fileName);

            //to save list of booking in appropriate order
            for (Booking booking : bookingList) {
                writer.append("" + booking.getRoom().getRoomNumber());
                writer.append(',');
                writer.append(booking.getCutomerID());
                writer.append(',');

                //Transferring from Calendar to single String in order to save in CSV
                int day = booking.getStartDate().get(Calendar.DAY_OF_MONTH); //compare with Calendar.DATE
                int month = booking.getStartDate().get(Calendar.MONTH) + 1;
                int year = booking.getStartDate().get(Calendar.YEAR);
                String date = "" + day + "/" + month + "/" + year;

                writer.append(date);
                writer.append(',');//comma separator for CSV
                writer.append("" + booking.getNumOfNights());
                writer.append(',');
                //writer.append("" + booking.getRoomPrice());
                writer.append("" + booking.getTotalPrice());
                writer.append(',');
                writer.append("" + booking.getBookingID());
                writer.append('\n');
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
