package roombooking.uom.model.room;

/**
 * Created by Ruvin on 2/23/14.
 */
public class RoomFactory {
    private static RoomFactory instance;

    private RoomFactory() {
    }

    public static RoomFactory getInstance() {
        if (instance == null) {
            synchronized (RoomFactory.class) {
                //Double check
                if (instance == null) {
                    instance = new RoomFactory();
                }
            }
        }
        return instance;
    }

    public Room createRoom(String[] room) { //Or getQuestion like in convension or build question

        Room someRoom = null;
        //System.out.println(room[0] + " " + room[1]);
        RoomParameter param = roomParam(room[1]);

        switch (param) {
            case SINGLE:
                someRoom = new SingleRoom();
                break;
            case CLASSIC_DOUBLE:
                someRoom = new DoubleRoom();
                break;
            case FAMILY_STUDIO:
                someRoom = new FamilyStudio();
                break;
            case DOUBLE_TWIN:
                someRoom = new DoubleTwin();
                break;
            case JUNIOR_SUITE:
                someRoom = new JuniorSuite();
                break;
            default:
                someRoom = new Apartment();
                //break;
        }

        someRoom.setRoomNumber(Integer.parseInt(room[0]));
        someRoom.setRoomType(room[1]);

        return someRoom;
    }

    private RoomParameter roomParam(String string) {
        if (string.equalsIgnoreCase("Single")) {
            return RoomParameter.SINGLE;
        }else if (string.equalsIgnoreCase("DOUBLE")) {
            return RoomParameter.CLASSIC_DOUBLE;
        }else if (string.equalsIgnoreCase("Twin")) {
            return RoomParameter.DOUBLE_TWIN;
        }else if (string.equalsIgnoreCase("JuniorSuite")){
            return RoomParameter.JUNIOR_SUITE;
        }else if (string.equalsIgnoreCase("FamilyStudio")){
            return RoomParameter.FAMILY_STUDIO;
        }else return RoomParameter.APARTMENT;
    }

    /*private boolean booleanHandler(String s) {
        if (s.equalsIgnoreCase("YES")) {
            return true;
        } else {
            return false;
        }
    }*/
}
