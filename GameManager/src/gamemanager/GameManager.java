package gamemanager;

import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class GameManager {

	public static void createGamesMap() {
		
		Map<String, String[]> allGames = new HashMap<>();
		File gamesFile = new File("Steam_Metadata_Full_marko_pakete.csv");
		
		String[] currLine;
		
		try {
			
			Scanner gamesScanner = new Scanner(gamesFile);
			gamesScanner.nextLine();
			
			while(gamesScanner.hasNext()) {

				currLine = gamesScanner.nextLine().split(",");
				System.out.println(currLine[0]);
				allGames.put(currLine[0], currLine);
			
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				
	}
	
	public static void main(String[] args) {
		
		createGamesMap();
		
	}

}
