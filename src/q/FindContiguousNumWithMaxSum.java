package q;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindContiguousNumWithMaxSum extends Question {

	@Override
	public String getQuestion() {

		return "Find Contiguous Numbers With Max Sum In a given array.Cracking code interview 17.8";
	}

	@Test(dataProvider = "dataProvider")
	public void find(Integer[] input) {

		Log("input:" + Arrays.toString(input));

		SubSeq max = null;
		SubSeq local = null;

		for (int i = 0; i < input.length; i++) {

			if (local == null) {
				local = new SubSeq();
				local.start = i;
				local.end = i;
				local.sum = input[i];
			} else {
				if (local.sum + input[i] >= 0 && local.sum >= 0) {
					local.sum += input[i];
					local.end = i;
				} else {
					local = new SubSeq();
					local.start = i;
					local.end = i;
					local.sum = input[i];
				}
			}

			if (max == null || local.sum > max.sum) {
				max = new SubSeq();
				max.sum = local.sum;
				max.start = local.start;
				max.end = local.end;
			}
		}

		Log("Max:" + max.sum);
		Log("Subseq:" + max.start + " to " + max.end);
	}

	private static class SubSeq {
		int start;
		int end;
		int sum;
	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] {
				{ new Integer[] { 2, 3, -8, -1, 2, 4, -2, 3 } },
				{ new Integer[] { 5, -9, 6, -2, 3 } },
				{ new Integer[] { -3, -10, -5 } },
				{ new Integer[] { -3, -10, -5, -1 } } };
	}

}
