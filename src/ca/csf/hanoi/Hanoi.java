package ca.csf.hanoi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Hanoi extends Application {

	@Override
	public void start(Stage primaryStage) {
		try { // Starts the JavaFX application 
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene scene = new Scene(root, 400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}