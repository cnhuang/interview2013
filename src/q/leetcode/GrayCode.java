package q.leetcode;

import java.util.ArrayList;

import util.Question;

public class GrayCode extends Question {

	@Override
	public String getQuestion() {
		/*
		 * The gray code is a binary numeral system where two successive values
		 * differ in only one bit.
		 * 
		 * Given a non-negative integer n representing the total number of bits
		 * in the code, print the sequence of gray code. A gray code sequence
		 * must begin with 0.
		 * 
		 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence
		 * is:
		 * 
		 * 00 - 0
		 * 
		 * 01 - 1
		 * 
		 * 11 - 3
		 * 
		 * 10 - 2
		 */

		// Note
		// K = 1 {000, 001}
		// K = 2 {000, 001, 011, 010} = {{k = 1}, { reverse({K=1}) + 1 << 2} }
		// reverse ({k=1}) = {001,000};

		return "http://leetcode.com/onlinejudge#question_89";
	}

	public ArrayList<Integer> grayCode(int n) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		if (n < 0) {
			return result;
		}

		result.add(0);

		for (int i = 0; i < n; i++) {

			int size = result.size();

			for (int j = size - 1; j >= 0; j--) {
				result.add(result.get(j) + (1 << i));
			}

		}

		return result;

	}

}
