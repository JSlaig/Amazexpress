package controlador;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Amazexpress extends Application {
	public static Stage stage = null;
	@Override
	public void start(Stage primaryStage) {	
		try {
		
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/vista/LoginUI.fxml"));
			Pane ventana = (Pane) loader.load();
			
			Scene scene = new Scene(ventana);
			primaryStage.setScene(scene);
			this.stage = primaryStage;
			primaryStage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}

		
	}
	
	public static void main(String[] args) {	
		
		launch(args);		
	}
}
