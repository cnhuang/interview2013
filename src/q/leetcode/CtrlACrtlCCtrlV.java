package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class CtrlACrtlCCtrlV extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/2011/01/ctrla-ctrlc-ctrlv.html";
	}

	@Test
	public void find() {

		// Need Ctrl+A, Ctrl+C, Ctrl+V to be ready for copy
		// Then Ctrl+V will double the size;
		// So, N click -> N = 3 + #ofA (A) + #ofCtrlV(V) = A*V

		int[] Ns = { 5, 6, 7, 8, 9, 10, 11,15 };

		for (int N : Ns) {

			int v = (N - 3) / 2;
			int a = (N - 3) - v;

			Log(N + ":" + Math.max(N, a * (v+1)));
		}

	}

}
