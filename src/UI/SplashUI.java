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

import java.util.concurrent.TimeUnit;
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
		layout.setBackground(null);
		
		//Image splashImage = new Image(getClass().getResourceAsStream("splash.png"));
		Image splashImage = new Image("file:images/splash.png");
		
		layout.getChildren().add(new ImageView(splashImage));
		
		Scene scene = new Scene(layout, Color.TRANSPARENT);
		
		window.setTitle("epk");
		window.initStyle(StageStyle.TRANSPARENT);
		window.setScene(scene);		
		window.show();
		
		//load udajov a zmena sceny
		PauseTransition pause = new PauseTransition();
		pause.setDuration(Duration.seconds(3));
		pause.setOnFinished(e -> {
			//load
			
			//
			LoginUI.show("login");
			window.close();
			} );
		pause.play();
	}
	
}