package q.com.google;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindLongestSubstringWith2UniqueChar extends Question {

	@Override
	public String getQuestion() {
		return "http://www.careercup.com/page?pid=google-interview-questions";
	}

	@Test(dataProvider = "dataProvider")
	public void find(String string) {

		Finder finder = new Finder();
		for (int i = 0; i < string.length(); i++) {

			finder.find(String.valueOf(string.charAt(i)), i);
			Log("\n" + string.subSequence(0, i + 1));
			Log(finder.toString());
		}

		Log(string.subSequence(finder.longestStart, finder.longestEnd + 1));
	}

	private static class Finder {

		String char1;
		String char2;
		int char1Index;
		int char2Index;

		int longestStart;
		int longestEnd;
		int currentStart;

		public void find(String c, int index) {

			if (char1 == null) {
				char1 = c;
				currentStart = index;
				char1Index = index;
			} else if (char1.equals(c)) {
				char1Index++;
			} else if (char2 == null) {
				char2Index++;
				char2 = c;
			} else if (char2.equals(c)) {
				char2Index = index;
			} else {

				if (char1Index < char2Index) {
					currentStart = char1Index + 1;
					char1 = char2;
					char1Index = char2Index;

				} else
					currentStart = char2Index + 1;

				char2 = c;
				char2Index = index;
			}

			if (char1 != null && char2 != null) {
				if ((index - currentStart) > (longestEnd - longestStart)) {
					longestStart = currentStart;
					longestEnd = index;
				}
			}
		}

		public String toString() {
			return "char1:" + char1 + "(" + char1Index + "),char2:" + char2 + "(" + char2Index
					+ "), currentStart:" + currentStart + ", Longest: from " + longestStart
					+ " to " + longestEnd;
		}
	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] { { "aabbcbbbadef" } };
	}

}
