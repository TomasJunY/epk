package UI;

import epk.Logic;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import users.*;

public class EditUserUI {
	
	public static void show(String title, int position) {
		Stage window = new Stage();
		
		Label L_username = new Label("username");		
		TextField E_username = new TextField(Logic.users.get(position).getUsername());
		
		Label L_password = new Label("password");
		TextField E_password = new TextField(Logic.users.get(position).getPassword());
		
		Label L_name = new Label("name");
		TextField E_name = new TextField(Logic.users.get(position).getName());
		
		Label L_surname = new Label("surname");
		TextField E_surname = new TextField(Logic.users.get(position).getSurname());
		
		Label L_gender = new Label("gender");
		TextField E_gender = new TextField(Logic.users.get(position).getGender());
		
		Label L_age = new Label("age");
		TextField E_age = new TextField(Integer.toString(Logic.users.get(position).getAge()));
		
		Label L_positon = new Label("position");
		TextField E_positon = new TextField(Logic.users.get(position).getPosition());;
		
		Button B_add = new Button("edit");
		B_add.setPrefWidth(80);
		B_add.setOnAction(e -> {
			Logic.users.get(position).setUsername(E_username.getText());
			Logic.users.get(position).setPassword(E_password.getText());
			Logic.users.get(position).setInfo(E_name.getText(), E_surname.getText(), E_gender.getText(), Integer.parseInt(E_age.getText()), E_positon.getText());
			Logic.writeUsersToFileFromArray();
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
