package application;

import java.util.List;

import entities.Question;
import entities.QuestionCollection;
import entities.QuestionSeeder;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import ui.entities.NextButton;
import ui.entities.RectangleEntity;
import ui.entities.ScoreButton;

public class QuestionGame {
	private QuestionSeeder questionSeeder;

	private QuestionCollection questions;
	private Question currentQuestion;
	private int currentQuestionIndex;
	private int score;

	// renderers
	private int height = 500;
	private int width = 500;
	private Timeline gameloop;
	private Group root;
	private GraphicsContext graphicsContext;

	private NextButton[] clickableButtons;
	private ScoreButton scoreButton;

	// setup
	public QuestionGame() {

	}

	// CLICK EVENT: on answer submit
	public void onAnswerSubmit(String answer) {
		System.out.println("Answer: " + answer);
		System.out.println("Answer: " + currentQuestion.getQuestion());
		System.out.println("Answer: " + currentQuestion.isCorrect(answer));
		System.out.println("Answer: " + score);
		
		if (currentQuestion.isCorrect(answer)) {
			// correct
			score += 100;

		} else {
			// incorrect
			score -= 50;

		}

		// get next answer
		getNextQuestion();

		draw(questions.getAll());
	}

	private void getNextQuestion() {
		currentQuestionIndex++;
		if (currentQuestionIndex >= questions.getTotalNumberOfQuestions()) {
			currentQuestionIndex = 0;
		}

		currentQuestion = questions.getQuestion(currentQuestionIndex);
	}

	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Synonym Hunter");

			root = new Group();
			Canvas canvas = new Canvas(width, height);
			this.graphicsContext = canvas.getGraphicsContext2D();

			root.getChildren().add(canvas);

			// setup questions
			questionSeeder = new QuestionSeeder();
			questions = questionSeeder.getQuestions(10);

			currentQuestionIndex = 0;
			currentQuestion = questions.getQuestion(currentQuestionIndex);

			score = 0;

			clickableButtons = new NextButton[] { new NextButton(100, 300, 50, Color.GREEN, "Option 1"),
					new NextButton(200, 300, 50, Color.YELLOW, "Option 2"),
					new NextButton(300, 300, 50, Color.RED, "Option 3"),
					new NextButton(400, 300, 50, Color.ORANGE, "Option 4"), };

			scoreButton = new ScoreButton(400, 0, 50, Color.ALICEBLUE, score);

			// add rectangles
			Rectangle[] rects = new Rectangle[4];
			String[] answers = currentQuestion.getAnswers();
			for (int i = 0; i < answers.length; i++) {

				RectangleEntity re = new RectangleEntity(answers[i]);
				EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						System.out.println("Rectangle Clicked: " + re.getWord());
					
						
						// set answer in QuestionGame class
						// get word from Rectangle class
						// 
						String answer = re.getWord();
						onAnswerSubmit(answer);
					}
				};
				re.setEventHandler(eventHandler);

				rects[i] = re.getRectangleNode2(i * 100);
				root.getChildren().addAll(rects[i]);
				re.draw(graphicsContext);
			}

			Scene scene = new Scene(root);

			// add yellow circle
//			scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//				// could technically get x and y coordinates and find which
//				// element was clicked...
//				// there should be an easier way...
//				@Override
//				public void handle(MouseEvent event) {
//					String answer = "red";
//					onAnswerSubmit(answer);
//				}
//			});

			primaryStage.setScene(scene);
			primaryStage.show();

			buildAndSetGameLoop();

			gameloop.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void draw(List<Question> questions) {
		for (Question s : questions) {
			s.draw(this.graphicsContext);
		}

		for (NextButton btn : clickableButtons) {
			btn.draw(graphicsContext);
		}

		scoreButton.draw(this.graphicsContext);

		scoreButton.setScore(score);

		String q = currentQuestion.getQuestion();
		TextField tf = new TextField();
		tf.setText(q);

		root.getChildren().add(tf);
	}

	protected final void buildAndSetGameLoop() {
		final Duration oneFrameAmt = Duration.millis(1000 / (float) getFramesPerSecond());
		final KeyFrame oneFrame = new KeyFrame(oneFrameAmt, new EventHandler<ActionEvent>() {
			@Override
			public void handle(javafx.event.ActionEvent event) {
				// update actors
				updateSprites();
			}

			// adjust and redraw all questions
			private void updateSprites() {
				List<Question> qs = questions.getAll();
				for (int i = 0; i < qs.size(); i++) {
					Question q = qs.get(i);

					q.setX(q.getX() + 1);

					if (q.getX() > 500) {
						q.setX(0);
					}
				}

				// add all:
				// http://stackoverflow.com/questions/24302636/better-way-for-getting-id-of-the-clicked-object-in-javafx-controller
				CheckBox checkBox = new CheckBox();
				checkBox.setId("CBX1");
				checkBox.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

				CheckBox checkBox2 = new CheckBox();
				checkBox2.setId("CBX2");
				checkBox2.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

				root.getChildren().addAll(checkBox, checkBox2);

				draw(qs);
			}

		}); // oneFrame

		// sets the game world's game loop (Timeline)
		setGameLoop(TimelineBuilder.create().cycleCount(Animation.INDEFINITE).keyFrames(oneFrame).build());
	}

	protected void setGameLoop(Timeline gameLoop) {
		this.gameloop = gameLoop;
	}

	private float getFramesPerSecond() {
		return 30f;
	}

	private class MyEventHandler implements EventHandler<Event> {
		@Override
		public void handle(Event evt) {
			System.out.println("ID: " + ((Control) evt.getSource()).getId());
		}
	}

}
