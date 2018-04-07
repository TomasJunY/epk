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
import java.util.Random;

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
			
			//vedlajsia vec - faktorial
			public void run () {
				try {
					Random random = new Random();
					faktorial(random.nextInt(20)+1);
				}
				catch(Exception ex) {
					System.out.println(ex);
				}				
			}
			
			long fakt(long n) {
				if (n <=0) {
					return 1;
				} 
				else {
					return n * fakt(n-1);
				}
			}
			
			void faktorial(long n) throws ZleRata {
							
				long faktFor = 1; 
				for (int a = 1; a <= n; a++) {
					faktFor *= a;
				}

				long faktRek = fakt(n);

				System.out.println("n: " + n +" for: " + faktFor + " rek: " + faktRek);
				
				if (faktFor != faktRek) {
					throw new ZleRata("zle to pocita");
				}
			}
		}
		
		new Thread(new MainThread("jozko")).start();
		//vytvor 40 kde rataj fakorial
		for (int a = 0; a < 40; a++) {
			new Thread(new SecondaryThread("ferko " + a)).start();
		}		
		
		//load udajov a zmena sceny
		PauseTransition pause = new PauseTransition();
		pause.setDuration(Duration.seconds(3));
		pause.setOnFinished(e -> {
			LoginUI.show("login");			
			window.close();
			} );
		pause.play();
	}
	
}
