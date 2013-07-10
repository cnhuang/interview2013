package q.leetcode;

import util.Question;

public class UniqueBinarySearchTrees extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given n, how many structurally unique BST's (binary search trees)
		 * that store values 1...n?
		 * 
		 * For example, Given n = 3, there are a total of 5 unique BST's.
		 */
		return "http://leetcode.com/onlinejudge#question_91";
	}

	public int numTrees(int n) {
		return numTrees(1, n);
	}

	public int numTrees(int s, int e) {

		if (s > e)
			return 1;

		int ret = 0;

		// each node could be parent
		for (int i = s; i <= e; i++)
			// number of left trees * number of right trees
			ret += numTrees(s, i - 1) * numTrees(i + 1, e);

		return ret;
	}
}
