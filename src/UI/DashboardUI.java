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
		
		
		Scene scene = new Scene(grid, 800, 600);
		
		window.setTitle(title);
		window.setScene(scene);		
		window.show();	
	}

}
