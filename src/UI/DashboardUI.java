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
import message.ManualTimeMessage;

public class DashboardUI {
	
	public static void show(String title) {
		
		Stage window = new Stage();	
		
		HBox hboxTop = new HBox();
		hboxTop.setSpacing(8);
		hboxTop.setPadding(new Insets(15, 12, 15, 12));
		hboxTop.setStyle("-fx-background-color: #0099ff;");
		
		HBox hboxCenter = new HBox();
		hboxCenter.setSpacing(8);
		hboxCenter.setPadding(new Insets(15, 12, 15, 12));
		//hboxCenter.setStyle("-fx-background-color: #0099ff;");
		
		HBox hboxMessage = new HBox();
		hboxMessage.setSpacing(8);
		hboxMessage.setPadding(new Insets(15, 12, 15, 12));
		//hboxCenter.setStyle("-fx-background-color: #0099ff;");
		
		VBox vboxCenter = new VBox();
		//hboxCenter.setSpacing(8);
		//hboxCenter.setPadding(new Insets(15, 12, 15, 12));
		
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
		
		//zobraz
		if (Logic.loggedUser.getGlobalMessage().isNotSeen()) {
			Label L_message = new Label();
			L_message.setText(Logic.loggedUser.getGlobalMessage().getFormattedExpiration() + " " +Logic.loggedUser.getGlobalMessage().getMessage());
			hboxMessage.getChildren().add(L_message);
			
			if (Logic.loggedUser.getGlobalMessage() instanceof ManualTimeMessage) {
				Button B_message = new Button("x");
				B_message.setOnAction(e -> {
					Logic.loggedUser.getGlobalMessage().setSeen(true);
					Logic.writeUserMessageToFile(Logic.loggedUser.getUsername(), Logic.loggedUser.getGlobalMessage());
					window.close();
					show("dashboard");		
				});				
				hboxMessage.getChildren().add(B_message);
			}				
		}
						
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
		/*
		Button B_debug = new Button("debug");
		B_debug.setOnAction(e -> {
			//
			Logic.loadCoursesList();
		});
		*/
		ComboBox comboCourses = new ComboBox<>();
		for (int a = 0; a < Logic.loggedUser.getCourseLength(); a++) {
			comboCourses.getItems().add(Logic.loggedUser.getCourse(a).getName());
		 }
		comboCourses.setPromptText("vyber si kurz");
		
		Button B_Course = new Button("rob");
		B_Course.setOnAction(e -> {
			//	
			if (comboCourses.getValue()==null) {
				System.out.println("chyba");
			}
			else {
				String selectedCName = (String) comboCourses.getValue();
				int pos = Logic.loggedUser.getCourseIndex(selectedCName);
				CourseUI.show(selectedCName, (String) comboCourses.getValue(), pos);
				//load max point
				Logic.saveMaxPoints(pos);
				window.close();
			}					
		});
		
		hboxTop.getChildren().add(L_userWelcome);
		hboxTop.getChildren().add(L_userName);	
		
		//hboxTop.getChildren().add(B_debug);
				
		hboxCenter.getChildren().add(comboCourses);
		hboxCenter.getChildren().add(B_Course);
		
		if (Logic.loggedUser.getGlobalMessage().isNotSeen()) {
			vboxCenter.getChildren().add(hboxMessage);
		}
		
		vboxCenter.getChildren().add(hboxCenter);
		
		hboxBotton.getChildren().add(B_userInfo);
		hboxBotton.getChildren().add(B_logOff);
		
		BorderPane border = new BorderPane();
		border.setTop(hboxTop);
		border.setBottom(hboxBotton);
		border.setCenter(vboxCenter);
		
		//admin veci
		if(Logic.loggedUser.isAdmin()) {
			Label L_admin = new Label("nastroje na spravu");
			
			Button B_globalMessage = new Button("oznamenie");
			B_globalMessage.setOnAction(e -> {
				//
				GlobalMessageUI.show("nastav spravu");
			});
			
			Button B_addUser = new Button("pridaj usera");
			B_addUser.setOnAction(e -> {
				//
				AddUserUI.show("pridaj usera");
			});
			
			Label L_edit = new Label("edituj usera");
					
			ComboBox comboUsers = new ComboBox<>();
			for (int a = 0; a < Logic.users.size(); a++) {
				comboUsers.getItems().add(Logic.users.get(a).getUsername());
			 }
			comboUsers.setPromptText("vyber");			
			Button B_editUser = new Button("edit");
			B_editUser.setOnAction(e -> {
				//keby nevybere nic a klika
				if ( !(comboUsers.getValue()==null) ) {
					EditUserUI.show(title, Logic.findByUsername(comboUsers.getValue().toString()));
				}				
			});
			
			vboxRight.getChildren().add(L_admin);
			vboxRight.getChildren().add(B_globalMessage);
			vboxRight.getChildren().add(B_addUser);
			vboxRight.getChildren().add(L_edit);
			vboxRight.getChildren().add(comboUsers);
			vboxRight.getChildren().add(B_editUser);
			
			border.setRight(vboxRight);
		}
			
		Scene scene = new Scene(border, 350, 400);
		
		window.setTitle(title);
		window.setScene(scene);		
		window.show();	
	}

}
