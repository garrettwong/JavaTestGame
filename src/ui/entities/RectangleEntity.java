package ui.entities;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class RectangleEntity {
	private String word;
	private int x;
	private EventHandler<MouseEvent> eventHandler;

	public RectangleEntity(String name) {
		this.word = name;
	}

	public RectangleEntity(String name, EventHandler<MouseEvent> eventHandler) {
		this.word = name;
		this.eventHandler = eventHandler;
	}

	// public Circle getRectangleNode() {
	// Circle circle = new Circle(100, 150, 20);
	//
	// circle.setFill(Color.SILVER);
	// circle.setStroke(Color.DARKCYAN);
	// circle.setStrokeWidth(10);
	//
	// circle.addEventHandler(MouseEvent.MOUSE_CLICKED, new
	// EventHandler<MouseEvent>() {
	// @Override
	// public void handle(MouseEvent event) {
	// System.out.println("Clicked: " + word + " " + event.getSceneX() + ", " +
	// event.getSceneY());
	//
	// // can we handle the event here?
	//
	// }
	// });
	//
	// return circle;
	// }
	public Rectangle getRectangleNode2(int x) {
		this.x = x;
		Rectangle rect = new Rectangle(x, 400, 50, 40);

		rect.setFill(Color.ALICEBLUE);
		rect.setStroke(Color.LIGHTSTEELBLUE);
		rect.setStrokeWidth(5);

		rect.addEventHandler(MouseEvent.MOUSE_CLICKED, this.eventHandler);

		return rect;
	}

	public String getWord() {
		return this.word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public void setEventHandler(EventHandler<MouseEvent> eventHandler) {
		this.eventHandler = eventHandler;
	}


	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillText(word, x, 390);
	}
}
