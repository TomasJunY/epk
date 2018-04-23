package UI;

import epk.Logic;
import users.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import message.ManualTimeMessage;

/**
 * <b>DashboardUI</b> <br>
 * 
 * This UI is for dashboard
 * 
 * @author Tomas Junas
 * @version 1.0
 */
public class DashboardUI {
	
	/**
	 * Shows window 
	 * 
	 * @param title title of the window
	 */
	public static void show(String title) {
		
		Stage window = new Stage();	
		
		HBox hboxTop = new HBox();
		hboxTop.setSpacing(8);
		hboxTop.setPadding(new Insets(15, 12, 15, 12));
		hboxTop.setStyle("-fx-background-color: #0099ff;");
		
		HBox hboxCenter = new HBox();
		hboxCenter.setSpacing(8);
		hboxCenter.setPadding(new Insets(15, 12, 15, 12));
		
		HBox hboxCenter2 = new HBox();
		hboxCenter2.setSpacing(8);
		hboxCenter2.setPadding(new Insets(15, 12, 15, 12));
		
		HBox hboxMessage = new HBox();
		hboxMessage.setSpacing(8);
		hboxMessage.setPadding(new Insets(15, 12, 15, 12));
		
		VBox vboxCenter = new VBox();
		
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
		
		Label L_userWelcome = new Label("Si prihl·sen˝ ako: ");
		String userWelcomeMessage = Logic.loggedUser.getName() + " " + Logic.loggedUser.getSurname();
		Label L_userName = new Label(userWelcomeMessage);
		
		//zobraz message
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
						
		Button B_userInfo = new Button("Inform·cie");
		B_userInfo.setPrefWidth(80);
		B_userInfo.setOnAction(e -> {
			UserInfoUI.show(userWelcomeMessage);
		});
		
		Button B_logOff = new Button("Odhl·siù sa");
		B_logOff.setPrefWidth(80);
		B_logOff.setOnAction(e -> {
			if ( Logic.userLogoff() == true ) {
				//odhlas
				LoginUI.show("login");
				window.close();
			}
			else {
				AlertUI.show("Chyba", "Nepodarilo sa odhl·siù", 200, 100);
			}
		});
		
		Label L_courses = new Label("Kurzy:");
			
		ComboBox comboCourses = new ComboBox<>();
		for (int a = 0; a < Logic.loggedUser.getCourseLength(); a++) {			
			if (Logic.loggedUser.getCourse(a).isNotFinished()) {
				comboCourses.getItems().add(Logic.loggedUser.getCourse(a).getName());
			}
		 }
		comboCourses.setPromptText("vyber si kurz");
		
		Button B_Course = new Button("OK");
		B_Course.setOnAction(e -> {
			if (comboCourses.getValue()==null) {
				System.out.println("chyba");
			}
			else {
				String selectedCName = (String) comboCourses.getValue();
				int pos = Logic.loggedUser.getCourseIndex(selectedCName);		
				//load max point
				Logic.saveMaxPoints(pos);
				CourseUI.show(selectedCName, (String) comboCourses.getValue(), pos);
				window.close();
			}					
		});
		
		hboxTop.getChildren().add(L_userWelcome);
		hboxTop.getChildren().add(L_userName);	
		
		
		Label L_coursesFinished = new Label("HotovÈ:");
		
		ComboBox comboCoursesFinished = new ComboBox<>();
		for (int a = 0; a < Logic.loggedUser.getCourseLength(); a++) {			
			if (Logic.loggedUser.getCourse(a).isFinished()) {
				comboCoursesFinished.getItems().add(Logic.loggedUser.getCourse(a).getName());
			}
		 }
		comboCoursesFinished.setPromptText("vyber si kurz");
		
		Button B_CourseFinished = new Button("OK");
		B_CourseFinished.setOnAction(e -> {
			if (comboCoursesFinished.getValue()==null) {
				System.out.println("chyba");
			}
			else {
				String selectedCName = (String) comboCoursesFinished.getValue();
				int pos = Logic.loggedUser.getCourseIndex(selectedCName);
				//load max point
				Logic.saveMaxPoints(pos);
				Logic.saveAchievedPoints(pos);
				CourseUI.show(selectedCName, (String) comboCoursesFinished.getValue(), pos);
				
				window.close();
			}					
		});
		
		hboxCenter.getChildren().add(L_courses);
		hboxCenter.getChildren().add(comboCourses);
		hboxCenter.getChildren().add(B_Course);
		
		hboxCenter2.getChildren().add(L_coursesFinished);
		hboxCenter2.getChildren().add(comboCoursesFinished);
		hboxCenter2.getChildren().add(B_CourseFinished);
		
		if (Logic.loggedUser.getGlobalMessage().isNotSeen()) {
			vboxCenter.getChildren().add(hboxMessage);
		}
		
		vboxCenter.getChildren().add(hboxCenter);
		vboxCenter.getChildren().add(hboxCenter2);
		
		hboxBotton.getChildren().add(B_userInfo);
		hboxBotton.getChildren().add(B_logOff);
		
		BorderPane border = new BorderPane();
		border.setTop(hboxTop);
		border.setBottom(hboxBotton);
		border.setCenter(vboxCenter);
		
		//admin veci
		if(Administrator.class.isInstance(Logic.loggedUser)) {
			Label L_admin = new Label("N·stroje na spr·vu");
			
			Button B_globalMessage = new Button("Ozn·menie");
			B_globalMessage.setOnAction(e -> {
				GlobalMessageUI.show("Nastav spr·vu");
			});
			
			Button B_addUser = new Button("Pridaj usera");
			B_addUser.setOnAction(e -> {
				AddUserUI.show("Pridaj usera");
			});
			
			Label L_edit = new Label("Edituj usera");
					
			ComboBox comboUsers = new ComboBox<>();
			for (int a = 0; a < Logic.users.size(); a++) {
				comboUsers.getItems().add(Logic.users.get(a).getUsername());
			 }
			comboUsers.setPromptText("vyber");			
			Button B_editUser = new Button("Edit");
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
			
		Scene scene = new Scene(border, 400, 400);
		
		window.setTitle(title);
		window.setScene(scene);		
		window.show();	
	}

}
