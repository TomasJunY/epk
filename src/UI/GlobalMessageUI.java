package UI;

import epk.Logic;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GlobalMessageUI {

	public static void show(String title) {
		Stage window = new Stage();		
			
		VBox vbox = new VBox();
		vbox.setSpacing(8);
		vbox.setPadding(new Insets(15, 25, 15, 25));
		
		Label L_info = new Label("zadaj globalne oznamenie - xd=0");
		TextField E_message = new TextField("eloooooo");
		Button B_confirm = new Button("send");
		
		vbox.getChildren().add(L_info);
		vbox.getChildren().add(E_message);
		vbox.getChildren().add(B_confirm);
		
		Scene scene = new Scene(vbox, 250, 150);
		
		window.setTitle(title);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setScene(scene);	
		window.show();		
	}
}
