package UI;

import java.text.ParseException;
import epk.Logic;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * <b>LoginUI</b> <br>
 * 
 * This UI is for login
 * 
 * @author Tomas Junas
 * @version 1.0
 */
public class LoginUI {

	/**
	 * Shows window 
	 * 
	 * @param title title of the window
	 */
	public static void show(String title) {
		Stage window = new Stage();		
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(15);
		
		Label L_username = new Label("username");
		GridPane.setConstraints(L_username, 0, 0);
		
		TextField E_username = new TextField();
		GridPane.setConstraints(E_username, 1, 0);
		
		Label L_password = new Label("heslo");
		GridPane.setConstraints(L_password, 0, 1);
		
		PasswordField E_password = new PasswordField();
		GridPane.setConstraints(E_password, 1, 1);
					
		Button B_login = new Button("Login");
		GridPane.setConstraints(B_login, 1, 2);
		B_login.setPrefWidth(150);
		B_login.setOnAction(e -> {
			try {
				if ( Logic.userLogin( E_username.getText(), E_password.getText() ) == true ) {
					//load course
					Logic.loadCoursesList();
					DashboardUI.show("Dashboard");
					window.close();
				}
				else {
					AlertUI.show("Chyba", "Zlé meno alebo heslo", 200, 100);
				}
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		grid.getChildren().add(L_username);
		grid.getChildren().add(E_username);
		grid.getChildren().add(L_password);
		grid.getChildren().add(E_password);
		grid.getChildren().add(B_login);
		
		Scene scene = new Scene(grid, 250, 150);
		
		window.setTitle(title);
		window.setScene(scene);	
		window.show();		
	 }

}
