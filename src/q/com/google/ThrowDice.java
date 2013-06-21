package q.com.google;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class ThrowDice extends Question {

	@Override
	public String getQuestion() {
		return "http://www.careercup.com/question?id=17850664";
	}

	@Test(dataProvider = "dataProvider")
	public void findWays(int numOfDice, int diceFaces, int number) {

		Log(find_recursive(numOfDice, diceFaces, number, new int[numOfDice])
				+ " wasys to generate number:" + number);

	}

	private int find_recursive(int numOfDice, int diceFaces, int number, int[] roll) {

		//important
		if (number <= 0)
			return 0;

		if (numOfDice == 1) {
			if (diceFaces >= number) {
				roll[numOfDice - 1] = number;
				Log(Arrays.toString(roll));
				return 1;
			}
			
			return 0;
		}

		if (number < numOfDice) {
			return 0;
		}

		if (number == numOfDice) {

			for (int i = 0; i < number; i++)
				roll[i] = 1;

			Log(Arrays.toString(roll));

			return 1;
		}

		int ways = 0;

		for (int i = 1; i <= diceFaces; i++) {

			roll[numOfDice - 1] = i;
			ways += find_recursive(numOfDice - 1, diceFaces, number - i, roll);
		}

		return ways;
	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] { { 3, 6, 8 } };
	}
}
