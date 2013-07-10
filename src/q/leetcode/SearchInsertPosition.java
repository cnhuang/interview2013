package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class SearchInsertPosition extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a sorted array and a target value, return the index if the
		 * target is found. If not, return the index where it would be if it
		 * were inserted in order.
		 * 
		 * You may assume no duplicates in the array.
		 * 
		 * Here are few examples. [1,3,5,6], 5 ¡÷ 2 [1,3,5,6], 2 ¡÷ 1 [1,3,5,6], 7
		 * ¡÷ 4 [1,3,5,6], 0 ¡÷ 0
		 */
		return "http://leetcode.com/onlinejudge#question_35";
	}

	@Test
	public void test() {
		Log(searchInsert(new int[] { 1, 3, 5, 6 }, 2));
		Log(searchInsert(new int[] { 1, 3, 4, 5, 6, 7 }, 2));
	}

	public int searchInsert(int[] A, int target) {

		if (A == null || A.length == 0)
			return 0;

		int s = 0;
		int e = A.length - 1;

		while (s <= e) {

			Log(s + "," + e);

			int mid = (s + e) / 2;
			int midValue = A[mid];

			if (midValue == target) {
				return mid;
			}

			if (target > midValue) {
				s = mid + 1;
			} else
				e = mid - 1;

		}
		return s;
	}

}
