package gamemanager;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameManager extends Application{
	
	private static final String STEAM_MAIN_COLOR = "#445059";
	private static final String STEAM_TOP_COLOR = "#232937";
	private static final String STEAM_LEFT_COLOR = "#364047";
	
	private static Account account;
	
	public static void setAccount(Account a) {
		account = a;
	}
	@Override
	public void start(Stage stage) throws Exception {
		Pane centerPane = new Pane();
		VBox topPane = new VBox();
		VBox leftPane = new VBox(5);
		
		centerPane.setStyle(String.format("-fx-background-color: %s", STEAM_MAIN_COLOR));
		topPane.setStyle(String.format("-fx-background-color: %s", STEAM_TOP_COLOR));
		leftPane.setStyle(String.format("-fx-background-color: %s", STEAM_LEFT_COLOR));
		topPane.setMinHeight(100);
		leftPane.setMinWidth(160);
		leftPane.setPadding(new Insets(5,0,5,10));
		
		Label accountLabel = new Label("Account: " + account.getUserName());
		topPane.getChildren().add(accountLabel);
		accountLabel.setAlignment(Pos.CENTER_LEFT);
		accountLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20; -fx-font-weight: bold;");
		
		for(Game g : account.getLibrary().getCollection()) {
			Label l;
			leftPane.getChildren().add(l = new Label(g.getName()));
			l.setStyle("-fx-text-fill: white; -fx-font-size: 15;");
		}
		
		BorderPane bPane = new BorderPane();
		bPane.setCenter(centerPane);
		bPane.setTop(topPane);
		bPane.setLeft(leftPane);
		
		Scene scene = new Scene(bPane, 1000, 800);
		stage.setTitle("Game Manager");
		stage.setScene(scene);
		stage.show();
	}
}
