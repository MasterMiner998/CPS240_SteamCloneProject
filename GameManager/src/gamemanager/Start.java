package gamemanager;

import javafx.application.Application;

public class Start {

	public static void main(String[] args) {
		Account account = new Account("Main");
		
		Game g1 = new Game("Hollow Knight", "Team Cherry", "Team Cherry");
		Game g2 = new Game("Stardew Valley", "ConcernedApe", "ConcernedApe");
		Game g3 = new Game("Hades", "Supergiant Games", "Supergiant Games");
		account.addToLibrary(g1);
		account.addToLibrary(g2);
		account.addToLibrary(g3);
		for(int i=0;i<100;i++) {
			account.addToLibrary(new Game("Test", "Test", "Test"));
		}
		
		GameManager.setAccount(account);
		Application.launch(GameManager.class, args);
	}

}
