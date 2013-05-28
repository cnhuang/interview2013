package question;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class AdvertisingBoard extends Question {

	@Override
	public String getQuestion() {
		String str = "http://www.careercup.com/question?id=18892662\n"
				+ " There are exactly N advertising boards on the highway. Now a company want to advertise on some of these advertising boards\n"
				+ " (each advertising board costs some money). Company strategy is that, they want at least 'K' advertisement should be there among M consecutive\n"
				+ "  advertising boards. But at the same time Company want to pay minimum for its advertisement. \n"
				+ " Now, what is the total number of ways Company can advertise meeting its minimum cost strategy. Also 1 <= K <= M <= 50 and M <= N <= 10^9 \n"
				+ " As for Example: N = 3, M = 2, K = 1 ==> there is only one way for minimum cost, ie. 0C0 , where '0' denotes No company advertisement,\n"
				+ "  and 'C' denotes company advertisement board. Similarly, for N = 4, M = 2, K = 1 ==> there are 3 possible ways, ie. C0C0, 0C0C, 0CC0.";
		return str;
	}

	int min = Integer.MAX_VALUE;
	List<String> results = null;

	@Test(dataProvider = "dataProvider")
	public void findSolution(int N, int M, int K) {

		Log("N:" + N + ", M:" + M + ", K:" + K);
		findSolution(N, M, K, 0, new char[N], K, 0);
		Log(results.toString());

	}

	private void findSolution(int N, int M, int K, int index, char[] result,
			int need, int count) {

		if (count > min)
			return;

		if (index == N - 1) {

			if (need > 1)
				return;

			if (need == 1) {
				result[index] = 'C';
				count++;

			} else if (need <= 0) {
				result[index] = ' ';
			}

			if (count < min) {
				min = count;
				results = new LinkedList<String>();
			}

			if (count == min)
				results.add(">>Result:" + Arrays.toString(result) + ", count:"
						+ count + ", need:" + need + "\n");
			return;
		}

		if (index >= M - 1) {
			if (need > 1)
				return;
		}

		int indexRemovedNextRun = index - M + 1;
		int needNextRun = need;
		if (indexRemovedNextRun >= 0 && result[indexRemovedNextRun] == 'C') {
			needNextRun += 1;
		}

		if (index < M - 1 || need < 1) {
			result[index] = ' ';
			findSolution(N, M, K, index + 1, result, needNextRun, count);
		}

		result[index] = 'C';
		findSolution(N, M, K, index + 1, result, needNextRun - 1, count + 1);
		result[index] = ' ';

	}

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {

		return new Object[][] { { 40, 2, 1 } };

	}
}
