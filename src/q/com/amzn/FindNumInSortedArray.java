package q.com.amzn;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindNumInSortedArray extends Question {

	@Override
	public String getQuestion() {
		String str = "Given a sorted array, write a function to search first occurrence of a number in the array.\n";
		str += " If not found return -1\n";
		str += "Example:: {2,2,2,3,4,5,5,6,6,8,9} search 6 should return 7.";
		return str;
	}

	@Test(dataProvider = "dataProvider")
	public void find(Integer[] input, int target) {
		Log("Input:" + Arrays.toString(input));
		Log("Target:" + target);
		Log("Found:" + find(input, target, 0, input.length - 1));
	}

	private int find(Integer[] input, int target, int start, int end) {

		if (start > end)
			return -1;

		int midIndex = (start + end) / 2;

		if (target == input[midIndex])
			return midIndex;

		int newStart = midIndex;
		while (newStart < end && input[newStart + 1] == input[newStart]) {
			newStart++;
		}

		int rightSearch = find(input, target, newStart + 1, end);

		if (rightSearch != -1)
			return rightSearch;

		int newEnd = midIndex;
		while (newEnd > start && input[newEnd - 1] == input[newEnd]) {
			newEnd--;
		}

		return find(input, target, start, newEnd - 1);
	}

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {

		Integer[] input = { 2, 2, 2, 3, 4, 5, 5, 6, 6, 8, 9 };

		return new Object[][] { { input, 1 }, { input, 2 }, { input, 3 },
				{ input, 4 }, { input, 5 }, { input, 6 }, { input, 7 },
				{ input, 8 }, { input, 9 }, { input, 10 } };

	}
}
