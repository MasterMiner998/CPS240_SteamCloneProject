package gamemanager;

import java.util.ArrayList;
import java.util.Comparator;

public class GameCollection {
	String name;
	ArrayList<Game> gcSorted;
	ArrayList<Game> gameCollectionDisplay;
	
	public GameCollection(String name) {
		super();
		this.name = name;
		this.gcSorted = new ArrayList<Game>();
		//Game.sortType = Game.SortType.Alphabetical;
		this.gcSorted.sort(null);
	}
	public GameCollection(String name, ArrayList<Game> gameCollection) {
		super();
		this.name = name;
		this.gcSorted = (ArrayList<Game>) gameCollection.clone();
		//Game.sortType = Game.SortType.Alphabetical;
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
		//Game.sortType = Game.SortType.Alphabetical;
		this.gcSorted.sort(null);
	}
	public Game getGame(String x) {
		int l = 0;
        int r = gcSorted.size() - 1;

        while (l <= r) {

            int m = l + (r - l) / 2;

            if (gcSorted.get(m).getName().equals(x)) {
                return gcSorted.get(m);
            }
            if (gcSorted.get(m).getName().compareTo(x) < 0) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
		
		return null;
	}
	
}
