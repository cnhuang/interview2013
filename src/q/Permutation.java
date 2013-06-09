package q;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import util.Question;

public class Permutation extends Question {

	@Override
	public String getQuestion() {
		return "Permutation";
	}

	@Test
	public void permute() {

		String s = "abc";
		Log("Input:" + s);

		Log("\n\npermute_iterative");
		permute_iterative(s);

		Log("\n\npermute_recursive");
		permute_recursive(s, new boolean[s.length()], new char[s.length()], 0);

		Log("\n\npermute_recursive2");
		permute_recursive2(s, "");
	}

	// Performance N!
	private void permute_recursive2(String s, String current) {

		if (s.length() == current.length()) {
			Log(current);
			return;
		}

		int index = s.length() - (s.length() - current.length());
		char c = s.charAt(index);

		for (int i = 0; i <= current.length(); i++) {
			permute_recursive2(s, current.substring(0, i) + c + current.substring(i));
		}
	}

	// Low performance N^N
	private void permute_recursive(String s, boolean[] chosen, char[] current, int index) {

		if (index == s.length()) {
			Log(String.valueOf(current));
			return;
		}

		for (int i = 0; i < chosen.length; i++) {
			if (!chosen[i]) {

				chosen[i] = true;
				current[index] = s.charAt(i);
				permute_recursive(s, chosen, current, index + 1);
				chosen[i] = false;
			}
		}
	}

	private void permute_iterative(String s) {

		List<String> result = new LinkedList<String>();
		result.add("");

		for (char c : s.toCharArray()) {

			List<String> tmp = new LinkedList<String>();

			for (String str : result) {

				for (int i = 0; i <= str.length(); i++) {
					tmp.add(str.substring(0, i) + c + str.substring(i, str.length()));
				}
			}

			result = tmp;
		}

		for (String str : result) {
			Log(str);
		}
	}
}
