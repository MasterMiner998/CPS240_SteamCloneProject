package gamemanager;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class GameAddWindow extends Stage{
	public GameAddWindow() {
		super();
		Label header = new Label("Add Game");
		Label nameLb = new Label("Name:");
		Label devLb = new Label("Developer");
		Label pubLb = new Label("Publisher:");
		
		header.setStyle("-fx-text-fill: white; -fx-font-size: 16; -fx-font-weight: bold;");
		nameLb.setStyle("-fx-text-fill: white");
		devLb.setStyle("-fx-text-fill: white");
		pubLb.setStyle("-fx-text-fill: white");
		
		nameLb.setMinWidth(60);
		devLb.setMinWidth(60);
		pubLb.setMinWidth(60);
		
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
		
		nameBox.setStyle(String.format("-fx-background-color: %s", GameManager.STEAM_MAIN_COLOR));
		devBox.setStyle(String.format("-fx-background-color: %s", GameManager.STEAM_MAIN_COLOR));
		pubBox.setStyle(String.format("-fx-background-color: %s", GameManager.STEAM_MAIN_COLOR));
		
		Button addButton = new Button("Add Game");
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
		
		grid.getChildren().add(header);
		grid.getChildren().add(row1);
		grid.getChildren().add(row2);
		grid.getChildren().add(row3);
		grid.getChildren().add(addButton);
		
		grid.setPadding(new Insets(10,10,10,10));
		
		grid.setStyle(String.format("-fx-background-color: %s", GameManager.STEAM_LEFT_COLOR));
		
		Scene scene = new Scene(grid, 400,200);
		this.setScene(scene);
	}
}
