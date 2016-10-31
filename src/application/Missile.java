package application;

import javafx.scene.canvas.GraphicsContext;
import lib.Sprite;

public class Missile extends Sprite {

	private boolean isAlive;
	
	public Missile() {
		isAlive = true;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return isAlive;
	}

}
