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

//import java.util.concurrent.TimeUnit;

import epk.Logic;
import javafx.animation.*;

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
		
		//nite
		class MainThread implements Runnable {
			int index = 0;
			
			//konstruktor index=cislo nite
			public MainThread (int index) {
				this.index = index;
			}
			
			public void run () {
				for (int a = 0 ; a < 5; a++) {
					System.out.println ( "main: " + index + " : " + a);
				}
			}
		}
		class SecondaryThread implements Runnable {
			int index = 0;
			
			//konstruktor index=cislo nite
			public SecondaryThread (int index) {
				this.index = index;
			}
			
			public void run () {
				for (int a = 0 ; a < 5; a++) {
					System.out.println ( "secondary: " + index + " : " + a);
				}
			}
		}
		//nite konec
		//new Thread(new HlavnaNit(0)).start();
		
		for (int a = 0 ; a < 2; a++) {
			new Thread(new MainThread(a)).start();
			new Thread(new SecondaryThread(a)).start();
		}
		//load udajov a zmena sceny
		PauseTransition pause = new PauseTransition();
		pause.setDuration(Duration.seconds(0));
		pause.setOnFinished(e -> {
			//load
			Logic.loadUsersFileToArray();
			LoginUI.show("login");			
			window.close();
			} );
		pause.play();
	}
	
}
