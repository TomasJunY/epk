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

public class PasswordChangeUI {

	public static void show(String title) {
		Stage window = new Stage();		
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(15);
		
		Label L_orig = new Label("povodne");
		GridPane.setConstraints(L_orig, 0, 0);
		
		TextField E_orig = new TextField("");
		GridPane.setConstraints(E_orig, 1, 0);
		
		Label L_new = new Label("nove");
		GridPane.setConstraints(L_new, 0, 1);
		
		TextField E_new = new TextField("");
		GridPane.setConstraints(E_new, 1, 1);
		
		Label L_new2 = new Label("nove znova");
		GridPane.setConstraints(L_new2, 0, 2);
		
		TextField E_new2 = new TextField("");
		GridPane.setConstraints(E_new2, 1, 2);
			
		
		Button B_change = new Button("zmen");
		GridPane.setConstraints(B_change, 1, 3);
		B_change.setPrefWidth(80);
		B_change.setOnAction(e -> {
			//rob
			//pokial su rovnake 2 nove hesla
			if ( (E_new.getText().equals(E_new2.getText()) ) == true ) {
				//pokial je rovnake povodne			
				if ( (E_orig.getText().equals(Logic.loggedUser.getPassword()) ) == true ) {
					//men heslo
					Logic.changePassword(Logic.loggedUser.getUsername(), E_new.getText());
					window.close();
				}
				else {
					AlertUI.show("chyba", "povodne sa nezhoduje", 200, 100);
				}
				
				//AlertUI.show("ok", "sicko v poradku", 200, 100);
				//DashboardUI.show("dashboard");
				//window.close();
			}
			else {
				AlertUI.show("chyba", "hesla sa lisia", 200, 100);
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
