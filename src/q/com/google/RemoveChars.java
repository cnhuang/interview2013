package q.com.google;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class RemoveChars extends Question {

	@Override
	public String getQuestion() {
		return "http://www.careercup.com/question?id=18460667"
				+ " Eliminate all ‘b’ and ‘ac’ in an array of characters, you have to replace them in-place, and you are only allowed to iterate over the char array once.";
	}

	@Test(dataProvider = "dataProvider")
	public void eliminate(String str) {

		Log("Input:" + str);

		char[] chars = str.toCharArray();

		int currentIndex = 0;

		for (int i = 0; i < chars.length; i++) {

			if (chars[i] != 'b') {

				if (chars[i] == 'c' && chars[currentIndex - 1] == 'a') {
					currentIndex--;

				} else {

					chars[currentIndex++] = chars[i];
				}
			}
		}

		Log("Output:" + String.valueOf(chars).substring(0, currentIndex));
	}

	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] { { "abc" }, { "react" }, { "anche" } };
	}

}
