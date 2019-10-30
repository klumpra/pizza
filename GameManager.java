import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class GameManager {
	private ArrayList<Room> rooms;
	private Room pizzaLocation;
	private Room bearLocation;
	private Random rnd;
	public GameManager(ArrayList<Room> rooms) {
		this.rooms = rooms;
		rnd = new Random();
		pizzaLocation = null;
		bearLocation = null;
	}
	public void placePizzaRandomly() {
		int roomIndex = rnd.nextInt(rooms.size());
		pizzaLocation = rooms.get(roomIndex);
	}
	public void placeBearRandomly() {
		int roomIndex = rnd.nextInt(rooms.size());
		bearLocation = rooms.get(roomIndex);
	}
	public void playGame() {
		placePizzaRandomly();
		placeBearRandomly();
		String dir;
		Scanner sc = new Scanner(System.in);
		int moves = 0;
		Room neighbor;
		while (bearLocation == pizzaLocation) {
			placeBearRandomly();
		}
		do {
			System.out.println("You are in the " + bearLocation + ".");
			System.out.print("Enter N, S, E, or W to move: ");
			dir = sc.nextLine().trim();
			neighbor = bearLocation.getNeighbor(dir);
			moves = moves + 1;
			if (neighbor == null) {
				System.out.println("You can't move in that direction.");
			} else {
				bearLocation = neighbor;
			}
		} while (!(bearLocation == pizzaLocation));
		System.out.println("Eat up, bear! You've found the pizza in " + pizzaLocation + ".");
		System.out.println("That took you " + moves + " moves.");
	}
}
