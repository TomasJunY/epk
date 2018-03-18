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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DashboardUI {
	
	public static void show(String title) {
		
		Stage window = new Stage();	
		
		/*
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
		
		*/
		
		HBox hboxTop = new HBox();
		hboxTop.setSpacing(8);
		hboxTop.setPadding(new Insets(15, 12, 15, 12));
		
		Label L_userWelcome = new Label("si prihlaseny ako: ");
		//L_userWelcome.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
		//L_userWelcome.setFont(Font.font(12));
		String userWelcomeMessage = Logic.loggedUser.getName() + " " + Logic.loggedUser.getSurname();
		Label L_userName = new Label(userWelcomeMessage);
		Button B_userInfo = new Button("info");
		B_userInfo.setPrefWidth(80);
		B_userInfo.setOnAction(e -> {
			UserInfoUI.show(userWelcomeMessage);
		});
		
		Button B_logOff = new Button("logoff");
		B_logOff.setPrefWidth(80);
		B_logOff.setOnAction(e -> {
			if ( Logic.userLogoff() == true ) {
				//odhlas
				//AlertUI.show("ok", "sicko v poradku", 200, 100);
				LoginUI.show("login");
				window.close();
			}
			else {
				AlertUI.show("chyba", "nepodarilo sa odhlasit", 200, 100);
			}
		});
		
		hboxTop.getChildren().add(L_userWelcome);
		hboxTop.getChildren().add(L_userName);
		hboxTop.getChildren().add(B_userInfo);
		hboxTop.getChildren().add(B_logOff);
		
		/*
		HBox hboxBottom = new HBox();
		hboxBottom.setSpacing(8);
		hboxBottom.setPadding(new Insets(15, 12, 15, 12));
		Button B_logOff = new Button("logoff");
		
		hboxTop.getChildren().add(B_logOff);
		*/
		
		BorderPane border = new BorderPane();
		border.setTop(hboxTop);
		//border.setBottom(hboxBottom);
		
		Scene scene = new Scene(border, 800, 600);
		
		window.setTitle(title);
		window.setScene(scene);		
		window.show();	
	}

}
