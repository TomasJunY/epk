package UI;

import java.util.ArrayList;
import epk.Logic;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * <b>TestUI</b> <br>
 * 
 * This UI is for Test
 * 
 * @author Tomas Junas
 * @version 1.0
 */
public class TestUI {
	
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
		vbox.setPadding(new Insets(15, 25, 15, 25));
		
		Label L_TName = new Label(Logic.loggedUser.getCourse(position).getTest().getName());
		
		TextArea M_TText = new TextArea();
		M_TText.setText(Logic.loggedUser.getCourse(position).getTest().getText()  + "\nmaxim�lny po�et bodov je: " + (Logic.loggedUser.getCourse(position).getTest().getMaxPoints()));
		M_TText.setEditable(false);
		M_TText.setWrapText(true);
		M_TText.setPrefHeight(70);
		M_TText.setMaxWidth(300);

		vbox.getChildren().add(L_TName);
		vbox.getChildren().add(M_TText);
		
		ArrayList<Label> Qnames = new ArrayList<Label>();
		ArrayList<Label> Qtexts = new ArrayList<Label>();
		ArrayList<Image> Qimages = new ArrayList<Image>();
		ArrayList<ComboBox> Qcombos = new ArrayList<ComboBox>();
		
		for (int a = 0; a < Logic.loggedUser.getCourse(position).getTest().getQuestionsLength(); a++) {
			//rob
			Label Qname = new Label();			
			Qname.setText(Logic.loggedUser.getCourse(position).getTest().getQuestion(a).getName());
			Qnames.add(Qname);
			Label Qtext = new Label();
			Qtext.setText(Logic.loggedUser.getCourse(position).getTest().getQuestion(a).getText());
			Qtexts.add(Qtext);
			
			vbox.getChildren().add(Qname);
			vbox.getChildren().add(Qtext);
			//img
			if (!Logic.loggedUser.getCourse(position).getTest().getQuestion(a).getImage().equals("$")) {
				Image Qimage = new Image("file:data/courses/" + Logic.loggedUser.getCourse(position).getName() + "/test/images/" + Logic.loggedUser.getCourse(position).getTest().getQuestion(a).getImage());
				Qimages.add(Qimage);
				vbox.getChildren().add(new ImageView(Qimage));
			}
					
			ComboBox Qcombo = new ComboBox();
			Qcombo.setMaxWidth(300);
			Qcombos.add(Qcombo);
			for (int b = 0; b < Logic.loggedUser.getCourse(position).getTest().getQuestion(a).getOptionsLength(); b++) {
				Qcombo.getItems().add(Logic.loggedUser.getCourse(position).getTest().getQuestion(a).getOption(b).getText());
				
				if(Logic.loggedUser.getCourse(position).getTest().getQuestion(a).getOption(b).getSelected()) {
					Qcombo.getSelectionModel().select(b);
				}
			}
			Qcombo.setPromptText("vyber si mo�nos�");
			
			vbox.getChildren().add(Qcombo);
		}
		
		Button B_done = new Button("Odovzdaj");
		B_done.setPrefWidth(120);
		if (Logic.loggedUser.getCourse(position).isFinished()) {
			B_done.setDisable(true);
			B_done.setText("Test je u� hotov�");
		}
		
		B_done.setOnAction(e -> {
			Logic.saveTestSelected(Qcombos, position);
			Logic.saveAchievedPoints(position);
			AlertUI.show("Koniec", "Dosiahol si " + Logic.loggedUser.getCourse(position).getTest().getAchievedPoints() + " bodov", 200, 100);
			Logic.loggedUser.getCourse(position).setFinished(true);
			Logic.writeCourseTest(position, Logic.loggedUser.getCourse(position).getName(), Logic.loggedUser.getUsername());
			//CourseUI.show(title, course_name, position);
			DashboardUI.show("Dashboard");
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
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(vbox);
		
		Scene scene = new Scene(scrollPane, 600, 900);
		
		window.setTitle(title);
		window.setScene(scene);		
		window.show();	
	}

}
