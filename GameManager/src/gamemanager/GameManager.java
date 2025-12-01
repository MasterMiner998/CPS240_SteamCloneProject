package gamemanager;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameManager extends Application{
	
	public static final String STEAM_MAIN_COLOR = "#445059";
	public static final String STEAM_TOP_COLOR = "#232937";
	public static final String STEAM_LEFT_COLOR = "#364047";
	
	private static Account account;
	
	VBox centerContainer;
	BorderPane bPane;
	FlowPane gameView;
	VBox gameLeftPane;
	
	public static void setAccount(Account a) {
		account = a;
	}
	@Override
	public void start(Stage stage) throws Exception {
		centerContainer = new VBox();
		VBox topPane = new VBox();
		gameLeftPane = new VBox(5);
		
		gameView = new FlowPane();
		
		ScrollPane centerPane = new ScrollPane();
		ScrollPane leftPane = new ScrollPane();
		
		bPane = new BorderPane();
		
		Label accountLabel;
		if(account != null) {
			accountLabel = new Label("Account: " + account.getUserName());
		} else {
			accountLabel = new Label("Account: No Account");
		}
		accountLabel.setAlignment(Pos.CENTER_LEFT);
		accountLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20; -fx-font-weight: bold;");
		
		Label libraryLabel = new Label("Library");
		libraryLabel.setStyle("-fx-text-fill: white; -fx-font-size: 45;");
		
		centerContainer.setStyle(String.format("-fx-background-color: %s", STEAM_MAIN_COLOR));
		topPane.setStyle(String.format("-fx-background-color: %s", STEAM_TOP_COLOR));
		leftPane.setStyle(String.format("-fx-background-color: %s", STEAM_LEFT_COLOR));
		gameLeftPane.setStyle(String.format("-fx-background-color: %s", STEAM_LEFT_COLOR));
		
		topPane.setMinHeight(100);
		
		leftPane.setContent(gameLeftPane);
		leftPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		leftPane.setMinWidth(160);
		leftPane.setMaxWidth(160);
		
		gameView.setPrefWidth(Region.USE_COMPUTED_SIZE);
		gameView.setHgap(10);
		gameView.setVgap(10);
		
		gameLeftPane.setPrefWidth(145);
		gameLeftPane.setPadding(new Insets(5,0,5,10));
		
		centerContainer.getChildren().add(libraryLabel);
		centerContainer.getChildren().add(gameView);
		
		centerPane.setContent(centerContainer);
		centerPane.setFitToWidth(true);
		
		topPane.getChildren().add(accountLabel);
		
		refreshLibrary();
		
		bPane.setCenter(centerPane);
		bPane.setTop(topPane);
		bPane.setLeft(leftPane);
		
		//bPane.setCenter(GMPartBuilder.gamePageBuilder(account.getLibrary().getCollection().get(0)));
		
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
								
				cover = new Image(imageLink);
				
			}
		
		} catch(Exception e) {
			
		}
		
		game.setCover(cover);
		
	}
	public void refreshLibrary() {
		for(Game g : account.getLibrary().getCollection()) {
			
			parseCoverImage(g);
			
			Label l;
			gameLeftPane.getChildren().add(l = new Label(g.getName()));
			l.setStyle("-fx-text-fill: white; -fx-font-size: 15;");
			
			ImageView gameImg = new ImageView(g.getCover());
			
			gameImg.setFitWidth(200);
			gameImg.setFitHeight(300);
			
			gameImg.setOnMouseClicked(event -> {
				
				bPane.setCenter(GMPartBuilder.gamePageBuilder(g));
				
			});
			
			gameView.getChildren().add(gameImg);
		
		}
	}
	
}
