package question;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindMaxOfTwoNumberWithoutIfElseAndComparison extends Question {

	@Override
	public String getQuestion() {

		return "Find Max Of Two Numbers Without Using If Else and Comparison";
	}

	@Test(dataProvider = "dataProvider")
	public void findMax(int a, int b) {

		int max = 0;
		int s = sign(a - b);
		int flipS = s ^ 1;

		Log(a + "x" + flipS + "+" + b + "x" + s);

		max = a * flipS + b * s;

		assertEquals(Math.max(a, b), max);
	}

	private int sign(int n) {
		return (n >> 31) & 0x1;
	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] { { 1, 0 }, { 1, 2 }, { 1, -1 }, { 1, 1 },
				{ 0, 0 }, { 0, 2 }, { 0, -1 }, { -1, 0 }, { -1, 2 },
				{ -1, -1 }, { -1, -2 }, };
	}

}
