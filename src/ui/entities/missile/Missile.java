package ui.entities.missile;

import interfaces.Sprite;
import javafx.scene.canvas.GraphicsContext;

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
