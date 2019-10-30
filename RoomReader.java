import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Reads a file that has this tab-delimited format
 * name	description	north_room	south_room	east_room	west_room
 * It builds an interconnection of rooms from this.
 */
public class RoomReader {
	public static ArrayList<Room> readRoomsFile(String fname) {
		File f = new File(fname);
		return readRoomsFile(f);
	}
	public static ArrayList<Room> readRoomsFile(File f) {
		try {
			Scanner fsc = new Scanner(f);
			String line;
			Room room;
			String name, desc;
			String[] parts;
			ArrayList<String> restOfLines = new ArrayList<String>();
			ArrayList<Room> rooms = new ArrayList<Room>();
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				if (line.trim().length() > 0) {
					parts = line.split("\t");
					room = new Room(parts[0],parts[1]);
					restOfLines.add(parts[2] + "\t" + parts[3] + "\t" + parts[4] + "\t" + parts[5]);
					rooms.add(room);
				}
			}
			for (int i = 0; i < rooms.size(); i++) {
				Mapper.assignNeighbors(rooms.get(i), rooms, restOfLines.get(i));
			}
			return rooms;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
