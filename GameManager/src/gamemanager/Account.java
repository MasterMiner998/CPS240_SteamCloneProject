package gamemanager;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Account {

	private String userName;
	private GameCollection library;
	private ArrayList<GameCollection> collections;
	int idCount;
	public Account(String userName) {
		this.userName = userName;
		this.library = new GameCollection(0, "Library");
		this.collections = new ArrayList<GameCollection>();
		this.idCount = 1;
	}
	public Account(String userName, ArrayList<Game> gameList) {
		this.userName = userName;
		this.library = new GameCollection("Library", gameList);
		this.collections = new ArrayList<GameCollection>();
		this.idCount = 1;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public GameCollection getLibrary() {
		return this.library;
	}
	public ArrayList<GameCollection> getCollections(){
		return this.collections;
	}
	public void addToLibrary(Game game) {
		parseCoverImage(game);
		this.library.addGame(game);
	}
	public void removeFromLibrary(Game game) {
		this.library.removeGame(game);
	}
	public void addCollection(String name) {
		collections.add(new GameCollection(idCount, name));
	}
	public void removeCollection(int i) {
		collections.remove(i);
		for(int j=0;j<collections.size();i++)
			collections.get(j).setId(i+1);
		idCount--;
	}
	public void addToCollection(int i, Game game) {
		collections.get(i).addGame(game);
	}
	public void removeFromCollection(int i, Game game) {
		collections.get(i).removeGame(game);
	}

	public void parseCoverImage(Game game) {
		
		String imageLink = String.format("https://steamcdn-a.akamaihd.net/steam/apps/%d/library_600x900_2x.jpg", game.getGameID());
		BufferedImage cover = null;
		
		try {
		
			URL url = new URL(imageLink);
			cover = ImageIO.read(url);
		
		} catch(IOException e) {
			
		}
		
		game.setCover(cover);
		
	}
	
}
