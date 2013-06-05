package q.algo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds.CharNode;

import util.Question;

public class LongestPalindrome extends Question {

	@Override
	public String getQuestion() {
		return "http://stackoverflow.com/questions/7043778/longest-palindrome-in-a-string-using-suffix-tree";
	}

	@Test(dataProvider = "dataProvider")
	public void findLongestPalindrome(String input) {

		CharNode root = new CharNode();

		
		for (char c : input.toCharArray()) {
			
		}

	}

	@DataProvider
	public static String[][] dataProvider() {
		return new String[][] { { "banana" } };
	}

}
