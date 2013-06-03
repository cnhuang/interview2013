package question;

import java.util.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindAnagramOfBInA extends Question {

	@Override
	public String getQuestion() {

		String str = "http://www.careercup.com/question?id=8684685 "
				+ " you are given two arrays. A of size n, B of size m. m is a very very "
				+ " small number compared to n. find out if A contains a substring which is "
				+ " anagram of B. ";
		return str;
	}

	@Test(dataProvider = "dataProvider")
	public void find(String longString, String shortString) {

		Log("Find anagram of " + shortString + " in " + longString);

		Map<String, Integer> map = getStringMap(shortString);

		// Important. Once see an unexist char. Restart the process from the
		// next index. But don't remove char before the new start index
		int newStartIndex = 0;

		for (int i = 0; i < longString.length(); i++) {

			Log("\nProcess index:" + i + ", char:" + longString.charAt(i));
			String str = String.valueOf(longString.charAt(i));

			if (!map.containsKey(str)) {
				map = getStringMap(shortString);
				newStartIndex = i + 1;
				Log("Invalid char. Restart from:" + newStartIndex);
			} else {
				Log("Add char:" + str);
				map.put(str, map.get(str) - 1);

				int removeIndex = i - shortString.length();
				if (removeIndex >= newStartIndex) {
					String removeStr = String.valueOf(longString
							.charAt(removeIndex));
					map.put(removeStr, map.get(removeStr) + 1);

					Log("Remove char from index:" + removeIndex);
				}
			}

			if (check(map)) {
				Log(">>>>Found:"
						+ longString.substring(i - shortString.length() + 1,
								i + 1));
			}
		}
	}

	private Map<String, Integer> getStringMap(String str) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (char c : str.toCharArray()) {
			String cStr = String.valueOf(c);
			if (!map.containsKey(cStr))
				map.put(cStr, 1);
			else
				map.put(cStr, map.get(cStr) + 1);
		}

		return map;
	}

	private boolean check(Map<String, Integer> map) {
		Log("check map:" + map);
		for (Integer value : map.values())
			if (value != 0)
				return false;

		return true;
	}

	@DataProvider
	public static Object[][] dataProvider() {
		String A = "ghefdckjcaaadebcclpq";
		String B = "aabedcca";
		return new Object[][] { { A, B } };
	}

}
