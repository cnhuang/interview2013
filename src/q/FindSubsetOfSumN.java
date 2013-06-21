package q;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindSubsetOfSumN extends Question {

	@Override
	public String getQuestion() {
		return "Given an array with different numbers and a number of C,so how to find all the combinations which the sum is C..like..array={1,2,3,4},C=3,,return is 2,which contains two combinations{{1,2},{3}}";
	}

	@Test(dataProvider = "dataProvider")
	public void find_recursive(Integer[] arr, int Sum) {

		Arrays.sort(arr);

		boolean[] selected = new boolean[arr.length];
		find_recursive(arr, Sum, 0, selected, 0);

	}

	private void find_recursive(Integer[] arr, int Sum, int index,
			boolean[] selected, int total) {

		if (total > Sum)
			return;

		if (index >= arr.length) {

			if (total == Sum) {
				String str = "";
				for (int i = 0; i < index; i++) {
					if (selected[i]) {
						str += arr[i] + ",";
					}
				}
				Log(str);
			}

			return;
		}

		selected[index] = false;
		find_recursive(arr, Sum, index + 1, selected, total);

		selected[index] = true;
		find_recursive(arr, Sum, index + 1, selected, total + arr[index]);

	}

	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] { { new Integer[] { 4, 1, 2, 3, 2 }, 3 } };
	}

}
