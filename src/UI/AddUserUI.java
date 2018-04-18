package UI;

import epk.Logic;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import users.*;

/**
 * <b>AddUserUI</b> <br>
 * 
 * This UI is for adding user
 * 
 * @author Tomas Junas
 * @version 1.0
 */
public class AddUserUI {
	
	/**
	 * Shows window 
	 * 
	 * @param title title of the window
	 */
	public static void show(String title) {
		Stage window = new Stage();
		
		Label L_username = new Label("username");		
		TextField E_username = new TextField();
		
		Label L_password = new Label("heslo");
		TextField E_password = new TextField();
		
		Label L_name = new Label("meno");
		TextField E_name = new TextField();
		
		Label L_surname = new Label("priezvisko");
		TextField E_surname = new TextField();
		
		Label L_gender = new Label("pohlavie");
		TextField E_gender = new TextField();
		
		Label L_age = new Label("vek");
		TextField E_age = new TextField();
		
		Label L_positon = new Label("pracovná pozícia");
		TextField E_positon = new TextField();;
		
		Button B_add = new Button("Pridaj");
		B_add.setPrefWidth(80);
		B_add.setOnAction(e -> {
			User newUser = new User(E_username.getText(), E_password.getText());
			newUser.setInfo(E_name.getText(), E_surname.getText(), E_gender.getText(), Integer.parseInt(E_age.getText()), E_positon.getText());
			Logic.addUser(newUser);
			window.close();
		});
				
		VBox layout = new VBox(15);
		
		layout.getChildren().add(L_username);
		layout.getChildren().add(E_username);
		layout.getChildren().add(L_password);
		layout.getChildren().add(E_password);
		layout.getChildren().add(L_name);
		layout.getChildren().add(E_name);
		layout.getChildren().add(L_surname);
		layout.getChildren().add(E_surname);
		layout.getChildren().add(L_gender);
		layout.getChildren().add(E_gender);
		layout.getChildren().add(L_age);
		layout.getChildren().add(E_age);
		layout.getChildren().add(L_positon);
		layout.getChildren().add(E_positon);
		layout.getChildren().add(B_add);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 200, 550);
		
		window.setScene(scene);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.showAndWait();		
	}

}
