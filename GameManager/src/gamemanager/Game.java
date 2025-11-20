package gamemanager;

import java.awt.Image;

public class Game implements Comparable<Game> {
	public static SortType sortType = SortType.Alphabetical;
	public static enum SortType{
		Alphabetical,
		Rating,
		Playtime,
		ReleaseDate
	}
	
	private String name;
	private String developer;
	private String publisher;
	private String[] genres;
	
	private Double rating;
	private Double playTime;
	private String releaseDate;
	
	private Image cover;

	@Override
	public int compareTo(Game game) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return String.format("%s, by %s, published by: %s", name, developer, publisher);
	}
	
}
