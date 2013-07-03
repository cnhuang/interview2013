package q.leetcode;

import util.Question;

public class SortColors extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given an array with n objects colored red, white or blue, sort them
		 * so that objects of the same color are adjacent, with the colors in
		 * the order red, white and blue.
		 * 
		 * Here, we will use the integers 0, 1, and 2 to represent the color
		 * red, white, and blue respectively.
		 * 
		 * Note: You are not suppose to use the library's sort function for this
		 * problem.
		 * 
		 * Follow up: A rather straight forward solution is a two-pass algorithm
		 * using counting sort. First, iterate the array counting number of 0's,
		 * 1's, and 2's, then overwrite array with total number of 0's, then 1's
		 * and followed by 2's.
		 */
		return "http://leetcode.com/onlinejudge#question_75";
	}

	public void sortColors(int[] A) {

		if (A == null || A.length < 2)
			return;

		int[] count = new int[3];

		for (int i : A) {
			count[i]++;
		}

		int index = 0;
		int color = 0;
		for (int i : count) {
			for (int j = 0; j < i; j++)
				A[index++] = color;

			color++;
		}
	}
}
