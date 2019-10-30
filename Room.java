import java.util.LinkedHashMap;

public class Room {
	private LinkedHashMap<String,Room> neighbors;
	private String name;
	private String description;
	public LinkedHashMap<String,Room> getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(LinkedHashMap<String,Room> neighbors) {
		this.neighbors = neighbors;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return String.format("%s: %s", name,description);
	}
	public void initializeNeighbors() {
		neighbors = new LinkedHashMap<String,Room>();
		neighbors.put("N",null);
		neighbors.put("S", null);
		neighbors.put("E", null);
		neighbors.put("W", null);
	}
	public Room() {
		initializeNeighbors();
		name = "Name";
		description = "Description";
	}
	public Room(String name, String description) {
		this();
		setName(name);
		setDescription(description);
	}
	public void assignNeighbor(String dir, Room rm) {
		neighbors.put(dir, rm);
	}
	public Room getNeighbor(String dir) {
		return neighbors.get(dir);
	}
	@Override
	public boolean equals(Object other) {
		Room otherRoom = (Room)other;
		return (otherRoom.getName().equalsIgnoreCase(name));
	}
}
