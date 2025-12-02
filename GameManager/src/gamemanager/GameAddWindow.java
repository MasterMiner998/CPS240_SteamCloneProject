package gamemanager;

import java.io.File;
import java.net.MalformedURLException;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class GameAddWindow extends Stage{
	private Image gameImage;
	public GameAddWindow() {
		super();
		Label header = new Label("Add Game");
		Label nameLb = new Label("Name:");
		Label devLb = new Label("Developer");
		Label pubLb = new Label("Publisher:");
		Label imageLb = new Label("Cover:");
		Label selectedImageLb = new Label("Selected Cover:");
		
		header.setStyle("-fx-text-fill: white; -fx-font-size: 16; -fx-font-weight: bold;");
		nameLb.setStyle("-fx-text-fill: white");
		devLb.setStyle("-fx-text-fill: white");
		pubLb.setStyle("-fx-text-fill: white");
		imageLb.setStyle("-fx-text-fill: white");
		selectedImageLb.setStyle("-fx-text-fill: white");
		
		nameLb.setMinWidth(60);
		devLb.setMinWidth(60);
		pubLb.setMinWidth(60);
		imageLb.setMinWidth(60);
		
		TextField nameBox = new TextField();
		nameBox.setPromptText("name");
		nameBox.setPrefSize(375, 25);
		nameBox.setMinSize(15, 15);
		TextField devBox = new TextField();
		devBox.setPromptText("developer");
		devBox.setPrefSize(375, 25);
		devBox.setMinSize(15, 15);
		TextField pubBox = new TextField();
		pubBox.setPromptText("publisher");
		pubBox.setPrefSize(375, 25);
		pubBox.setMinSize(15, 15);
		
		nameBox.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: white;", GameManager.STEAM_MAIN_COLOR));
		devBox.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: white;", GameManager.STEAM_MAIN_COLOR));
		pubBox.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: white;", GameManager.STEAM_MAIN_COLOR));
		
		Button fileButton = new Button("Open File");
		fileButton.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Select a File");
			fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
			fileChooser.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("Image Files(.png, .jpg)", "*.png", "*.jpg"));
			
			File selectedFile = fileChooser.showOpenDialog(this);
			
			String imagePath = "";
			try {
				imagePath = selectedFile.toURI().toURL().toString();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			gameImage = new Image(imagePath);
			
			if(gameImage.getHeight() != 900 && gameImage.getWidth() != 600) {
				selectedImageLb.setText("Selected cover: Image is not 600 by 900");
				gameImage = null;
			} else {
				selectedImageLb.setText("Selected cover: " + imagePath);
				System.out.println(gameImage);
			}
		});
		fileButton.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: #b2b2b2", GameManager.STEAM_MAIN_COLOR));
		Button addButton = new Button("Add Game");
		addButton.setOnAction(e -> {
			
			System.out.println("Click");
			String gameName;
			String gameDev;
			String gamePub;
			
			if(nameBox.getText().length() == 0) {
				System.out.println("No name");
				return;}
			if(devBox.getText().length() == 0) {
				System.out.println("No dev");
				return;}
			if(pubBox.getText().length() == 0) {
				System.out.println("No pub");
				return;}
			if(gameImage == null) {
				System.out.println("No image");
				return;}
			
			gameName = nameBox.getText();
			gameDev = devBox.getText();
			gamePub = pubBox.getText();
			
			GameManager.getAccount().addToLibrary(new Game(gameName, gameDev, gamePub, gameImage));
			GameManager.refreshLibrary();
			this.close();
		});
		addButton.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: #b2b2b2", GameManager.STEAM_MAIN_COLOR));
		
		VBox grid = new VBox(10);
		
		HBox row1 = new HBox(5);
		row1.getChildren().add(nameLb);
		row1.getChildren().add(nameBox);
//		HBox.setHgrow(nameBox, Priority.ALWAYS);
//		nameBox.setMaxWidth(Double.MAX_VALUE);
		
		HBox row2 = new HBox(5);
		row2.getChildren().add(devLb);
		row2.getChildren().add(devBox);		
//		HBox.setHgrow(devBox, Priority.ALWAYS);
//		devBox.setMaxWidth(Double.MAX_VALUE);
		
		HBox row3 = new HBox(5);
		row3.getChildren().add(pubLb);
		row3.getChildren().add(pubBox);
//		HBox.setHgrow(pubBox, Priority.ALWAYS);
//		pubBox.setMaxWidth(Double.MAX_VALUE);
		
		HBox row4 = new HBox(5);
		row4.getChildren().add(imageLb);
		row4.getChildren().add(fileButton);
		row4.getChildren().add(selectedImageLb);
		
		grid.getChildren().add(header);
		grid.getChildren().add(row1);
		grid.getChildren().add(row2);
		grid.getChildren().add(row3);
		grid.getChildren().add(row4);
		grid.getChildren().add(addButton);
		
		grid.setPadding(new Insets(10,10,10,10));
		
		grid.setStyle(String.format("-fx-background-color: %s", GameManager.STEAM_LEFT_COLOR));
		
		Scene scene = new Scene(grid, 400,200);
		this.setScene(scene);
	}
}
