package ui.entities;

import interfaces.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

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
		
		// set on clicker handler
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
