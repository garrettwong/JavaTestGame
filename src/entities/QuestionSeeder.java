package entities;

public class QuestionSeeder {

	private ColorService colorService;
	
	public QuestionSeeder() {
		colorService = new ColorService();
	}

	public QuestionCollection getQuestions(int num) {
		QuestionCollection questionCollection = new QuestionCollection();

		String[] words = new String[] { "apple", "banana", "orange", "grape", "fish" };
		String[][] answers = new String[][] { { "red", "orange", "green", "yellow" },
				{ "red", "orange", "green", "yellow" }, { "red", "orange", "green", "yellow" },
				{ "red", "green", "purple", "orange" }, { "blue", "black", "green", "purple" } };
		int[] answerIndices = new int[] { 0, 3, 1, 2, 1 };

		// constants
		final int width = 500;
		int height = 75;
		int margin = 10;
		int elementWidth = width/num;

		for (int i = 0; i < num; i++) {
			int x = (i * (elementWidth)) + margin * i;
			int y = height;
			int size = elementWidth;
			javafx.scene.paint.Color color = colorService.getColor(i % 4 + 1);

			questionCollection.addQuestion(new Question(words[i % words.length], answers[i % answers.length],
					answerIndices[i % answerIndices.length], x, y,size, color));
		}

		return questionCollection;
	}
}
