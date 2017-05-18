package ui.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lib.Sprite;

public class FlashCard extends Sprite
{
	private int x;
	private int y;
	private final int size; 
	private Color color;
	private boolean alive;
	private String text;
	private String[] answers;
	
	public FlashCard(int x, int y, int size, Color color, String word, String[] answers)
	{
		this.x = x; 
		this.y = y; 
		this.size = size; 
		this.color = color;
		this.text = word;
		this.answers = answers;
		
//		scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
//		    @Override
//		    public void handle(MouseEvent mouseEvent) {
//		        System.out.println("mouse click detected! " + mouseEvent.getSource());
//		    }
//		});
	}

	public void draw(GraphicsContext gc)
	{
		gc.setFill(color);
		gc.fillRect(x,  y,  size,  size);

		gc.setFill(Color.BLACK);
		gc.fillText(text, x + 10, y + size/2);
	}
	
	public boolean checkHit()
	{ 
		System.out.println("Building.checkHit not implemented. Returning false"); 
		return false;
	}
	
	public int getX()
	{ 
		return x;
	}
	
	public int getY()
	{ 
		return y; 
	}
	
	public int getSize()
	{ 
		return size; 
	}
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
