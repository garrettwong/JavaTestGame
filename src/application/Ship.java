package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import lib.Sprite;

public class Ship extends Sprite {

	private int x;
	private int y;
	private int size; 
	private int color;
	private boolean isAlive;
	
	public Ship(int x, int y)
	{
		this.x = x; 
		this.y = y; 
		this.size = 25; 
		this.color = 1;
		isAlive = true;
	}
	

	public void draw(GraphicsContext gc)
	{
		gc.setFill(Color.GREEN);
		

        gc.strokeOval(x, y, 30, 30);
		
        //gc.strokeArc(x/2-size, y/2-size, x/2-size, x/2-size, x/2-size, y*1.5, ArcType.CHORD);
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}


	@Override
	public boolean isAlive() {
		return isAlive;
	}
	
	
}
