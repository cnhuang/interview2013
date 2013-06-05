package q.com.google;

import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class GeneratePhoneNumberStrings extends Question {

	@Override
	public String getQuestion() {
		return "Using letters on the phone keyboard to generate all combinations of "
				+ "letters for an input phone number";
	}

	@Test(dataProvider = "dataProvider")
	public void generate_iteration(String number) {

		Log("Phone number:" + number);

		List<String> words = new LinkedList<String>();
		words.add("");

		for (char c : number.toCharArray()) {

			char[] chars = GetLetters(Integer.valueOf(String.valueOf(c)));

			// Important: Not all number has letters
			if (chars.length == 0) {
				continue;
			}

			List<String> tmp = new LinkedList<String>();
			for (String str : words) {
				for (char tmpChar : chars) {
					tmp.add(str + tmpChar);
				}
			}

			words = tmp;
		}

		for (String str : words) {
			Log("Words:" + str);
		}

		Log("Total Words:" + words.size());
	}

	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] { { "5202470626" } };
	}

	private char[] GetLetters(int number) {

		switch (number) {
		case 2:
			return new char[] { 'a', 'b', 'c' };
		case 3:
			return new char[] { 'd', 'e', 'f' };
		case 4:
			return new char[] { 'g', 'h', 'i' };
		case 5:
			return new char[] { 'j', 'k', 'l' };
		case 6:
			return new char[] { 'm', 'n', 'o' };
		case 7:
			return new char[] { 'p', 'q', 'r', 's' };
		case 8:
			return new char[] { 't', 'u', 'v' };
		case 9:
			return new char[] { 'w', 'x', 'y', 'z' };
		default:
			return new char[] {};
		}

	}

}
