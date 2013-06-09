package q;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class SortStringAbyB extends Question {

	/*
	 * @input: str1: target string, str2: sort string
	 * 
	 * @output: sort str1 based on str2
	 * 
	 * @Example: ("house","eho") -> ehous
	 */

	@Override
	public String getQuestion() {
		return "Sort String A by B";
	}

	@Test(dataProvider = "dataProvider")
	public void sort(String A, String B) {

		Log("Sort " + A + " by " + B);

		char[] Bchars = B.toCharArray();
		char[] Achars = A.toCharArray();

		char[] newChars = new char[A.length()];
		int tailIndex = A.length() - 1;
		int headIndex = 0;

		// Build index
		int[] charCount = new int[B.length()];
		HashMap<String, Integer> charIndex = new HashMap<String, Integer>();

		for (int i = 0; i < B.length(); i++) {
			String c = String.valueOf(Bchars[i]);
			charIndex.put(c, i);
		}

		// sort A
		for (int i = A.length() - 1; i >= 0; i--) {

			char c = Achars[i];
			String s = String.valueOf(c);

			if (charIndex.containsKey(s))
				charCount[charIndex.get(s)]++;
			else
				newChars[tailIndex--] = c;
		}

		for (int i = 0; i < B.length(); i++) {
			for (int j = 0; j < charCount[i]; j++) {
				newChars[headIndex++] = Bchars[i];
			}
		}

		Log("New A:" + String.valueOf(newChars));
	}

	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] { { "todaysijdfkhske'lk;ld", "askldjivu" } };
	}

}
