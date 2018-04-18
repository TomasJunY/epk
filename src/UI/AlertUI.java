package UI;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.*;

/**
 * <b>AlertUI</b> <br>
 * 
 * This UI is for alerts, errors, etc
 * 
 * @author Tomas Junas
 * @version 1.0
 */
public class AlertUI {
	
	/**
	 * Shows window 
	 * 
	 * @param title title of the window
	 * @param message error message
	 * @param windowX window width
	 * @param windowY window height
	 */
	public static void show(String title, String message, int windowX, int windowY) {
		Stage window = new Stage();
		
		Label L_message = new Label();
		L_message.setText(message);
		
		Button B_confirm = new Button("OK");
		B_confirm.setOnAction(e -> window.close() );
		
		VBox layout = new VBox(15);
		
		layout.getChildren().add(L_message);
		layout.getChildren().add(B_confirm);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, windowX, windowY);
		
		window.setScene(scene);
		window.initModality(Modality.APPLICATION_MODAL);
		window.initStyle(StageStyle.UTILITY);
		window.setTitle(title);
		window.showAndWait();
		
	}

}
