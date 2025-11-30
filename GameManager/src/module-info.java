/**
 * 
 */
/**
 * 
 */
module GameManager {
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.controls;
	
	opens gamemanager to javafx.graphics, javafx.controls;
	
}