package q.leetcode;

import java.util.Arrays;

import org.testng.annotations.Test;

import util.Question;

public class RotatingArrayInPlace extends Question {

	@Override
	public String getQuestion() {

		/**
		 * Rotate a one-dimensional array of n elements to the right by k steps.
		 * For instance, with n=7 and k=3, the array {a, b, c, d, e, f, g} is
		 * rotated to {e, f, g, a, b, c, d}.
		 */
		return "http://leetcode.com/2010/04/rotating-array-in-place.html";
	}

	@Test
	public void rotate() {

		for (int rotation = 0; rotation < 20; rotation++) {

			Log("Rotation:" + rotation);
			int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

			boolean[] b = new boolean[arr.length];

			for (int i = 0; i < rotation % arr.length; i++) {

				if (b[i])
					continue;

				int index = i;
				int prev = arr[index];

				do {

					index = (index + rotation) % arr.length;
					
					if(b[i])
						break;
					
					int tmp = arr[index];
					b[index] = true;
					arr[index] = prev;
					prev = tmp;

				} while (index != i);
			}

			Log("Rotation:" + Arrays.toString(arr));
		}

	}
}
