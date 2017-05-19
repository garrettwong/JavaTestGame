package entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Question {
	private String question;
	private String[] answers;
	private int correctAnswerIndex;
	
	// draw props
	private int x;
	private int y;
	private int size; 
	private Color color;
	
	public Question(String question, String[] answers, int correctAnswerIndex, int x, int y, int size, Color color) {
		this.question = question;
		this.answers = answers;
		this.correctAnswerIndex = correctAnswerIndex;
		
		this.x = x; 
		this.y = y; 
		this.size = size; 
		this.color = color;
	}
	
	public boolean isCorrect(String answer) {
		return answers[correctAnswerIndex].equals(answer);
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}

	public void setCorrectAnswerIndex(int correctAnswerIndex) {
		this.correctAnswerIndex = correctAnswerIndex;
	}

	public void draw(GraphicsContext graphicsContext) {
		graphicsContext.setFill(color);
		graphicsContext.fillRect(x,  y,  size,  size);

		graphicsContext.setFill(Color.BLACK);
		graphicsContext.fillText(question, x + 10, y + size/2);
	}
	
	
}
