package q.com.google;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindWords extends Question {

	public String getQuestion() {
		return "Given a dictionary find all possible words in a give nxn matrix. You can go up, left, down, and right. ";
	}

	@Test(dataProvider = "dataProvider")
	public void findWords(String[][] input) {

		boolean[][] walked = new boolean[input.length][input[0].length];
		for (int i = 0; i < input.length; i++)
			for (int j = 0; j < input.length; j++) {
				findWords(i, j, input, walked, "");
			}
	}

	private void findWords(int i, int j, String[][] input, boolean[][] walked,
			String word) {

		if (i == walked.length || j == walked[0].length || i < 0 || j < 0
				|| walked[i][j]) {
			return;
		}

		walked[i][j] = true;
		word = word + input[i][j];
		System.out.println("Word:" + word);
		findWords(i, j - 1, input, walked, word);
		findWords(i + 1, j, input, walked, word);
		findWords(i, j + 1, input, walked, word);
		findWords(i - 1, j, input, walked, word);
		walked[i][j] = false;
	}

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {

		String[][] input = { { "A", "B", "C" }, { "D", "E", "F" },
				{ "G", "H", "I" } };
		return new Object[][] { { input } };
	}
}
