package gamemanager;

import java.util.ArrayList;
import java.util.Comparator;

public class GameCollection {
	String name;
	ArrayList<Game> gcSorted;
	ArrayList<Game> gameCollectionDisplay;
	public GameCollection(String name, ArrayList<Game> gameCollection) {
		super();
		this.name = name;
		this.gcSorted = gameCollection;
		Game.sortType = Game.SortType.Alphabetical;
		this.gcSorted.sort(null);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Game> getGameCollection() {
		return gameCollectionDisplay;
	}
	public void setGameCollection(ArrayList<Game> gameCollection) {
		this.gcSorted = gameCollection;
	}
	
	
	public void addGame(Game game) {
		gcSorted.add(game);
		Game.sortType = Game.SortType.Alphabetical;
		this.gcSorted.sort(null);
	}
	public Game getGame(String name) {
		int size = gcSorted.size();
		int startingI = size/2;
		int i = startingI;
		
		return null;
	}
	
}
