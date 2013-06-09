package q;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import util.Question;

public class RemoveDuplicateChar extends Question {

	@Override
	public String getQuestion() {
		return "Remove Duplicate Char";
	}

	@Test
	public void remove() {

		String s = "fklsdjfl;kjflskjdr";
		Log("Input:" + s);
		Log("remove1:" + remove1(s));

		// if input is a linked list do the same
		// if no cache, has to do n^2 approach
	}

	private String remove1(String s) {

		Set<String> set = new HashSet<String>();
		char[] newString = new char[s.length()];
		int index = 0;

		for (char c : s.toCharArray()) {

			String cStr = String.valueOf(c);
			if (!set.contains(cStr)) {
				newString[index++] = c;
				set.add(cStr);
			}
		}

		return String.valueOf(newString).trim();
	}
}
