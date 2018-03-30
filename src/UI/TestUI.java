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

public class TestUI {
	
	public static void show(String title, String course_name, int position) {
		
		Stage window = new Stage();	
				
		VBox vbox = new VBox();
		vbox.setSpacing(8);
		vbox.setPadding(new Insets(15, 25, 15, 25));
		
		Label L_TName = new Label(Logic.loggedUser.getCourse(position).getTest().getName());
		
		TextArea M_TText = new TextArea();
		M_TText.setText(Logic.loggedUser.getCourse(position).getTest().getText());
		M_TText.setEditable(false);
		M_TText.setWrapText(true);
		M_TText.setPrefHeight(70);
		M_TText.setMaxWidth(300);

		vbox.getChildren().add(L_TName);
		vbox.getChildren().add(M_TText);
		
		ArrayList<Label> Qnames = new ArrayList<Label>();
		ArrayList<Label> Qtexts = new ArrayList<Label>();
		ArrayList<ComboBox> Qcombos = new ArrayList<ComboBox>();
		
		for (int a = 0; a < Logic.loggedUser.getCourse(position).getTest().getQuestionsLength(); a++) {
			//rob
			Label Qname = new Label();			
			Qname.setText(Logic.loggedUser.getCourse(position).getTest().getQuestion(a).getName());
			Qnames.add(Qname);
			Label Qtext = new Label();
			Qtext.setText(Logic.loggedUser.getCourse(position).getTest().getQuestion(a).getText());
			Qtexts.add(Qtext);
			ComboBox Qcombo = new ComboBox();
			Qcombo.setMaxWidth(300);
			Qcombos.add(Qcombo);
			for (int b = 0; b < Logic.loggedUser.getCourse(position).getTest().getQuestion(a).getOptionsLength(); b++) {
				//
				Qcombo.getItems().add(Logic.loggedUser.getCourse(position).getTest().getQuestion(a).getOption(b).getText());
			}
			Qcombo.setPromptText("vyber si moznost");
			vbox.getChildren().add(Qname);
			vbox.getChildren().add(Qtext);
			vbox.getChildren().add(Qcombo);
		}
		
		Button B_done = new Button("Test");
		B_done.setPrefWidth(80);
		B_done.setOnAction(e -> {
			//
			CourseUI.show(title, course_name, position);
			window.close();
		});
		
		vbox.getChildren().add(B_done);
		
		Button B_back = new Button("Back");
		B_back.setOnAction(e -> {
			//
			CourseUI.show(title, course_name, position);
			window.close();
		});
		
		vbox.getChildren().add(B_back);
		
		Scene scene = new Scene(vbox, 600, 800);
		
		window.setX(600);
		window.setY(50);
		window.setWidth(350);
		window.setTitle(title);
		window.setScene(scene);		
		window.show();	
	}

}