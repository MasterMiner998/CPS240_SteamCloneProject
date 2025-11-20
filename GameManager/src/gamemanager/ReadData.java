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
		String[] values = new String[7];
		String[] currLine;
		
		try {
			
			Scanner gamesScanner = new Scanner(gamesFile);
			gamesScanner.nextLine();
			
			while(gamesScanner.hasNext()) {
				
				currLine = gamesScanner.nextLine().split(",");
				
				//Name
				values[0] = currLine[0].replace("\"", "");
				//Steam ID
				values[1] = currLine[7].replace("\"", "");
				//Genre
				values[3] = currLine[9].replace("\"", "");
				//Developer
				values[4] = currLine[12].replace("\"", "");
				//Publisher
				values[5] = currLine[13].replace("\"", "");
				//Hours Played
				values[6] = currLine[14].replace("\"", "");
				
				for(int i = 0; i < currLine.length; i ++) {
					System.out.print(i + " " + currLine[i] + " ");
				}				
				System.out.println();
				
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

		String[] game = gamesInfo.get("Grand Theft Auto V");
		System.out.print(game[0]);

	}

}
