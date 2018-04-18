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
		
		Label L_date = new Label("Zadaj dátum");
		TextField E_date = new TextField();
		E_date.setPromptText("15.11.2030");
		
		Label L_message = new Label("Zadaj správu");
		TextField E_message = new TextField();
		E_message.setPromptText("helou");
		
		CheckBox CB_closed = new CheckBox("Môže by zatvorená");
		
		Label L_info = new Label("Správa sa zobrazí až po odhlásení");
		Button B_confirm = new Button("Send");
		B_confirm.setOnAction(e -> {
			String message = E_message.getText();
			
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
