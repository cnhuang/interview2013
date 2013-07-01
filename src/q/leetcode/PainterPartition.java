package q.leetcode;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class PainterPartition extends Question {

	@Override
	public String getQuestion() {
		/*
		 * 
		 * You have to paint N boards of length {A0, A1, A2 ¡K AN-1}. There are K
		 * painters available and you are also given how much time a painter
		 * takes to paint 1 unit of board. You have to get this job done as soon
		 * as possible under the constraints that any painter will only paint
		 * continuous sections of board, say board {2, 3, 4} or only board {1}
		 * or nothing but not board {2, 4, 5}.
		 */
		return "http://leetcode.com/2011/04/the-painters-partition-problem-part-ii.html";
	}

	@Test(dataProvider = "dataProvider")
	public void binary(int[] arr, int k) {

		Log("Input:" + Arrays.toString(arr) + ", K:" + k);

		int low = max(arr);
		int hi = sum(arr, 0, arr.length);

		while (low < hi) {

			int mid = (hi + low) / 2;

			int tmp = painterRequired(arr, mid);

			Log("Hi:" + hi + ", Low:" + low + ", mid:" + mid + ", tmp:" + tmp);

			if (tmp <= k) {
				// since the lower the better
				hi = mid;
			} else {
				low = mid+1;
			}
		}

		Log("Best:" + low);
	}

	private int painterRequired(int[] arr, int max) {

		int total = 0;
		int count = 1;

		for (int i : arr) {
			total += i;
			if (total > max) {
				total = i;
				count++;
			}

		}

		return count;
	}

	private int max(int[] arr) {
		int max = Integer.MIN_VALUE;

		for (int i : arr)
			max = Math.max(max, i);

		return max;
	}

	@Test(dataProvider = "dataProvider")
	public void bruteForce(int[] arr, int k) {

		Log("Input:" + Arrays.toString(arr) + ", K:" + k);
		int best = bruteForce(arr, 0, k);
		Log("Best:" + best);

	}

	private int bruteForce(int[] arr, int start, int k) {

		int remain = arr.length - start;

		if (remain < k) {
			return Integer.MAX_VALUE;
		}

		if (k == 1) {
			int total = 0;
			for (int i = start; i < arr.length; i++)
				total += arr[i];

			return total;
		}

		if (k == remain) {
			int max = Integer.MIN_VALUE;

			for (int i = start; i < arr.length; i++)
				if (arr[i] > max)
					max = arr[i];
			return max;
		}

		int best = Integer.MAX_VALUE;

		for (int i = start + 1; i <= arr.length; i++) {
			best = Math.min(best, Math.max(bruteForce(arr, i, k - 1), sum(arr, start, i - start)));
		}

		return best;
	}

	private int sum(int[] arr, int start, int length) {

		int total = 0;
		for (int i = start; i < length + start; i++) {
			total += arr[i];
		}

		return total;
	}

	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] { { new int[] { 100, 200, 300, 400, 500, 600, 700, 800, 900 }, 3 } };
	}
}
