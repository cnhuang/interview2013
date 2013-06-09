package q;

import java.util.Random;

import org.testng.annotations.Test;

import util.Question;

public class ShiftZerosToRight extends Question {

	@Override
	public String getQuestion() {
		return "Give a number and shift all zeros to right";
	}

	@Test
	public void shift() {

		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < 10; i++) {
			long l = Math.abs(rand.nextLong());
			Log("\nInput:" + l + ", output:" + shift(l));
		}

	}

	private long shift(long n) {

		char[] digits = String.valueOf(n).toCharArray();
		int zeroIndex = -1;

		for (int i = 0; i < digits.length; i++) {

			if (digits[i] == '0' && zeroIndex == -1)
				zeroIndex = i;
			else if (digits[i] != '0' && zeroIndex != -1) {
				digits[zeroIndex++] = digits[i];
				digits[i] = '0';
			}
		}

		return Long.valueOf(String.valueOf(digits));

	}

}
