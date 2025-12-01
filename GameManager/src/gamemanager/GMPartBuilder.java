package gamemanager;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GMPartBuilder {
	public static Pane gamePageBuilder(Game game) {
		Pane p = new Pane();
		p.setStyle(String.format("-fx-background-color: %s", GameManager.STEAM_MAIN_COLOR));
		
		VBox box = new VBox();
		p.getChildren().add(box);
		
		box.setStyle(String.format("-fx-background-color: %s", GameManager.STEAM_MAIN_COLOR));
		try {
			Label name = new Label(game.getName());
			name.setStyle("-fx-text-fill: white; -fx-font-size: 20; -fx-font-weight: bold;");
			name.setPadding(new Insets(0,0,5,0));
			box.getChildren().add(name);
		} catch(NullPointerException e) {}
		
		try {
			Label dev = new Label("Developer: " + game.getDeveloper());
			dev.setStyle("-fx-text-fill: white;");
			box.getChildren().add(dev);
		}catch(NullPointerException e) {}
		
		try {
			Label pub = new Label("Publisher: " + game.getPublisher());
			pub.setStyle("-fx-text-fill: white;");
			pub.setPadding(new Insets(0,0,10,0));
			box.getChildren().add(pub);
		} catch(NullPointerException e) {}
		
		try {
			String genreString = "Genres: ";
			for(String g : game.getGenres()) {
				genreString += g + ",";
			}
			Label genres = new Label(genreString);
			genres.setStyle("-fx-text-fill: white;");
			box.getChildren().add(genres);
		} catch(NullPointerException e) {}
		
		try {
			Label rating = new Label("Rating: " + game.getRating().toString());
			rating.setStyle("-fx-text-fill: white;");
			box.getChildren().add(rating);
		} catch(NullPointerException e) {}
		
		try {
			Label playTime = new Label("Play time: " + game.getPlayTime().toString());
			playTime.setStyle("-fx-text-fill: white;");
			box.getChildren().add(playTime);
		}catch(NullPointerException e) {}
		
		try {
			Label release = new Label("Release Date: " + game.getReleaseDate());
			release.setStyle("-fx-text-fill: white;");
			box.getChildren().add(release);
		} catch(NullPointerException e) {}
		
		
		return p;
	}
}
