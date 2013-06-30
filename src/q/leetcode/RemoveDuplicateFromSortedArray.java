package q.leetcode;

import util.Question;

public class RemoveDuplicateFromSortedArray extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a sorted array, remove the duplicates in place such that each
		 * element appear only once and return the new length.
		 * 
		 * Do not allocate extra space for another array, you must do this in
		 * place with constant memory.
		 * 
		 * For example, Given input array A = [1,1,2],
		 * 
		 * Your function should return length = 2, and A is now [1,2].
		 */
		return "http://leetcode.com/onlinejudge#question_26";
	}

	public int removeDuplicates(int[] A) {

		if (A == null)
			return 0;

		if (A.length < 2)
			return A.length;

		int index = 1;

		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1]){
				A[index++] = A[i];
			}
		}

		return index;

	}

}
