package roombooking.uom.model.state;

import roombooking.uom.view.*;

import java.text.ParseException;

/**
 * Created by Ruvin on 2/24/14.
 */
public interface BookingState {

    public void doAction(BookingContext ctx) throws ParseException;

}
