package Lab2_GUI_FX;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Label label;
	TextField textField;
	HBox hBox; 
	HBox hBox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		button1 = new Button("Hello");
		button2 = new Button("Howdy");
		button3 = new Button("Chinese");
		button4 = new Button("Clear");
		button5 = new Button("Exit");
		button6 = new Button("Spanish");
		label = new Label("Feedback");
		textField = new TextField();
		hBox = new HBox(); 
		hBox2 = new HBox();
		dataManager = new DataManager();
	    button1.setOnAction(new ButtonHandler());
	    button2.setOnAction(new ButtonHandler());
		button3.setOnAction(new ButtonHandler());
		button4.setOnAction(new ButtonHandler());
		button5.setOnAction(new ButtonHandler());
		button6.setOnAction(new ButtonHandler());
		HBox.setMargin(button1, getInsets());
		hBox.setAlignment(Pos.CENTER);
		HBox.setMargin(button2, getInsets());
		hBox.setAlignment(Pos.CENTER);
		HBox.setMargin(button3, getInsets());
		hBox.setAlignment(Pos.CENTER);
		HBox.setMargin(button4, getInsets());
		hBox.setAlignment(Pos.CENTER);
		HBox.setMargin(button5, getInsets());
		hBox.setAlignment(Pos.CENTER);
		HBox.setMargin(button6, getInsets());
		hBox.setAlignment(Pos.CENTER);
		    
		
		//student Task #3:
		hBox.getChildren().addAll(button1, button2, button3, button6, button4, button5);
		hBox2.getChildren().addAll(label, textField);
		this.getChildren().addAll(hBox, hBox2);
		
	}
	
	//Task #4:
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			Object target = event.getTarget();
			if(target == button1) {
				textField.setText(dataManager.getHello());
			}else if(target == button2) {
				textField.setText(dataManager.getHowdy());
			}else if(target == button3) {
				textField.setText(dataManager.getChinese());
			}else if(target == button4) {
				textField.setText("");
			}else if(target == button5) {
				Platform.exit();
				System.exit(0);
			}else if(target == button6) {
				textField.setText(dataManager.getSpanish());
			}
		}
	}
}
	
