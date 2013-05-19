package question;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class ChangeCoins extends Question {

	int[] coins = { 25, 10, 5, 1 };

	@Override
	public String getQuestion() {

		return "Change input amount of money to coins in all possible ways";
	}

	@Test(dataProvider = "dataProvider")
	public void change_recursive(int total) {

		Log("Totla (Recursive):" + total);

		int[] coinCount = { 0, 0, 0, 0 };
		change_recursive(total, 0, coinCount);
	}

	private void change_recursive(int remain, int coinIndex, int[] coinCount) {

		if (coinIndex == 3) {
			coinCount[3] = remain;
			System.out.println(Arrays.toString(coinCount));
			return;
		}

		int count = 0;

		while (remain >= 0) {

			coinCount[coinIndex] += count;
			change_recursive(remain, coinIndex + 1, coinCount);
			coinCount[coinIndex] -= count;
			count++;
			remain -= coins[coinIndex];
		}
	}

	// FAILED
	@Test(dataProvider = "dataProvider")
	public void change_iterative(int total) {

		Log("Totla (Iteration):" + total);

		int[] coinCount = { 0, 0, 0, total };

		List<int[]> results = new LinkedList<int[]>();
		results.add(coinCount);

		for (int i = coins.length - 2; i >= 0; i--) {

			int cheapCoin = 1;
			int expensiveCoin = 1;

			while (true) {
				if ((coins[i] * expensiveCoin) % (coins[i + 1]) != 0)
					expensiveCoin++;
				else {
					cheapCoin = (coins[i] * expensiveCoin) / (coins[i + 1]);
					break;
				}
			}

			List<int[]> newResults = new LinkedList<int[]>();

			for (int[] existingResult : results) {

				for (int j = 1; j <= existingResult[i + 1] / cheapCoin; j++) {
					int[] newResult = existingResult.clone();
					newResult[i] = j * expensiveCoin;
					newResult[i + 1] = existingResult[i + 1] - cheapCoin * j;
					newResults.add(newResult);
				}
			}

			results.addAll(newResults);
		}

		for (int[] result : results) {
			System.out.println(Arrays.toString(result));
		}

	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] { { 1 }, { 5 }, { 10 }, { 25 }, { 100 }, { 97 } };
	}

}
