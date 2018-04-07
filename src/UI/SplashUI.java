package UI;

import javafx.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.FileNotFoundException;
import epk.Logic;
import javafx.animation.*;

public class SplashUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		Stage window = primaryStage;
		
		Pane layout = new Pane();
		layout.setPrefSize(600, 400);
		layout.setBackground(null);
		
		Image splashImage = new Image("file:data/images/splash.png");

		layout.getChildren().add(new ImageView(splashImage));
		
		Scene scene = new Scene(layout, Color.TRANSPARENT);
		
		window.setTitle("epk");
		window.initStyle(StageStyle.TRANSPARENT);
		window.setScene(scene);		
		window.show();
				
		class MainThread implements Runnable {
			
			String name = null;
			
			//konstruktor
			public MainThread (String name) {
				this.name = name;
			}
			//hlavna vec - nacita userov
			public void run () {
				Logic.loadUsersFileToArray();
			}
		}
		
		class SecondaryThread implements Runnable {
			
			//vynimka
			class ZleRata extends Exception {
				ZleRata(String message) {
					super(message);
					this.printStackTrace();
				}
			}
 			
			String name = null;
			
			//konstruktor
			public SecondaryThread (String name) {
				this.name = name;
			}
			//vedlajsia vec - sucet cisiel od 1 po 1 000
			public void run () {
				try {
					rataj();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}				
			}
			
			int rataj() throws ZleRata {
				int sum = 0;
				for (int a = 1 ; a <= 1000; a++) {
					sum += a;
				}
				if (sum != 500500) {
					throw new ZleRata("zle to pocita");
				}
				return sum;
			}
		}
		
		new Thread(new MainThread("jozko")).start();
		//vytvor 10 kde rataj sucet
		for (int a = 0; a < 10; a++) {
			new Thread(new SecondaryThread("ferko " + a)).start();
		}		
		
		//load udajov a zmena sceny
		PauseTransition pause = new PauseTransition();
		pause.setDuration(Duration.seconds(0));
		pause.setOnFinished(e -> {
			LoginUI.show("login");			
			window.close();
			} );
		pause.play();
	}
	
}
