package gamemanager;

import java.util.ArrayList;
import java.util.Scanner;

public class TextManager {
	static Scanner sc = new Scanner(System.in);
	static Account account;
	public static void main(String[] args) {
		account = new Account("Main");
		
		Game g1 = new Game("Hollow Knight", "Team Cherry", "Team Cherry");
		Game g2 = new Game("Stardew Valley", "ConcernedApe", "ConcernedApe");
		Game g3 = new Game("Hades", "Supergiant Games", "Supergiant Games");
		account.addToLibrary(g1);
		account.addToLibrary(g2);
		account.addToLibrary(g3);
		
		mainMenu(account);
	}
	
	private static void mainMenu(Account a) {
		boolean exit = false;
		int input;
		while(!exit) {
			System.out.printf("\nAccount: %s\n1. Edit library\n2. Edit Collections\n3. Exit\n", a.getUserName());
			System.out.printf("Choose an option: ");
			input = sc.nextInt();
			
			switch(input) {
			case 1:
				collectionMenu(a.getLibrary());
				break;
			case 2:
				editCollections(a);
				break;
			case 3:
				exit = true;
				break;
			default:
				System.out.println("Please enter a valid option");
				break;
			}
		}
	}
	private static void editCollections(Account a) {
		ArrayList<GameCollection> c = a.getCollections();
		boolean exit = false;
		int input;
		while(!exit) {
			System.out.println("\nWhat would you like to do?\n1. Add collection\n2. Edit a collection\n3. Remove collection\n4. Back");
			System.out.printf("Choose an option: ");
			input = sc.nextInt();
			System.out.println();
			
			switch(input) {
			case 1:
				System.out.println("New collection:");
				System.out.print("Collection name: ");
				String name = sc.next();
				int newLocation = c.size();
				a.addCollection(name);
				collectionMenu(c.get(newLocation));
				break;
			case 2:
				if(c.size() == 0) {
					System.out.println("No collections to edit");
					break;
				}
				System.out.println("Collections:");
				for(int i = 0; i<c.size(); i++) {
					System.out.printf("%d: %s\n", i+1, c.get(i).name);
				}
				System.out.print("\nWhich collection would you like to manage? ");
				int in = sc.nextInt() - 1;
				collectionMenu(c.get(in));
				break;
			case 3:
				System.out.println("Collections:");
				ArrayList<GameCollection> gc = a.getCollections();
				for(int i=0; i<gc.size();i++)
					System.out.printf("%d: %s\n", i+1, gc.get(i));
				System.out.print("Which would you like to remove? ");
				int in2 = sc.nextInt() - 1;
				a.removeCollection(in2);
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.print("Please enter a valid option");
				break;
			}
		}
	}
	private static void collectionMenu(GameCollection c) {
		boolean exit = false;
		int input;
		while(!exit) {
			System.out.printf("\nCollection: %s\n1. View games\n2. Add game\n3. Remove game\n4. Exit\n", c.getName());
			System.out.printf("Choose an option: ");
			input = sc.nextInt();
			
			switch(input) {
			case 1:
				System.out.println("Games: ");
				ArrayList<Game> games = c.getCollection();
				for(int i=0;i<games.size();i++)
					System.out.printf("%d: %s\n", i+1, games.get(i));
				break;
			case 2:
				if(c.getId() == 0) {
					System.out.println("New Game: ");
					System.out.print("Name: ");
					String name = sc.next();
					sc.nextLine();
					System.out.print("Developer: ");
					String dev = sc.next();
					sc.nextLine();
					System.out.print("Publisher: ");
					String pub = sc.next();
					sc.nextLine();
					Game game;
					c.addGame(game = new Game(name, dev, pub));
					gameMenu(game);
				} else {
					ArrayList<Game> library = account.getLibrary().getCollection();
					for(int i=0;i<library.size();i++)
						System.out.printf("%d: %s\n", i+1, library.get(i));
					System.out.print("What game would you like to add to this collection? ");
					int i = sc.nextInt();
					c.addGame(library.get(i-1));
				}
				break;
			case 3:
				System.out.println("Games: ");
				games = c.getCollection();
				for(int i=0;i<games.size();i++)
					System.out.printf("%d: %s\n", i+1, games.get(i));
				System.out.print("Which would you like to remove? ");
				int in = sc.nextInt() - 1;
				if(c.getId() == 0) {
					for(GameCollection gc : account.getCollections()) {
						gc.removeGame(games.get(in));
					}
				}
				c.removeGame(in);
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.println("Please enter a valid option");
				break;
			}
		}
	}
	private static void gameMenu(Game g) {
		
	}
}
