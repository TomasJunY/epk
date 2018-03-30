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
		hboxTop.setStyle("-fx-background-color: #0099ff;");
		
		HBox hboxCenter = new HBox();
		hboxCenter.setSpacing(8);
		hboxCenter.setPadding(new Insets(15, 12, 15, 12));
		//hboxCenter.setStyle("-fx-background-color: #0099ff;");
		
		VBox vboxRight = new VBox();
		vboxRight.setSpacing(8);
		vboxRight.setPadding(new Insets(15, 12, 15, 12));
		vboxRight.setStyle("-fx-background-color: #ff9933;");
		vboxRight.setPrefWidth(130);
		
		HBox hboxBotton = new HBox();
		hboxBotton.setSpacing(8);
		hboxBotton.setPadding(new Insets(15, 12, 15, 12));
		hboxBotton.setAlignment(Pos.BOTTOM_RIGHT);;
		hboxBotton.setStyle("-fx-background-color: grey;");
		
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
		
		Button B_debug = new Button("debug");
		B_debug.setOnAction(e -> {
			//
			Logic.loadCoursesList();
		});
		
		ComboBox comboCourses = new ComboBox<>();
		for (int a = 0; a < Logic.loggedUser.getCourseLength(); a++) {
			comboCourses.getItems().add(Logic.loggedUser.getCourse(a).getName());
		 }
		//comboCourses.getItems().addAll("1", "2", "3");
		comboCourses.setPromptText("vyber si kurz");
		
		Button B_Course = new Button("choc");
		B_Course.setOnAction(e -> {
			//	
			if (comboCourses.getValue()==null) {
				//
				System.out.println("chyba");
			}
			else {
				//
				String selectedCName = (String) comboCourses.getValue();
				int pos = Logic.loggedUser.getCourseIndex(selectedCName);
				CourseUI.show(selectedCName, (String) comboCourses.getValue(), pos);
				window.close();
			}					
		});
		
		hboxTop.getChildren().add(L_userWelcome);
		hboxTop.getChildren().add(L_userName);
		hboxTop.getChildren().add(B_userInfo);
		
		//hboxTop.getChildren().add(B_debug);
		
		hboxCenter.getChildren().add(comboCourses);
		hboxCenter.getChildren().add(B_Course);
		
		hboxBotton.getChildren().add(B_logOff);
		
		BorderPane border = new BorderPane();
		border.setTop(hboxTop);
		border.setBottom(hboxBotton);
		border.setCenter(hboxCenter);
		
		if(Logic.loggedUser.isAdmin()) {
			Label L_admin = new Label("nastroje na spravu");
			
			Button B_globalMessage = new Button("global sprava");
			B_globalMessage.setOnAction(e -> {
				//
				GlobalMessageUI.show("nastav spravu");
			});
			
			vboxRight.getChildren().add(L_admin);
			vboxRight.getChildren().add(B_globalMessage);
			
			border.setRight(vboxRight);
		}
			
		Scene scene = new Scene(border, 350, 400);
		
		window.setTitle(title);
		window.setScene(scene);		
		window.show();	
	}

}
