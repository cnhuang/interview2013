package q.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import util.Question;

public class FourSum extends Question {

	@Override
	public String getQuestion() {
		/**
		 * Given an array S of n integers, are there elements a, b, c, and d in
		 * S such that a + b + c + d = target? Find all unique quadruplets in
		 * the array which gives the sum of target.
		 * 
		 * Note:
		 * 
		 * Elements in a quadruplet (a,b,c,d) must be in non-descending order.
		 * (ie, a ? b ? c ? d) The solution set must not contain duplicate
		 * quadruplets. For example, given array S = {1 0 -1 0 -2 2}, and target
		 * = 0.
		 * 
		 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
		 */
		return "http://leetcode.com/onlinejudge#question_18";
	}

	@Test
	public void test() {
		int[] num = new int[] { -9, -6, -3, -5, -10, -6, 1, -7, 7, -1, -3, -10, 5, -3, -8, -8, 4,
				0, -7 };
		int target = -15;

		Log(fourSum(num, target));
	}

	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (num == null || num.length < 4)
			return result;

		Arrays.sort(num);

		if (num[num.length - 1] + num[num.length - 2] + num[num.length - 3] + num[num.length - 4] < target)
			return result;

		if (num[0] + num[1] + num[2] + num[3] > target)
			return result;

		for (int i = 0; i < num.length; i++) {
			
			int length = num.length - i;
			if (length < 4)
				break;

			if (num[i] + num[i + 1] + num[i + 2] + num[i + 3] > target)
				break;

			if (i > 0 && num[i] == num[i - 1])
				continue;

			ArrayList<ArrayList<Integer>> r = threeSum(num, i + 1, num.length - 1, target - num[i]);
			for (ArrayList<Integer> l : r) {
				l.add(0, num[i]);
				result.add(l);
			}
		}

		return result;
	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] num, int start, int end, int target) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (num == null || num.length < 3)
			return result;

		for (int i = start; i <= end; i++) {

			int s = i + 1;
			int e = num.length - 1;

			if (i > start && num[i] == num[i - 1])
				continue;

			while (s < e) {

				int sum = num[i] + num[s] + num[e];

				if (sum == target) {
					result.add(toArray(num[i], num[s], num[e]));

					do {
						e--;
					} while (num[e] == num[e + 1] && e > s);

					do {
						s++;
					} while (s < e && num[s] == num[s - 1]);
				} else if (sum > target) {
					do {
						e--;
					} while (num[e] == num[e + 1] && e > s);
				} else {
					do {
						s++;
					} while (s < e && num[s] == num[s - 1]);
				}

			}
		}

		return result;
	}

	public ArrayList<Integer> toArray(int a, int b, int c) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(a);
		arr.add(b);
		arr.add(c);
		return arr;
	}

}
