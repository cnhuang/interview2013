package q.leetcode;

import util.Question;

public class SearchForRange extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a sorted array of integers, find the starting and ending
		 * position of a given target value.
		 * 
		 * Your algorithm's runtime complexity must be in the order of O(log n).
		 * 
		 * If the target is not found in the array, return [-1, -1].
		 * 
		 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3,
		 * 4].
		 */
		return "http://leetcode.com/onlinejudge#question_34";
	}

	public int[] searchRange(int[] A, int target) {

		if (A == null || A.length == 0)
			return new int[] { -1, -1 };

		int s = 0;
		int e = A.length-1;

		while (s <= e) {

			int mid = (s + e) / 2;
			int midValue = A[mid];

			if (midValue == target) {
				int sIndex = mid;
				while (sIndex >= 0 && A[sIndex] == target) {
					sIndex--;
				}

				int eIndex = mid;

				while (eIndex < A.length && A[eIndex] == target) {
					eIndex++;
				}

				return new int[] { sIndex + 1, eIndex - 1 };
			}

			if (target > midValue) {
				s = mid + 1;
			} else
				e = mid - 1;

		}

		return new int[] { -1, -1 };
	}

}
