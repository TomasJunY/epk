package UI;

import epk.Logic;

import javafx.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DashboardUI {
	
	public static void show(String title) {
		
		Stage window = new Stage();	
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(15);
		//grid.setPrefSize(800, 600);
		
		Label L_userWelcome = new Label("si prihlaseny ako: ");
		GridPane.setConstraints(L_userWelcome, 0, 0);
		String userWelcomeMessage = Logic.loggedUser.getName() + " " + Logic.loggedUser.getSurname();
		Label L_userName = new Label(userWelcomeMessage);
		GridPane.setConstraints(L_userName, 1, 0);
		
		grid.getChildren().add(L_userWelcome);
		grid.getChildren().add(L_userName);
		
		Scene scene = new Scene(grid, 800, 600);
		
		window.setTitle(title);
		window.setScene(scene);		
		window.show();	
	}

}
