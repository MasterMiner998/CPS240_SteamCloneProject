package gamemanager;

import java.util.Map;

import javafx.application.Application;

public class Start {

	public static void main(String[] args) {
		Account account = new Account("Main");
		
		Map<String, Game> allGames = ReadData.createGamesMap();
		String[] gamesToAdd = {"Grand Theft Auto V", "ELDEN RING", "Vampire Survivors", "The Witness", "Plants vs. Zombies: Game of the Year", 
								"Cuphead", "resident evil 4 (2005)"};
		
		Game g1 = new Game("Hollow Knight", "Team Cherry", "Team Cherry");
		Game g2 = new Game("Stardew Valley", "ConcernedApe", "ConcernedApe");
		Game g3 = new Game("Hades", "Supergiant Games", "Supergiant Games");
		
		g1.setGameID(367520);
		g2.setGameID(413150);
		g3.setGameID(1145360);
		
		for(String game: gamesToAdd) {
			
			Game add = allGames.get(game);
			account.addToLibrary(add);
					
		}
		
		account.addToLibrary(g1);
		account.addToLibrary(g2);
		account.addToLibrary(g3);
//		for(int i=0;i<100;i++) {
//			account.addToLibrary(new Game("Test", "Test", "Test"));
//		}
		
		GameManager.setAccount(account);
		Application.launch(GameManager.class, args);
	}

}
