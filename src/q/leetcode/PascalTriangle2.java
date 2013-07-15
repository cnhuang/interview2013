package q.leetcode;

import java.util.ArrayList;

import util.Question;

public class PascalTriangle2 extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given numRows, generate the first numRows of Pascal's triangle.
		 * 
		 * For example, given numRows = 5, Return
		 * 
		 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
		 */
		return "http://leetcode.com/onlinejudge#question_118";
	}

	public ArrayList<ArrayList<Integer>> generate(int numRows) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (numRows < 1)
			return result;

		ArrayList<Integer> r = new ArrayList<Integer>();
		r.add(1);
		result.add(r);

		while (result.size() < numRows) {

			ArrayList<Integer> p = result.get(result.size() - 1);

			r = new ArrayList<Integer>();
			r.add(1);

			for (int j = 0; j < p.size() - 1; j++) {
				r.add(p.get(j) + p.get(j + 1));
			}

			r.add(1);

			result.add(r);

		}

		return result;

	}

}
