package ui.entities;

import interfaces.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public int getSize() {
		return size;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	
}
