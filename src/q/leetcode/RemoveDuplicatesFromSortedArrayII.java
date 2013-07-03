package q.leetcode;

import util.Question;

public class RemoveDuplicatesFromSortedArrayII extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Follow up for "Remove Duplicates": What if duplicates are allowed at
		 * most twice?
		 * 
		 * For example, Given sorted array A = [1,1,1,2,2,3],
		 * 
		 * Your function should return length = 5, and A is now [1,1,2,2,3].
		 */
		return "http://leetcode.com/onlinejudge#question_80";
	}

	public int removeDuplicates(int[] A) {

		if (A == null || A.length < 3)
			return A == null ? 0 : A.length;

		int index = 2;

		for (int i = 2; i < A.length; i++) {

			// important. Compare to index-2 not i-2
			if (A[i] != A[index - 2]) {
				A[index++] = A[i];
			}
		}

		return index;

	}
}
