package question;

import util.Question;

import java.util.*;

import org.testng.annotations.Test;

public class GenerateRandomNumber extends Question {

	/*
	 * http://www.careercup.com/question?id=9865865
	 * 
	 * k distinct integers [0, N) Select a random no [0,N) which is not in this
	 * k distinct list.
	 * 
	 * Example: [4, 6, 9] Choose a random no between 0 - 9 which is not 4, or 6,
	 * or 9. Valid output: 2 Invalid output: 6
	 */

	@Test
	public void GenerateTest() {

		int[] k = { 2, 3, 6, 9, 12, 17, 20, 21 };
		int N = 30;
		int available = 30 - k.length;

		Log("Input:" + Arrays.toString(k));
		Log("N:" + N);
		Log("Available:" + available);

		for (int i = 0; i < available; i++) {

			Log("\nRand = " + i);

			for (int j = 0; j < k.length; j++) {
				int taken = k[j] - j;
				if (taken > i) {
					Log("Num = " + (k[j] - (taken - i)));
					break;
				} else if (j == k.length - 1) {
					Log("Num = " + (i - taken + k[k.length - 1] + 1));
					break;
				}
			}

		}
	}

	@Override
	public String getQuestion() {
		// TODO Auto-generated method stub
		return null;
	}
}
