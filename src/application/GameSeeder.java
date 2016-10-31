package application;

import java.util.ArrayList;
import java.util.List;

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
		
		return ships;
	}
}
