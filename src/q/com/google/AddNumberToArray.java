package q.com.google;

import java.util.Arrays;

import org.testng.annotations.Test;

import util.Question;

public class AddNumberToArray extends Question {

	@Override
	public String getQuestion() {
		return "http://www.careercup.com/question?id=18405668";
	}

	@Test
	public void add() {
		int[] data = { 9, 9, 8 };

		Log(Arrays.toString(data) + "+1=" + Arrays.toString(add(data, 1)));

		data = new int[] { 9, 9, 8 };
		Log(Arrays.toString(data) + "+2=" + Arrays.toString(add(data, 2)));

	}

	private int[] add(int[] arr, int n) {

		int carry = n;

		for (int i = arr.length - 1; i >= 0; i--) {

			arr[i] += carry;
			carry = arr[i] / 10;
			arr[i] = arr[i] % 10;
		}

		int[] arr2 = arr;

		if (carry != 0) {
			arr2 = new int[arr.length + 1];
			arr2[0] = carry;

			for (int i = 0; i < arr.length; i++) {
				arr2[i + 1] = arr[i];
			}
		}

		return arr2;
	}

}
