package gamemanager;

import java.util.ArrayList;

public class Account {

	private String userName;
	private GameCollection library;
	private ArrayList<GameCollection> collections;
	
	public Account(String userName) {
		this.userName = userName;
		this.library = new GameCollection("Library");
		this.collections = new ArrayList<GameCollection>();
	}
	public Account(String userName, ArrayList<Game> gameList) {
		this.userName = userName;
		this.library = new GameCollection("Library", gameList);
		this.collections = new ArrayList<GameCollection>();
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void addToLibrary(Game game) {
		this.library.addGame(game);
	}
	public void removeFromLibrary(Game game) {
		this.library.removeGame(game);
	}
	public void addCollection(String name) {
		collections.add(new GameCollection(name));
	}
	public void removeCollection(int i) {
		collections.remove(i);
	}
	public void addToCollection(int i, Game game) {
		collections.get(i).addGame(game);
	}
	public void removeFromCollection(int i, Game game) {
		collections.get(i).removeGame(game);
	}
}
