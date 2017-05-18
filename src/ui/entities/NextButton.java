package ui.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lib.Sprite;

public class NextButton extends Sprite
{
	private int x;
	private int y;
	private final int width; 
	final int height = 50;
	
	private Color color;
	private String text;
	
	public NextButton(int x, int y, int size, Color color, String word)
	{
		this.x = x;
		this.y = y; 
		this.width = size; 
		this.color = color;
		this.text = word;
		
		
	}

	public void draw(GraphicsContext gc)
	{
		gc.setFill(color);
		gc.fillRect(x,  y,  width, height);

		gc.setFill(Color.BLACK);
		gc.fillText(text, x + height*3/5, y + height*3/5);
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

}
