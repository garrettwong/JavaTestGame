package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lib.Sprite;

public class Building extends Sprite
{
	private int x;
	private int y;
	private int size; 
	private int color;
	private boolean alive;
	
	public Building(int x, int y, int size, int color)
	{
		this.x = x; 
		this.y = y; 
		this.size = size; 
		this.color = color; 
	}

	public void draw(GraphicsContext gc)
	{
		if(color == 1)
		{
			gc.setFill(Color.GRAY);
			gc.fillRect(x-size/2, y-size/2, size, size); 
			gc.setFill(Color.DARKGRAY); 
			gc.fillRect(x-size/4+4, y-size/1+0.5, size/3.03, size/2.03); 
		} 
		
		if(color == 2)
		{ 
			gc.setFill(Color.BLACK);
			gc.fillRect(x-size/2, y-size/2, size, size); 
			gc.setFill(Color.BLACK); 
			gc.fillRect(x-size/4+4, y-size/1+0.5, size/3.03, size/2.03); 
		}
		
		if(color == 3)
		{ 
			gc.setFill(Color.DARKBLUE);
			gc.fillRect(x-size/2, y-size/2, size, size); 
			gc.setFill(Color.BLUE); 
			gc.fillRect(x-size/4+4, y-size/1+0.5, size/3.03, size/2.03); 
		}
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
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
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

	public void setSize(int size) {
		this.size = size;
	}
}
