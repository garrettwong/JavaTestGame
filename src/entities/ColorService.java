package entities;

import javafx.scene.paint.Color;

public class ColorService {

	public javafx.scene.paint.Color getColor(int i) {
		switch(i) {
		case 1: 
			return javafx.scene.paint.Color.CORNFLOWERBLUE;
		case 2: 
			return javafx.scene.paint.Color.DARKRED;
		case 3: 
			return javafx.scene.paint.Color.CADETBLUE;
		case 4:
			return javafx.scene.paint.Color.GRAY;
		default:
			return javafx.scene.paint.Color.BLACK;
		}
	}
}
