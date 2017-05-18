package ui.entities;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleEntity {

	private String name;
	
	
	public RectangleEntity(String name) {
		this.name = name;
	}
	
	public Rectangle generate() {
		Rectangle rect = new Rectangle(50, 50, 200, 200);
		
        rect.setFill(Color.BLUE);
        rect.setStroke(Color.GOLDENROD);
        rect.setStrokeWidth(10);
        
        rect.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			// could technically get x and y coordinates and find which element was clicked...
			// there should be an easier way...
        	
			@Override
			public void handle(MouseEvent event) {
				System.out.println("Clicked: " + name + " " + event.getSceneX() + ", " + event.getSceneY());
				
				// what can we do here?
				
				// 
			}
		});
        return rect;
	}
	
}
