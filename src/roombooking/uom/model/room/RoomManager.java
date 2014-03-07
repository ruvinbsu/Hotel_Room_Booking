package roombooking.uom.model.room;

import csv.handling.ReadFromCSV;
import roombooking.uom.model.booking.BookingOrder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ruvin on 2/24/14.
 */
public class RoomManager {

    private List<Room> roomList = new ArrayList<Room>();
    Map<Integer, Room> manager = new HashMap<Integer, Room>();
    private List<Room> uniqueSuitableRoomList = new ArrayList<Room>();

    private static RoomManager instance;

    private RoomManager() {
    }

    public static RoomManager getInstance() {
        if (instance == null) {
            synchronized (RoomManager.class) {
                //Double check
                if (instance == null) {
                    instance = new RoomManager();
                }
            }
        }
        return instance;
    }

    public void associateRoomWithNumber(Integer roomNumber, Room room) {
        manager.put(roomNumber, room);
    }

    public Room findRoom(int roomNumber) {
        return manager.get(roomNumber);
    }

    public void initializeRooms() {
        ///////////////////////////////Getting list of rooms from Room.CSV
        RoomFactory factory = RoomFactory.getInstance();
        ReadFromCSV readCSV = new ReadFromCSV(); //change the name of the class and make it singleton
        String csvFile = "Room.csv";
        List<String> roomStringList = readCSV.returnSuitableList(csvFile); //every line from csv of rooms in form of string

        for (String line : roomStringList) {
            String[] roomString = line.split(","); // use comma as separator ?IS IT OK TO PUT THIS STUFF HERE?
            Room room = factory.createRoom(roomString);
            associateRoomWithNumber(room.getRoomNumber(), room);
            roomList.add(room); //http://howtodoinjava.com/2012/10/23/implementing-factory-design-pattern-in-java/
        }

    }

    public void findUniqueSuitableRooms(BookingOrder bookingOrder) throws ParseException {

        List<Room> suitableRoomList = new ArrayList<Room>();

        for (Room room : roomList) {
            if (room.isRoomSuitable(bookingOrder.getPreferNumOfPeople()) && room.isRoomAvailable(bookingOrder.getPreferStartDate(), bookingOrder.getPreferEndDate())) {
                suitableRoomList.add(room);
                //System.out.println(ii++);
            }
        }

        ///////////////////////////////Finding all distinct rooms which are suitable for customer's parameters.

        for (int i = 0; i < suitableRoomList.size() - 1; i++) {
            boolean distinctRoom = true;
            Room room1 = suitableRoomList.get(i);
            for (int j = i + 1; j < suitableRoomList.size(); j++) {
                Room room2 = suitableRoomList.get(j);
                if (room1.getRoomType().equals(room2.getRoomType())) {
                    distinctRoom = false;
                    break;
                }
            }
            if (distinctRoom) {
                uniqueSuitableRoomList.add(room1);
            }

        }
        if (suitableRoomList.size() > 0)
            uniqueSuitableRoomList.add(suitableRoomList.get(suitableRoomList.size() - 1));
    }


    public List<Room> getRoomList() {
        return roomList;
    }

    public List<Room> getUniqueSuitableRoomList() {
        return uniqueSuitableRoomList;
    }

}