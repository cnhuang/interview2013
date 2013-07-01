package q.leetcode;

import util.Question;

public class RemoveElement extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given an array and a value, remove all instances of that value in
		 * place and return the new length.
		 * 
		 * The order of elements can be changed. It doesn't matter what you
		 * leave beyond the new length.
		 */
		return "http://leetcode.com/onlinejudge#question_27";
	}

	public int removeElement(int[] A, int elem) {

		if (A == null || A.length == 0) {
			return 0;
		}

		int index = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem)
				A[index++] = A[i];
		}

		return index;

	}

}
