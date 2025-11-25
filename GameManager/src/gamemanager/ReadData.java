package gamemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadData {

	public static Map<String, String[]> createGamesInfoMap() {
		
		Map<String, String[]> allGames = new HashMap<>();
		File gamesFile = new File("Steam_Metadata_Full_marko_pakete.csv");
		
		String key;
		String[] currLine;
		
		try {
			
			Scanner gamesScanner = new Scanner(gamesFile);
			gamesScanner.nextLine();
			
			while(gamesScanner.hasNext()) {
				
				String[] values = new String[8];
				
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
				//Release Date
				values[6] = currLine[18].replace("\"", "");
				//Rating
				values[7] = currLine[22].replace("\"", "");
						
				key = currLine[0].replace("\"", "");
				allGames.put(key, values);	
			}
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
									
		return allGames;
		
	}
	
	public static Map<String, Game> createGamesMap() {
		
		Map<String, String[]> gamesInfo = new HashMap<>();
		gamesInfo = createGamesInfoMap();
		
		Map<String, Game> allGames = new HashMap<>();
		
		for(String key: gamesInfo.keySet()) {
			
			String[] gameData = gamesInfo.get(key); 
			
			String gameName = gameData[0];
			int gameID = Integer.parseInt(gameData[1]);
			
			
			
			
			
		}
		
		
		
		return null;
		
	}
	
	public static void main(String[] args) {
	
		Map<String, String[]> gamesInfo = new HashMap<>();
		gamesInfo = createGamesInfoMap();

		String[] game = gamesInfo.get("Darksiders II Deathinitive Edition");
		
		for(int i = 0; i < game.length; i ++) {
			System.out.println(game[i]);
		}
		

	}

}
