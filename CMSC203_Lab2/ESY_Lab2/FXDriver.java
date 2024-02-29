package Lab2_GUI_FX;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXDriver extends Application {
	   
	/**
	 * The main method for the GUI example program JavaFX version
	 * @param args not used
	 * @throws IOException
	 */
	FXMainPane root = new FXMainPane(); 
	public static void main(String[] args) {
		launch(args);   	
	}
		   
	@Override
	public void start(Stage stage) throws IOException {
		stage.setTitle("Hello World GUI");
		stage.setScene(new Scene(root, 700, 200));  
		stage.show();

	}
}
