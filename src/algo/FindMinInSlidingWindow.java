package algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;


public class FindMinInSlidingWindow extends Question {

	@Override
	public String getQuestion() {
		return "Give an size N array and a size M sliding window. Find min for each sliding window.\n"
				+ "Ex. N array = {1,2,3,4,5}, M = 3. Sliding window {0,2} = 1. Sliding window {1,3} = 2.\n"
				+ "Ask for linear time solution. ";
	}

	@Test(dataProvider = "TestCases")
	public void resolve(Integer[] input, int windowSize) {

		if (input == null || input.length == 0) {
			Log("Input list: empty");
			return;
		}

		if (windowSize < 1) {
			Log("Invalid window size:" + windowSize);
			return;
		}

		Log("Input list:" + Arrays.asList(input).toString());

		List<Integer> window = new LinkedList<Integer>();

		Integer currentMin = null;
		Integer nextMin = null;

		for (int i = 0; i < input.length; i++) {

			window.add(input[i]);

			if (currentMin == null || currentMin >= input[i]) {
				currentMin = input[i];
				nextMin = null;
			} else if (nextMin == null || nextMin >= input[i]) {
				nextMin = input[i];
			}

			if (window.size() == windowSize || i == input.length - 1) {
				Log("Window:" + window.toString() + ", Min:" + currentMin);

				Integer removed = window.remove(0);

				if (removed == currentMin) {
					currentMin = nextMin;
					nextMin = null;
				}
			}
		}
	}

	@DataProvider(name = "TestCases")
	public static Object[][] TestCases() {
		return new Object[][] { { null, 3 }, { new Integer[] { 1, 2, 3, 4, 5, 6 }, 3 },
				{ new Integer[] { 6, 5, 4, 3, 2, 1 }, 3 },
				{ new Integer[] { 1, 3, 5, 2, 4, 6 }, 3 },
				{ new Integer[] { 1, 1, 1, 1, 1, 1 }, 3 },
				{ new Integer[] { 1, 1, 2, 2, 1, 1 }, 3 }, { new Integer[] { 1, 2 }, 3 } };
	}

}
