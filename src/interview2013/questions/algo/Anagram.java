package interview2013.questions.algo;

import static org.testng.AssertJUnit.assertTrue;
import interview2013.util.Question;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Anagram extends Question {

	@Override
	public String getQuestion() {
		return "Are two strings made of the same chars?";
	}

	@Test(dataProvider = "TestCases")
	public void resolve_sort(String str1, String str2, boolean result) {

		boolean isStr1Null = str1 == null;
		boolean isStr2Null = str2 == null;

		Boolean isAnagram = null;

		if (isStr1Null && isStr2Null)
			isAnagram = true;
		else if (isStr1Null != isStr2Null)
			isAnagram = false;
		else {
			char[] char1 = str1.toLowerCase().toCharArray();
			char[] char2 = str2.toLowerCase().toCharArray();

			Arrays.sort(char1);
			Arrays.sort(char2);

			Log("\nChar1:" + String.valueOf(char1).trim());
			Log("Char2:" + String.valueOf(char2).trim());

			isAnagram = String.valueOf(char1).trim().equals(String.valueOf(char2).trim());
		}

		assertTrue(isAnagram == result);
	}

	@Test(dataProvider = "TestCases")
	public void resolve_hash(String str1, String str2, boolean result) {

		boolean isStr1Null = str1 == null;
		boolean isStr2Null = str2 == null;

		Boolean isAnagram = null;

		if (isStr1Null && isStr2Null)
			isAnagram = true;
		else if (isStr1Null != isStr2Null)
			isAnagram = false;
		else {

			int[] count = new int[26];
			str1 = str1.toLowerCase();
			for (int i = 0; i < str1.length(); i++) {
				int c = str1.charAt(i) - 'a';
				if (c < 0 || c >= 26)
					continue;
				else
					count[c]++;
			}

			str2 = str2.toLowerCase();

			for (int i = 0; i < str2.length(); i++) {
				int c = str2.charAt(i) - 'a';
				if (c < 0 || c >= 26)
					continue;
				else {
					count[c]--;
				}
			}

			for (int i = 0; i < count.length; i++) {
				if (count[i] != 0) {
					isAnagram = false;
					break;
				}
			}

			if (isAnagram == null)
				isAnagram = true;
		}

		assertTrue(isAnagram == result);
	}

	@DataProvider(name = "TestCases")
	public static Object[][] TestCases() {
		return new Object[][] { { null, null, true }, { null, "", false }, { "", "", true },
				{ "a", "a", true }, { "earth", "heart", true }, { "earth", "hearr", false },
				{ "ab", "a", false }, { "Roll in the hay", "Thrill a honey", true } };
	}
}
