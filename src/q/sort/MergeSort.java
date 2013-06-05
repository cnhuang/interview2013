package q.sort;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import java.util.Arrays;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class MergeSort extends Question {

	@Override
	public String getQuestion() {
		return "Merge sort";
	}

	@Test(dataProvider = "dataProvider")
	public void testMergeSort(Integer[] input) {

		Log("Input:" + Arrays.toString(input));
		Integer[] output = mergeSort(input, 0, input.length - 1);
		Log("Output:" + Arrays.toString(output));

		for (int i = 1; i < output.length; i++) {
			assertTrue(output[i] >= output[i - 1]);
		}
		assertEquals(input.length, output.length);
	}

	private Integer[] mergeSort(Integer[] input, int s, int e) {

		int diff = e - s;

		if (diff < 0)
			return new Integer[0];
		else if (diff == 0)
			return new Integer[] { input[s] };
		else if (diff == 1) {
			if (input[s] > input[e]) {
				return new Integer[] { input[e], input[s] };
			} else {
				return new Integer[] { input[s], input[e] };
			}
		} else {
			int mid = (s + e) / 2;
			Integer[] arr1 = mergeSort(input, s, mid);
			Integer[] arr2 = mergeSort(input, mid + 1, e);
			Integer[] output = new Integer[arr1.length + arr2.length];

			int index1 = 0;
			int index2 = 0;
			int index3 = 0;

			while (index3 < output.length) {

				if (index1 >= arr1.length) {
					output[index3++] = arr2[index2++];
				} else if (index2 >= arr2.length) {
					output[index3++] = arr1[index1++];
				} else if (arr1[index1] > arr2[index2]) {
					output[index3++] = arr2[index2++];
				} else {
					output[index3++] = arr1[index1++];
				}
			}
			return output;
		}
	}

	@DataProvider
	public static Integer[][][] dataProvider() {

		Random rand = new Random(System.currentTimeMillis());
		Integer[] input = new Integer[100];

		for (int i = 0; i < input.length; i++) {
			input[i] = rand.nextInt(50);
		}

		return new Integer[][][] { { input } };
	}
}
