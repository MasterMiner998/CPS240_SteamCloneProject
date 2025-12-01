package gamemanager;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GMPartBuilder {
	public static Pane gamePageBuilder(Game game) {
		
		VBox box = new VBox();

		VBox vbxAddColl = new VBox();
		Button btnAddColl = new Button("ADD");
		Label lblAddColl = new Label("Add to collection: ");
		TextField tfAddColl = new TextField();
		
		tfAddColl.setPrefWidth(270);
		tfAddColl.setMinWidth(270);
		tfAddColl.setMaxWidth(270);
		
		lblAddColl.setStyle("-fx-text-fill: white; -fx-font-size: 20; -fx-font-weight: bold;");
		vbxAddColl.setPadding(new Insets(10));
		
		vbxAddColl.getChildren().addAll(lblAddColl, tfAddColl, btnAddColl);
		
		btnAddColl.setOnMouseClicked(e -> {
			
			String collName = tfAddColl.getText();
			tfAddColl.setText("");
			
			if(!collName.isBlank()) {
				
				boolean found = false;
				GameCollection coll = new GameCollection(collName);
				
				
				for(int i = 0; i < Account.getCollections().size(); i++) {
					
					if(Account.getCollections().get(i).getName().equals(collName)) {
						found = true;
						Account.getCollections().get(i).addGame(game);
						break;
					}
				}
				
				if(!found) {
					
					coll.addGame(game);
					Account.getCollections().add(coll);
					
				}
							
			}
			
			for(int i = 0; i < Account.getCollections().size(); i ++) {
				//System.out.println(i);
				System.out.println(Account.getCollections().get(i).name);
				
				for(int j = 0; j < Account.getCollections().get(i).getSize(); j++) {
					
					System.out.print("Game " + j + ": " + Account.getCollections().get(i).getCollection().get(j).getName());
					System.out.println();
					
				}
			
				System.out.println("------------------------------------");
			}
						
		});
		
		VBox vbxMainDisplay = new VBox();
		vbxMainDisplay.setPadding(new Insets(10));
		vbxMainDisplay.setStyle(String.format("-fx-background-color: %s", GameManager.STEAM_MAIN_COLOR));
				
		vbxMainDisplay.getChildren().addAll(box, vbxAddColl);
		
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
		
		
		return vbxMainDisplay;
	}

	public static void AddToCollection() {
		
		
		
	}
	
}


