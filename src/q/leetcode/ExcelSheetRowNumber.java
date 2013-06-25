package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class ExcelSheetRowNumber extends Question {

	@Override
	public String getQuestion() {
		/**
		 * Given the sequence S1 = {a,b,c,d,¡K,x,y,z,aa,ab,ac¡K. } and given that
		 * this sequence corresponds (term for term) to the sequence S2 =
		 * {0,1,2,3,¡K.}. Write code to convert an element of S2 to the
		 * corresponding element of S1.
		 */
		return "http://leetcode.com/2010/10/amazon-bar-raiser-interview-question.html";
	}

	@Test
	public void convert() {

		for (int i = 0; i < 728; i++) {
			Log(i + ":" + convert(i));
		}

	}

	public String convert(int n) {

		String s = "";

		do {
			s = ((char) (n % 26 + 'a' - (s.length() == 0 ? 0 : 1))) + s;
			n /= 26;
		} while (n > 0);

		return s;
	}

}
