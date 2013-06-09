package q;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class Parentheses extends Question {

	@Override
	public String getQuestion() {
		return "Find all ways to put N parentheses pairs";
	}

	@Test(dataProvider = "dataProvider")
	public void find(int n) {

		Log("N:" + n);
		find(n, n, "");

	}

	private void find(int leftP, int rightP, String pattern) {

		if (leftP == 0 && rightP == 0) {
			Log(pattern);
			return;
		}

		// important
		if (leftP > 0)
			find(leftP - 1, rightP, pattern + "(");

		if (leftP < rightP)
			find(leftP, rightP - 1, pattern + ")");
	}

	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] { { 0 }, { 1 }, { 2 }, { 3 }, { 4 } };
	}

}
