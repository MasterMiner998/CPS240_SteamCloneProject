package gamemanager;

import java.awt.Image;

public class Game implements Comparable<Game> {
	
	private String Name;
	private String Developer;
	private String Publisher;
	private String[] Genres;
	
	private Double Rating;
	private Double PlayTime;
	
	private Image Cover;

	@Override
	public int compareTo(Game game) {
		// TODO Auto-generated method stub
		return 0;
	}

}
