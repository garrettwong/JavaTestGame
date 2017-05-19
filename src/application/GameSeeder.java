package application;

import java.util.ArrayList;
import java.util.List;

import com.sun.prism.paint.Color;

import ui.entities.FlashCard;
import ui.entities.missile.Building;
import ui.entities.missile.Ship;

public class GameSeeder {

	public static List<Building> getBuildings(int width, int height) {
		List<Building> buildings = new ArrayList<Building>();
		
		buildings.add(new Building(width/4, height-25, 50, 1));
		buildings.add(new Building(width/4, height-25, 50, 1));
		buildings.add(new Building(width*3/4, height - 25, 50, 2));
		buildings.add(new Building(width*5/6, height-15, 50, 1));
		buildings.add(new Building(width/6, height-15, 50, 2));
		buildings.add(new Building(width/3, height-15, 50, 3));
		buildings.add(new Building(width*2/3, height-25, 50, 3));
		
		return buildings;
	}
	
	public static List<Ship> getShips(int width, int height) {
		List<Ship> ships = new ArrayList<Ship>();
		
		ships.add(new Ship(width/2, height/2));
		ships.add(new Ship(width/2, height/2));
		
		return ships;
	}
	
	public static List<FlashCard> getFlashCards(int num) {
		List<FlashCard> flashCards = new ArrayList<FlashCard>();
		
		// default settings
		final int width = 500;
		int height = 75;
		int margin = 10;
		int elementWidth = width/num;
		
		// default seed values
		String[] words = new String[] { "apple", "banana", "orange", "grape", "fish" };
		String[][] answers = new String[][] { 
			{ "red", "orange", "green", "yellow"},
			{ "red", "orange", "green", "yellow"},
			{ "red", "orange", "green", "yellow"},
			{ "red", "green", "purple", "orange"},
			{ "blue", "black", "green", "purple"}
		};
		
		for (int i = 0; i < num; i++) {
			int x = (i * (elementWidth)) + margin*i;
			int y = height;
			int size = elementWidth;
			javafx.scene.paint.Color color = getColor(i % 3 + 1);
			
			flashCards.add(new FlashCard(x, y, size, color, 
					words[i%answers.length],
					answers[i%answers.length]
			));
		}

		return flashCards;
	}

	private static javafx.scene.paint.Color getColor(int i) {
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
