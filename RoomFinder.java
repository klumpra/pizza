import java.util.ArrayList;

public class RoomFinder {
	public static Room findByName(ArrayList<Room> rooms, String name) {
		for (Room room : rooms) {
			if (room.getName().equalsIgnoreCase(name)) {
				return room;
			}
		}
		return null;
	}
}
