package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class LongestIncreasingSubsequence extends Question {

	@Override
	public String getQuestion() {

		return "find longest increasing subsequesnce. ex: int[] arr = { 13, 14, 10, 11, 9, 30, 13, 31, 12, 14, 33, 1 }";
	}

	private int iteration = 0;

	@Test(dataProvider = "dataProvider")
	public void find(Integer[] arr) {

		iteration = 0;
		Log("Input:" + Arrays.toString(arr));
		List<Integer> longest = new LinkedList<Integer>();
		for (int i = arr.length - 1; i >= 0; i--) {
			iteration++;

			List<Integer> tmp = find(i, arr);
			if (tmp.size() > longest.size())
				longest = tmp;

			if (longest.size() >= i - 1)
				break;
		}

		Log("Result:" + longest);
		Log("Iteration:" + iteration);

		iteration = 0;
		Map<Integer, List<Integer>> cache = new HashMap<Integer, List<Integer>>();
		longest = new LinkedList<Integer>();
		for (int i = arr.length - 1; i >= 0; i--) {
			iteration++;

			List<Integer> tmp = find(i, arr, cache);
			if (tmp.size() > longest.size())
				longest = tmp;

			if (longest.size() >= i - 1)
				break;
		}
		Log("Result:" + longest);
		Log("Iteration (Cached):" + iteration);
	}

	private List<Integer> find(int index, Integer[] arr) {

		List<Integer> list = new LinkedList<Integer>();

		if (index == 0) {
			list.add(arr[index]);
			iteration++;
			return list;
		}

		List<Integer> longest = new LinkedList<Integer>();
		for (int i = index - 1; i >= 0; i--) {
			iteration++;
			if (arr[index] >= arr[i]) {
				List<Integer> tmp = find(i, arr);
				if (tmp.size() > longest.size())
					longest = tmp;

				if (longest.size() >= i - 1)
					break;
			}
		}

		longest.add(arr[index]);
		return longest;
	}

	private List<Integer> find(int index, Integer[] arr, Map<Integer, List<Integer>> cache) {

		List<Integer> list = new LinkedList<Integer>();

		if (index == 0) {
			list.add(arr[index]);
			iteration++;
			return list;
		}

		if (cache.containsKey(index))
			return cache.get(index);

		List<Integer> longest = new LinkedList<Integer>();
		for (int i = index - 1; i >= 0; i--) {
			iteration++;
			if (arr[index] >= arr[i]) {
				List<Integer> tmp = find(i, arr, cache);
				if (tmp.size() > longest.size())
					longest = tmp;

				if (longest.size() >= i - 1)
					break;
			}
		}

		longest.add(arr[index]);
		cache.put(index, longest);
		return longest;
	}

	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] { { new Integer[] { 13, 14, 10, 11, 9, 30, 13, 31, 12, 14, 33, 1 } } };
	}
}
