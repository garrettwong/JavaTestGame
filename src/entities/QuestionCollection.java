package entities;

import java.util.ArrayList;
import java.util.List;

public class QuestionCollection {
	private List<Question> questions;
	
	public QuestionCollection() {
		this.questions = new ArrayList<Question>();
	}

	public QuestionCollection(List<Question> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(Question newQuestion) {
		questions.add(newQuestion);
	}
	
	public Question getQuestion(int index) {
		return questions.get(index);
	}
	
	public int getTotalNumberOfQuestions() {
		return questions.size();
	}

	public List<Question> getAll() {
		// TODO Auto-generated method stub
		return questions;
	}
}
