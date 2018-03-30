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
import epk.Logic;
import javafx.animation.*;

//import java.util.concurrent.TimeUnit;

public class SplashUI extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		Stage window = primaryStage;
		
		Pane layout = new Pane();
		layout.setPrefSize(400, 233);
		//layout.setPrefSize(500, 500);
		layout.setBackground(null);
		
		//Image splashImage = new Image(getClass().getResourceAsStream("splash.png"));
		Image splashImage = new Image("file:data/images/splash.png");
		//Image splashImage = new Image("http://i.imgur.com/yBPMiCp.gif");
		layout.getChildren().add(new ImageView(splashImage));
		
		Scene scene = new Scene(layout, Color.TRANSPARENT);
		
		window.setTitle("epk");
		window.initStyle(StageStyle.TRANSPARENT);
		window.setScene(scene);		
		window.show();
		
		//threads		
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
			
			String name = null;
			
			//konstruktor
			public SecondaryThread (String name) {
				this.name = name;
			}
			//vedlajsia vec - sucet cisiel od 1 po 1 000
			public void run () {
				int sum = 0;
				for (int a = 1 ; a <= 1000; a++) {
					sum += a;
				}
				//System.out.println(sum);
			}
		}
		
		//threads
		new Thread(new MainThread("jozko")).start();
		new Thread(new SecondaryThread("ferko")).start();
		
		//load udajov a zmena sceny
		PauseTransition pause = new PauseTransition();
		pause.setDuration(Duration.seconds(0));
		pause.setOnFinished(e -> {
			//load
			//Logic.loadUsersFileToArray();
			LoginUI.show("login");			
			window.close();
			} );
		pause.play();
	}
	
}
