package gamemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadData {

	public static Map<String, String[]> createGamesMap() {
		
		Map<String, String[]> allGames = new HashMap<>();
		File gamesFile = new File("Steam_Metadata_Full_marko_pakete.csv");
		
		String key;
		String[] currLine;
		
		try {
			
			Scanner gamesScanner = new Scanner(gamesFile);
			gamesScanner.nextLine();
			
			while(gamesScanner.hasNext()) {
				
				String[] values = new String[6];
				
				//Split according to a regular expression that will avoid commas that exist within double quotes.
				//https://www.baeldung.com/java-split-string-commas
				currLine = gamesScanner.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				
				//Name
				values[0] = currLine[0].replace("\"", "");
				//Steam ID
				values[1] = currLine[7].replace("\"", "");
				//Genre
				values[2] = currLine[10].replace("\"", "");
				//Developer
				values[3] = currLine[13].replace("\"", "");
				//Publisher
				values[4] = currLine[14].replace("\"", "");
				//Hours Played
				values[5] = currLine[17].replace("\"", "");
				
				key = currLine[0].replace("\"", "");
				allGames.put(key, values);	
			}
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
								
		
		return allGames;
		
	}
	
	public static void main(String[] args) {
	
		Map<String, String[]> gamesInfo = new HashMap<>();
		gamesInfo = createGamesMap();

		String[] game = gamesInfo.get("The Witcher: Enhanced Edition");
		
		for(int i = 0; i < game.length; i ++) {
			System.out.println(game[i]);
		}
		

	}

}
