package q.leetcode;

import java.util.ArrayList;
import java.util.Collections;

import util.Question;

public class Combinations extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given two integers n and k, return all possible combinations of k
		 * numbers out of 1 ... n.
		 * 
		 * For example, If n = 4 and k = 2, a solution is:
		 * 
		 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
		 */
		return "http://leetcode.com/onlinejudge#question_77";
	}

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (n < k)
			return result;

		int[] chosen = new int[k];

		combine(n, chosen, 0, result);

		return result;
	}

	public void combine(int n, int[] chosen, int index, ArrayList<ArrayList<Integer>> result) {

		if (index == chosen.length) {
			result.add(toList(chosen));
			return;
		}

		if (n == 0) {
			return;
		}

		combine(n - 1, chosen, index, result);
		chosen[index] = n;
		combine(n - 1, chosen, index + 1, result);

	}

	public ArrayList<Integer> toList(int[] com) {

		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i : com)
			arr.add(i);

		Collections.sort(arr);
		return arr;

	}

}
