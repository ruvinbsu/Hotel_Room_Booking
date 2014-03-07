package roombooking.uom.view;

import roombooking.uom.model.booking.BookingOrder;
import roombooking.uom.model.room.Room;
import roombooking.uom.model.room.RoomManager;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ruvin on 2/23/14.
 */
public class BookingRoomSelection {

    public void start(BookingOrder bookingOrder) {
        int roomIndex = 0;
        RoomManager roomManager = RoomManager.getInstance();

        for (Room someRoom : roomManager.getUniqueSuitableRoomList()) {
            System.out.println((roomIndex + 1) + ") Room type: " + someRoom.getRoomType() + ", Room price: "
                    + someRoom.getRoomPrice() + ", Max number of people: " + someRoom.getNumOfPeople());
            roomIndex++;

        }

        if (roomIndex > 0){

        boolean correctInput = false;
        while (!correctInput)
            try {
                System.out.print("Chose the room: ");

                Scanner scanner = new Scanner(System.in);
                bookingOrder.setRoomOption(scanner.nextInt()); System.out.println();

                correctInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong Choice, try again!"); System.out.println();
            }
        }
        else System.out.println("No rooms available!");
    }

}
