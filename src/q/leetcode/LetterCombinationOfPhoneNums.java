package q.leetcode;

import java.util.ArrayList;

import util.Question;

public class LetterCombinationOfPhoneNums extends Question {

	@Override
	public String getQuestion() {
		/**
		 * Given a digit string, return all possible letter combinations that
		 * the number could represent.
		 * 
		 * A mapping of digit to letters (just like on the telephone buttons) is
		 * given below.
		 * 
		 * 
		 * 
		 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf",
		 * "cd", "ce", "cf"].
		 */
		return "http://leetcode.com/onlinejudge";
	}

	public ArrayList<String> letterCombinations(String digits) {

		ArrayList<String> result = new ArrayList<String>();
		result.add("");

		if (digits == null || digits.length() == 0)
			return result;

		
		for (char num : digits.toCharArray()) {

			ArrayList<String> newResult = new ArrayList<String>();

			for (char c : getLetters(num)) {

				for (String str : result) {
					newResult.add(str + c);
				}

			}

			result = newResult;
		}

		return result;

	}

	public char[] getLetters(char i) {
		switch (i) {
		case '2':
			return new char[] { 'a', 'b', 'c' };
		case '3':
			return new char[] { 'd', 'e', 'f' };
		case '4':
			return new char[] { 'g', 'h', 'i' };
		case '5':
			return new char[] { 'j', 'k', 'l' };
		case '6':
			return new char[] { 'm', 'n', 'o' };
		case '7':
			return new char[] { 'p', 'q', 'r', 's' };
		case '8':
			return new char[] { 't', 'u', 'v' };
		case '9':
			return new char[] { 'w', 'x', 'y', 'z' };
		default:
			return new char[] {};
		}

	}
}
