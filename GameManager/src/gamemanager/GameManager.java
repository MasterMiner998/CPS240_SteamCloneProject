package gamemanager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameManager extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		GridPane gPane = new GridPane();
		Scene scene = new Scene(gPane, 1000, 800);
		stage.setTitle("Game Manager");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
