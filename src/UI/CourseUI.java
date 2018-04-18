package UI;

import java.util.ArrayList;
import epk.Logic;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * <b>CourseUI</b> <br>
 * 
 * This UI is for Course
 * 
 * @author Tomas Junas
 * @version 1.0
 */
public class CourseUI {
	
	/**
	 * Shows window
	 * 
	 * @param title title of the window
	 * @param course_name name of the course
	 * @param position position in array of courses
	 */
	public static void show(String title, String course_name, int position) {
		
		Stage window = new Stage();	
		
		VBox vbox = new VBox();
		vbox.setSpacing(8);
		vbox.setPadding(new Insets(15, 12, 15, 12));
		
		Label L_cName = new Label(course_name);
		
		TextArea M_cText = new TextArea();
		M_cText.setText(Logic.loggedUser.getCourse(position).getText() + " \ndosiahol si: " + Logic.loggedUser.getCourse(position).getTest().getAchievedPoints()+ " bodov" + " zo: " + Logic.loggedUser.getCourse(position).getTest().getMaxPoints()+ " bodov");
		M_cText.setEditable(false);
		M_cText.setWrapText(true);
		M_cText.setPrefHeight(200);
		
		Label L_cLinks = new Label("Linky:");
		
		vbox.getChildren().add(L_cName);
		vbox.getChildren().add(M_cText);
		vbox.getChildren().add(L_cLinks);
		
		ArrayList<Hyperlink > links = new ArrayList<Hyperlink >();
		for (int a = 0; a < Logic.loggedUser.getCourse(position).getFileLength(); a++) {
			Hyperlink link = new Hyperlink();
			link.setText(Logic.loggedUser.getCourse(position).getFile(a).getName());
			link.setOnAction(e ->{
				Logic.openFileOnDisk(link.getText(), position);
			});
			links.add(link);			 
			vbox.getChildren().add(link);
		}

		Button B_test = new Button("Test");
		B_test.setPrefWidth(80);	
		B_test.setOnAction(e -> {
			TestUI.show(title, course_name, position);
			window.close();
		});
		
		vbox.getChildren().add(B_test);
		
		Button B_back = new Button("Back");
		B_back.setOnAction(e -> {
			DashboardUI.show("Dashboard");
			window.close();
		});
		
		vbox.getChildren().add(B_back);
		
		Scene scene = new Scene(vbox, 800, 600);
		
		window.setTitle(title);
		window.setScene(scene);		
		window.show();	
	}

}
