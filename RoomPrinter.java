import java.util.ArrayList;

public class RoomPrinter {
	public static void printRoomsToScreen(ArrayList<Room> rooms) {
		for (Room room : rooms) {
			System.out.println(getExtendedRoomDescription(room));
		}
	}
	public static String getExtendedRoomDescription(Room room) {
		return String.format("%s\n%s", room, getConnectionString(room));
	}
	public static String getConnectionString(Room room) {
		String result = "";
		Room north = room.getNeighbor("N");
		Room south = room.getNeighbor("S");
		Room east = room.getNeighbor("E");
		Room west = room.getNeighbor("W");
		if (north == null) {
			result = result + "No neighbor on the North\n";
		} else {
			result = result + "Connected on the North to " + north.getName() + "\n";
		}
		if (south == null) {
			result = result + "No neighbor on the South\n";
		} else {
			result = result + "Connected on the South to " + south.getName() + "\n";
		}
		if (east == null) {
			result = result + "No neighbor on the East\n";
		} else {
			result = result + "Connected on the East to " + east.getName() + "\n";
		}
		if (west == null) {
			result = result + "No neighbor on the West\n";
		} else {
			result = result + "Connected on the West to " + west.getName() + "\n";
		}
		return result;
	}
}
