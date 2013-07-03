package q.leetcode;

import util.Question;

public class SearchInRotatedArrayII extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Follow up for "Search in Rotated Sorted Array": What if duplicates
		 * are allowed?
		 * 
		 * Would this affect the run-time complexity? How and why?
		 * 
		 * Write a function to determine if a given target is in the array.
		 */
		return "http://leetcode.com/onlinejudge#question_81";
	}

	public boolean search(int[] A, int target) {

		if (A == null || A.length == 0)
			return false;

		int s = 0;
		int e = A.length - 1;

		while (s <= e) {

			int mid = (s + e) / 2;

			if (A[mid] == target)
				return true;

			if (A[mid] < target) {

				if (A[e] < A[mid] || A[e] >= target)
					s = mid + 1;
				else if (A[e] > A[mid] && A[e] < target)
					e = mid - 1;
				else
					e--;

			} else {

				if (A[e] > A[mid] || A[e] < target) {
					e = mid - 1;
				} else if (A[e] < A[mid] && A[e] >= target)
					s = mid + 1;
				else
					e--;
			}
		}

		return false;
	}

}
