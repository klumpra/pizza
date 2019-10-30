import java.util.ArrayList;

public class Mapper {
	/* takes a tab-delimited list of room names and assigns neighbors
	 * to rooms based on those names, with the neighbors string formmatted
	 * as specifying the names of the north, south, east, and west neighbors
	 */
	public static void assignNeighbors(Room room, ArrayList<Room> rooms, String neighbors) {
		String[] parts = neighbors.split("\t");
		room.assignNeighbor("N",RoomFinder.findByName(rooms,parts[0].trim()));
		room.assignNeighbor("S",RoomFinder.findByName(rooms,parts[1].trim()));
		room.assignNeighbor("E",RoomFinder.findByName(rooms,parts[2].trim()));
		room.assignNeighbor("W",RoomFinder.findByName(rooms,parts[3].trim()));
	}
}
