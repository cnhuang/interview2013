package q.leetcode;

import java.util.ArrayList;

import util.Question;

public class Triangle extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a triangle, find the minimum path sum from top to bottom. Each
		 * step you may move to adjacent numbers on the row below.
		 * 
		 * Note: Bonus point if you are able to do this using only O(n) extra
		 * space, where n is the total number of rows in the triangle.
		 */
		return "http://leetcode.com/onlinejudge#question_120";
	}

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

		if (triangle == null || triangle.isEmpty())
			return 0;

		int arr[] = new int[triangle.size()];
		arr[0] = triangle.get(0).get(0);

		for (int i = 1; i < triangle.size(); i++) {

			ArrayList<Integer> list = triangle.get(i);

			for (int j = list.size() - 1; j >= 0; j--) {

				if (j == list.size() - 1) {
					arr[j] = arr[j - 1] + list.get(j);
				} else if (j == 0) {
					arr[j] = arr[j] + list.get(j);
				} else {
					arr[j] = Math.min(arr[j - 1], arr[j]) + list.get(j);
				}
			}
		}

		int min = arr[0];

		for (int i : arr)
			min = Math.min(min, i);
		
		return min;

	}
}
