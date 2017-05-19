package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			QuestionGame game = new QuestionGame();

			game.start(primaryStage);
			
		} catch (Exception ex) {

		}
	}

	/* MAIN */
	public static void main(String[] args) {
		launch(args);
	}
}
