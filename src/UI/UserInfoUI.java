package UI;

import epk.Logic;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UserInfoUI {
	
	public static void show(String title) {
		Stage window = new Stage();
		
		Button B_passwordChange = new Button("zmen heslo");
		B_passwordChange.setOnAction(e -> {
			//men heslo
			PasswordChangeUI.show("zmena hesla");
		} );
		B_passwordChange.setPrefWidth(80);
		
		Label L_name = new Label();
		L_name.setText(Logic.loggedUser.getName());
		
		Label L_surname = new Label();
		L_surname.setText(Logic.loggedUser.getSurname());
		
		Label L_gender = new Label();
		L_gender.setText(Logic.loggedUser.getGender());
		
		Label L_age = new Label();
		L_age.setText(Integer.toString(Logic.loggedUser.getAge()));
		
		Label L_positon = new Label();
		L_positon.setText(Logic.loggedUser.getPosition());
		
		Button B_confirm = new Button("ok");
		B_confirm.setOnAction(e -> window.close() );
		B_confirm.setPrefWidth(80);
		
		VBox layout = new VBox(15);
		
		layout.getChildren().add(B_passwordChange);
		layout.getChildren().add(L_name);
		layout.getChildren().add(L_surname);
		layout.getChildren().add(L_gender);
		layout.getChildren().add(L_age);
		layout.getChildren().add(L_positon);
		layout.getChildren().add(B_confirm);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 300, 250);
		
		window.setScene(scene);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.showAndWait();		
	}

}
