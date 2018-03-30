package UI;

import java.util.ArrayList;

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

public class CourseUI {
	
	public static void show(String title, String course_name, int position) {
		
		Stage window = new Stage();	
		
		VBox vbox = new VBox();
		vbox.setSpacing(8);
		vbox.setPadding(new Insets(15, 12, 15, 12));
		
		Label L_cName = new Label(course_name);
		
		TextArea M_cText = new TextArea();
		M_cText.setText(Logic.loggedUser.getCourse(position).getText() + " \ndosiahol si: " + Logic.loggedUser.getCourse(position).getTest().getAchievedPoints()+ " bodov");
		M_cText.setEditable(false);
		M_cText.setWrapText(true);
		M_cText.setPrefHeight(200);
		//System.out.println("heehxd" +Logic.loggedUser.getCourse(position).getTest().getMaxPoints());
		
		vbox.getChildren().add(L_cName);
		vbox.getChildren().add(M_cText);
		
		ArrayList<Hyperlink > links = new ArrayList<Hyperlink >();
		for (int a = 0; a < Logic.loggedUser.getCourse(position).getFileLength(); a++) {
			//rob
			Hyperlink link = new Hyperlink();
			link.setText(Logic.loggedUser.getCourse(position).getFile(a).getName());
			link.setOnAction(e ->{
				//
				Logic.openFileOnDisk(link.getText());
			});
			links.add(link);			 
			vbox.getChildren().add(link);
		}

		Button B_test = new Button("Test");
		B_test.setPrefWidth(80);
		B_test.setOnAction(e -> {
			//
			TestUI.show(title, course_name, position);
			window.close();
		});
		
		vbox.getChildren().add(B_test);
		
		Button B_back = new Button("Back");
		B_back.setOnAction(e -> {
			//
			DashboardUI.show("dashboard");
			window.close();
		});
		
		vbox.getChildren().add(B_back);
		
		Scene scene = new Scene(vbox, 800, 600);
		
		window.setTitle(title);
		window.setScene(scene);		
		window.show();	
	}

}
