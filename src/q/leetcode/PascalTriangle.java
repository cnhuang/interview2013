package q.leetcode;

import java.util.ArrayList;

import util.Question;

public class PascalTriangle extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given an index k, return the kth row of the Pascal's triangle.
		 * 
		 * For example, given k = 3, Return [1,3,3,1].
		 * 
		 * Note: Could you optimize your algorithm to use only O(k) extra space?
		 */
		return "http://leetcode.com/onlinejudge#question_119";
	}

	public ArrayList<Integer> getRow(int rowIndex) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		int n = rowIndex + 1;

		if (n < 1)
			return result;
		
		int[] arr = new int[n];
		arr[0] = 1;

		for (int i = 2; i <= n; i++) {

			arr[i - 1] = 1;

			for (int j = i - 2; j > 0; j--) {
				arr[j] = arr[j] + arr[j - 1];
			}

			arr[0] = 1;
		}

		for (int i : arr)
			result.add(i);

		return result;

	}
}
