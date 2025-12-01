package gamemanager;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
	
	public static final String STEAM_MAIN_COLOR = "#445059";
	public static final String STEAM_TOP_COLOR = "#232937";
	public static final String STEAM_LEFT_COLOR = "#364047";
	
	private static Account account;
	
	public static void setAccount(Account a) {
		account = a;
	}
	@Override
	public void start(Stage stage) throws Exception {
		Pane centerPane = new Pane();
		VBox topPane = new VBox();
		ScrollPane leftPane = new ScrollPane();
		VBox gamePane = new VBox(5);
		
		leftPane.setContent(gamePane);
		
		centerPane.setStyle(String.format("-fx-background-color: %s", STEAM_MAIN_COLOR));
		topPane.setStyle(String.format("-fx-background-color: %s", STEAM_TOP_COLOR));
		leftPane.setStyle(String.format("-fx-background-color: %s", STEAM_LEFT_COLOR));
		gamePane.setStyle(String.format("-fx-background-color: %s", STEAM_LEFT_COLOR));
		topPane.setMinHeight(100);
		leftPane.setMinWidth(160);
		leftPane.setMaxWidth(160);
		gamePane.setPrefWidth(160);
		gamePane.setPadding(new Insets(5,0,5,10));
		leftPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		
		Label accountLabel = new Label("Account: " + account.getUserName());
		topPane.getChildren().add(accountLabel);
		accountLabel.setAlignment(Pos.CENTER_LEFT);
		accountLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20; -fx-font-weight: bold;");
		
		for(Game g : account.getLibrary().getCollection()) {
			Label l;
			gamePane.getChildren().add(l = new Label(g.getName()));
			l.setStyle("-fx-text-fill: white; -fx-font-size: 15;");
		}
		
		BorderPane bPane = new BorderPane();
		bPane.setCenter(centerPane);
		bPane.setTop(topPane);
		bPane.setLeft(leftPane);
		
		bPane.setCenter(GMPartBuilder.gamePageBuilder(account.getLibrary().getCollection().get(0)));
		
		Scene scene = new Scene(bPane, 1000, 800);
		stage.setTitle("Game Manager");
		stage.setScene(scene);
		stage.show();
	}
}
