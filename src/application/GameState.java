package application;

public class GameState {
	
	private int score;
	
	public GameState() {
		this.score = 0;
	}
	
	public void updateScore() {
		score += 100;
	}
	
	public int getScore () {
		return this.score;
	}
	
	
	

}
