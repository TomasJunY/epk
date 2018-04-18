package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.FileNotFoundException;
import epk.Logic;
import javafx.animation.*;
import java.util.Random;

/**
 * <b>SplashUI</b> <br>
 * 
 * This UI is for splash screen + threads and exception
 * 
 * @author Tomas Junas
 * @version 1.0
 */
public class SplashUI extends Application {
	
	/**
	 * Launches the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Main thread - loads users
	 * 
	 * @author Tomas Junas
	 * @version 1.0
	 */
	class MainThread implements Runnable {
		
		/**
		 * Name of the thread
		 */
		String name = null;
		
		/**
		 * Constructor
		 * 
		 * @param name name of the thread
		 */
		public MainThread (String name) {
			this.name = name;
		}
		
		/**
		 * loads users
		 */
		public void run () {
			Logic.loadUsersFileToArray();
		}
	}
	
	/**
	 * Secondary thread - counts factorial
	 * 
	 * @author Tomas Junas
	 * @version 1.0
	 */
	class SecondaryThread implements Runnable {
		
		/**
		 * Custom Exception - prints error message and stack trace
		 * 
		 * @author Tomas
		 * @version 1.0
		 */
		class ZleRata extends Exception {
			
			/**
			 * Constuctor
			 * 
			 * @param message error message
			 */
			ZleRata(String message) {
				super(message);
				this.printStackTrace();
			}
		}
			
		/**
		 * Name of the thread
		 */
		String name = null;
		
		/**
		 * Constructor
		 * 
		 * @param name name of the thread
		 */
		public SecondaryThread (String name) {
			this.name = name;
		}
		
		/**
		 * counts factorial
		 */
		public void run () {
			try {
				Random random = new Random();
				faktorial(random.nextInt(20)+1);
			}
			catch(Exception ex) {
				System.out.println(ex);
			}				
		}
		
		/**
		 * counts factorial recursively
		 *
		 * @param n number
		 * @return factorial
		 */
		long fakt(long n) {
			if (n <=0) {
				return 1;
			} 
			else {
				return n * fakt(n-1);
			}
		}
		
		/**
		 * counts factorial recursively
		 *
		 * @param n number
		 * @throws ZleRata Custom Exception
		 */
		void faktorial(long n) throws ZleRata {
						
			long faktFor = 1; 
			for (int a = 1; a <= n; a++) {
				faktFor *= a;
			}

			long faktRek = fakt(n);
			
			if (faktFor != faktRek) {
				throw new ZleRata("Zle to pocita");
			}
		}
	}
	
	/**
	 * Shows window
	 */
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
				
		
		new Thread(new MainThread("jozko")).start();
		//vytvor 40 kde rataj fakorial
		for (int a = 0; a < 40; a++) {
			new Thread(new SecondaryThread("ferko " + a)).start();
		}		
		
		//zmena sceny
		PauseTransition pause = new PauseTransition();
		pause.setDuration(Duration.seconds(0));
		pause.setOnFinished(e -> {
			LoginUI.show("Login");			
			window.close();
			} );
		pause.play();
	}
	
}
