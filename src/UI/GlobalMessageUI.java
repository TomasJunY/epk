package UI;

import epk.Logic;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
		
		Label L_date = new Label("zadaj datum");
		TextField E_date = new TextField("15.11.2030");
		
		Label L_message = new Label("zadaj spravu");
		TextField E_message = new TextField("eloo$oooo");
		
		CheckBox CB_closed = new CheckBox("moze byt zatvorena");
		
		Label L_info = new Label("sprava sa zobrazi az po odhlaseni");
		Button B_confirm = new Button("send");
		B_confirm.setOnAction(e -> {
			String message = E_message.getText();
			//Logic.writeMessageToFile(message);
			//Logic.loadMessageFromFile();
			//Logic.writeMessageSeenToFile(Logic.loggedUser.getUsername(), false);
			
			boolean canBeClosed = true;
			if (CB_closed.isSelected()) {
				canBeClosed = true;
			}
			else {
				canBeClosed = false;
			}
			
			Logic.writeMessageToFile(E_date.getText(), E_message.getText(), canBeClosed);
			window.close();
		});
			
		vbox.getChildren().add(L_date);
		vbox.getChildren().add(E_date);
		vbox.getChildren().add(L_message);
		vbox.getChildren().add(E_message);
		vbox.getChildren().add(CB_closed);
		vbox.getChildren().add(L_info);
		vbox.getChildren().add(B_confirm);
		
		Scene scene = new Scene(vbox, 250, 250);
		
		window.setTitle(title);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setScene(scene);	
		window.show();		
	}
}
