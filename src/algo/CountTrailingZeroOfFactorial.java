package algo;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class CountTrailingZeroOfFactorial extends Question {

	@Override
	public String getQuestion() {

		return "Count Trailing Zero Of Factorial. Ex 5! = 120 => return 1. Idea, count 2s and 5s but 2s is more than 5s so count 5s only";
	}

	@Test(dataProvider = "dataProvider")
	public void countTrailingZero(int n) {

		int zeros = 0;
		int actualZeros = 0;

		if (n > 5) {

			for (int i = 5; i <= n; i *= 5) {
				zeros += n / i;
			}

			long factorial = 1;
			for (int l = 1; l <= n; l++) {
				factorial *= (long) l;
			}

			Log(n + " factorial:" + factorial);

			while (factorial % 10 == 0) {
				actualZeros++;
				factorial /= 10;
			}
		}

		assertEquals(n + " factorial ", actualZeros, zeros);
	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] { { 0 }, { 1 }, { 5 }, { 20 }, { 25 }, { -1 },
				{ -10 } };
	}
}
