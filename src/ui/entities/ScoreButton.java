package ui.entities;

import interfaces.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ScoreButton extends Sprite
{
	private int x;
	private int y;
	private final int width; 
	private int height;
	private Color color;
	private double score;
	
	public ScoreButton(int x, int y, int size, Color color, double score)
	{
		this.x = x;
		this.y = y; 
		this.width = size; 
		this.height = size;
		this.color = color;
		this.score = score;
	}

	public void draw(GraphicsContext gc)
	{
		gc.setFill(color);
		gc.fillRect(x,  y,  width, height);

		gc.setFill(Color.BLACK);
		gc.fillText(String.valueOf((int)score), x + width/3, y + height*3/5);
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setScore(double score) {
		this.score = score;
	}

}
