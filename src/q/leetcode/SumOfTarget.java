package q.leetcode;

import java.util.Arrays;

import org.testng.annotations.Test;

import util.Question;

public class SumOfTarget extends Question {

	@Override
	public String getQuestion() {
		// similar to coin change problem
		return "http://leetcode.com/2010/09/print-all-combinations-of-number-as-sum.html";
	}

	/**
	 * Given a target number, and a series of candidate numbers, print out all
	 * combinations, so that the sum of candidate numbers equals to the target.
	 * Here order is not important, so don¡¦t print the duplicated combination.
	 * e.g. target is 7, candidate is 2,3,6,7 output should be 7 and 3+2+2 (but
	 * not print 2+3+2, 2+2+3)
	 */

	@Test
	public void find() {
		int target = 7;
		int[] numbers = { 2, 3, 6, 7 };

		find(target, numbers, new int[numbers.length], 0);

	}

	public void find(int target, int[] nums, int[] result, int index) {

		if (target == 0) {
			Log(Arrays.toString(result));
			return;
		}

		if (index == nums.length) {
			return;
		}

		int count = 0;
		while (target >= 0) {
			result[index] = count;
			find(target, nums, result, index + 1);
			count++;
			target -= nums[index];
		}
	}

	/**
	 * Find all possible combination of numbers using a pre-defined candidate
	 * set. Each number from the candidate set may be used only once in the
	 * combination.
	 * 
	 * For example,
	 * 
	 * Candidate Set = {10, 1, 2, 7, 6, 1, 5} Target Number = 8
	 * 
	 * One possible output could be: 1+1+6 1+2+5 1+7 2+6
	 */
	@Test
	public void find2() {
		int target = 8;
		int[] numbers = { 10, 1, 2, 7, 6, 1, 5 };
		find2(target, numbers, new int[numbers.length], 0);
	}

	public void find2(int target, int[] nums, int[] result, int index) {

		if (target == 0) {
			Log(Arrays.toString(nums));
			Log(Arrays.toString(result) + "\n");
			return;
		}

		if (index == nums.length) {
			return;
		}

		result[index] = 0;
		find2(target, nums, result, index + 1);
		result[index] = 1;
		find2(target - nums[index], nums, result, index + 1);
		result[index] = 0;
	}
}
