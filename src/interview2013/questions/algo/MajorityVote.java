package interview2013.questions.algo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import interview2013.util.Question;

public class MajorityVote extends Question {

	@Override
	public String getQuestion() {
		String str = "http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html\n";
		str += "find majority char of the given string\n";
		str += "then find the second, 3rd ones";
		return str;
	}

	@Test(dataProvider = "dataProvider")
	public void findMajority(String input) {

		char majority = ' ';
		int majorityCount = 0;

		for (char c : input.toCharArray()) {
			if (majority == ' ' || majorityCount == 0) {
				majority = c;
				majorityCount++;
			} else {
				if (majority == c) {
					majorityCount++;
				} else {
					majorityCount--;
				}
			}

			Log("Input " + c + ", majority:" + majority + ", majorityCount:"
					+ majorityCount);
		}

		Log(">>>>> majority:" + (majorityCount > 0 ? majority : "None"));
	}

	@DataProvider
	public static String[][] dataProvider() {
		return new String[][] { { "AAACCBBCCCBCC" }, { "AAAABBBB" },
				{ "ABABABAB" } };
	}

}
