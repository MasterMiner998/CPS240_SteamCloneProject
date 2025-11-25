package gamemanager;

import java.util.ArrayList;

public class Account {

	private String UserName;
	private GameCollection library;
	private ArrayList<GameCollection> collections;
	
	public Account(String userName) {
		this.UserName = userName;
		this.library = new GameCollection("Library");
		this.collections = new ArrayList<GameCollection>();
	}
	public Account(String userName, ArrayList<Game> gameList) {
		this.UserName = userName;
		this.library = new GameCollection("Library", gameList);
		this.collections = new ArrayList<GameCollection>();
	}
	
	public void addToLibrary(Game game) {
		this.library.addGame(game);
	}
	
	
}
