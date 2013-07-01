package q.leetcode;

import java.util.ArrayList;

import util.Question;

public class Permutation extends Question {

	@Override
	public String getQuestion() {

		/*
		 * Given a collection of numbers, return all possible permutations.
		 * 
		 * For example, [1,2,3] have the following permutations: [1,2,3],
		 * [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
		 */

		return "http://leetcode.com/onlinejudge#question_46";
	}

	public ArrayList<ArrayList<Integer>> permute(int[] num) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (num == null || num.length == 0)
			return result;

		permute(num, result, 0, new boolean[num.length], new int[num.length]);

		return result;

	}

	public void permute(int[] num, ArrayList<ArrayList<Integer>> result, int index,
			boolean[] chosen, int[] r) {

		if (index == num.length) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int i : r)
				arr.add(i);
			result.add(arr);
			return;
		}

		for (int i = 0; i < num.length; i++) {

			if (!chosen[i]) {

				chosen[i] = true;
				r[index] = num[i];
				permute(num, result, index + 1, chosen, r);
				chosen[i] = false;
			}
		}

	}

}
