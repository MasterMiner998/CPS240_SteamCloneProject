package gamemanager;

import javafx.scene.image.*;

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
	
	private int gameID = -1;
	
	private Image cover;
	
	
	
	public Game(String name, String developer, String publisher, String[] genres, Double rating, Double playTime,
			String releaseDate, int gameID, Image cover) {
		super();
		this.name = name;
		this.developer = developer;
		this.publisher = publisher;
		this.genres = genres;
		this.rating = rating;
		this.playTime = playTime;
		this.releaseDate = releaseDate;
		this.gameID = gameID;
		this.cover = cover;
	}
	

	public Game(String name, String developer, String publisher) {
		super();
		this.name = name;
		this.developer = developer;
		this.publisher = publisher;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getGenres() {
		return genres;
	}

	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getPlayTime() {
		return playTime;
	}

	public void setPlayTime(Double playTime) {
		this.playTime = playTime;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Image getCover() {
		return cover;
	}

	public void setCover(Image cover) {
		this.cover = cover;
	}
	
	public int getGameID() {
		return gameID;
	}


	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	@Override
	public int compareTo(Game game) {
		return this.name.toLowerCase().compareTo(game.getName().toLowerCase());
	}

	@Override
	public String toString() {
		return String.format("%s, developed by %s, and published by %s", name, developer, publisher);
	}
	
}
