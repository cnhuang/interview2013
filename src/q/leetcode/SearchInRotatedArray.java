package q.leetcode;

import util.Question;

public class SearchInRotatedArray extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Suppose a sorted array is rotated at some pivot unknown to you
		 * beforehand.
		 * 
		 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
		 * 
		 * You are given a target value to search. If found in the array return
		 * its index, otherwise return -1.
		 * 
		 * You may assume no duplicate exists in the array.
		 */
		return "http://leetcode.com/onlinejudge#question_33";
	}

	public int search(int[] A, int target) {

		if (A == null || A.length == 0)
			return -1;

		int s = 0;
		int e = A.length - 1;

		while (s <= e) {

			int mid = (s + e) / 2;
			int midNum = A[mid];

			if (midNum == target)
				return mid;

			if (midNum >= A[s]) {

				if (target >= A[s] && target < midNum) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}
			} else {
				if (target <= A[e] && target > midNum) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}
			}

		}

		return -1;

	}
}
