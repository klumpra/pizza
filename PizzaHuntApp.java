import java.util.ArrayList;
import java.util.Scanner;
public class PizzaHuntApp {
	public static void printStars(int howMany) {
		String stars = "";
		for (int i = 0; i < howMany; i++) {
			stars = stars + "*";
		}
		System.out.println(stars);
	}
	public static void welcome() {
		printStars(50);
		System.out.println("Pizza Hunt");
		System.out.println("You are a bear. Do what bears do. Hunt pizza.");
		printStars(50);
		System.out.println();
	}
	public static void showMenu() {
		System.out.println("Here are your choices: ");
		System.out.println("1. Hunt for pizza.");
		System.out.println("2. Print the maze.");
		System.out.println("3. Hibernate");
		System.out.print("Please enter the number of your choice: ");
	}
	public static void main(String[] args) {
		welcome();
		String fname;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name of file: ");
		fname = sc.nextLine();
		ArrayList<Room> rooms = RoomReader.readRoomsFile(fname);
		int choice;
		GameManager gm = new GameManager(rooms);
		if (rooms != null ) {
			do {
				showMenu();
				choice = sc.nextInt();
				if (choice == 1) {
					gm.playGame();
				} else if (choice == 2) {
					RoomPrinter.printRoomsToScreen(rooms);
				}
			} while (choice != 3);
			System.out.println("We hope you had fun!");
		} else {
			System.out.println("The rooms could not be read.");
		}
	}
}
