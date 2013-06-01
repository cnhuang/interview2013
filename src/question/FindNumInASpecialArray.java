package question;

import org.testng.annotations.Test;

import util.Question;

public class FindNumInASpecialArray extends Question {

	@Override
	public String getQuestion() {

		return "Given an array of integers such that each element is either +1 or -1 to its preceding element."
				+ " Find 1st occurrence of a given number in that array without using linear search";
	}

	@Test
	public int findElementInArray(int[] input, int expected) {
		int current = 0;
		int difference = Math.abs(input[current] - expected);

		while (difference != 0 && current < input.length) {
			difference = Math.abs(input[current] - expected);
			current += difference;
		}

		if (difference == 0) {
			return current;
		}

		return -1;
	}
}
