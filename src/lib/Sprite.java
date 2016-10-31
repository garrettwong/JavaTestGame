package lib;

import javafx.scene.canvas.GraphicsContext;

public abstract class Sprite {
	public Sprite() {
		
	}
	
	public abstract void draw(GraphicsContext gc);
	
	public abstract boolean isAlive();
}
