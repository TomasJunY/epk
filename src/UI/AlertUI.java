package UI;

import javafx.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertUI {
	
	public static void show(String title, String message, int windowX, int windowY) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		//window.setMinWidth(500);
		
		Label L_message = new Label();
		L_message.setText(message);
		
		Button B_confirm = new Button("ok");
		B_confirm.setOnAction(e -> window.close() );
		
		VBox layout = new VBox(15);
		
		layout.getChildren().add(L_message);
		layout.getChildren().add(B_confirm);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, windowX, windowY);
		window.setScene(scene);
		
		window.showAndWait();
		
	}

}
