package UI;

import epk.Logic;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PasswordChangeUI {

	public static void show(String title) {
		Stage window = new Stage();		
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(15);
		
		Label L_orig = new Label("Pôvodné");
		GridPane.setConstraints(L_orig, 0, 0);
		
		PasswordField E_orig = new PasswordField();
		GridPane.setConstraints(E_orig, 1, 0);
		
		Label L_new = new Label("Nové");
		GridPane.setConstraints(L_new, 0, 1);
		
		PasswordField E_new = new PasswordField();
		GridPane.setConstraints(E_new, 1, 1);
		
		Label L_new2 = new Label("Nové znova");
		GridPane.setConstraints(L_new2, 0, 2);
		
		PasswordField E_new2 = new PasswordField();
		GridPane.setConstraints(E_new2, 1, 2);
			
		Button B_change = new Button("Zmeò");
		GridPane.setConstraints(B_change, 1, 3);
		B_change.setPrefWidth(80);
		B_change.setOnAction(e -> {
			//pokial su rovnake 2 nove hesla
			if ( (E_new.getText().equals(E_new2.getText()) ) == true ) {
				//pokial je rovnake povodne			
				if ( (E_orig.getText().equals(Logic.loggedUser.getPassword()) ) == true ) {
					//men heslo
					Logic.changePassword(Logic.loggedUser.getUsername(), E_new.getText());
					window.close();
				}
				else {
					AlertUI.show("Chyba", "Pôvodné sa nezhoduje", 200, 100);
				}
			}
			else {
				AlertUI.show("Chyba", "Heslá sú odlišné", 200, 100);
			}
		});
		
		grid.getChildren().add(L_orig);
		grid.getChildren().add(E_orig);
		grid.getChildren().add(L_new);
		grid.getChildren().add(E_new);
		grid.getChildren().add(L_new2);
		grid.getChildren().add(E_new2);
		grid.getChildren().add(B_change);
		
		Scene scene = new Scene(grid, 250, 150);
		
		window.setTitle(title);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setScene(scene);	
		window.show();		
	}
}
