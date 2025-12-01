package gamemanager;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		GridPane centerPane = new GridPane();
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
		
		int gridPaneCol = 0;
		int gridPaneRow = 0;
		
		centerPane.setHgap(10);
		centerPane.setVgap(10);
		
		for(Game g : account.getLibrary().getCollection()) {
			
			parseCoverImage(g);
			
			Label l;
			leftPane.getChildren().add(l = new Label(g.getName()));
			l.setStyle("-fx-text-fill: white; -fx-font-size: 15;");
			
			ImageView gameImg = new ImageView(g.getCover());
			
			gameImg.setFitWidth(200);
			gameImg.setFitHeight(300);
			
			centerPane.add(gameImg, gridPaneCol, gridPaneRow);
			
			gridPaneCol += 1;
			
			if(gridPaneCol >= 8) {
				gridPaneCol = 0;
				gridPaneRow += 1;
			}
		
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
	
	public void parseCoverImage(Game game) {
		
		String steamImageLink = "https://cdn2.steamgriddb.com/thumb/c5174327c1975f78b7ffc788ed60b80e.jpg";
		String imageLink = String.format("https://steamcdn-a.akamaihd.net/steam/apps/%d/library_600x900_2x.jpg", game.getGameID());
		
		
		Image cover = new Image(steamImageLink);
		
		try {
		
			if(game.getGameID() != -1) {
				
				System.out.println("Found at " + imageLink);
				
				cover = new Image(imageLink);
				
			}
		
		} catch(Exception e) {
			
		}
		
		game.setCover(cover);
		
	}
	
}
