package q.com.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindMaxDiffBtwSubArrays extends Question {

	@Override
	public String getQuestion() {
		return "http://www.careercup.com/question?id=19286747";
	}

	@Test(dataProvider = "dataProvider")
	public void find(int[] arr) {

		Log("Input:" + Arrays.toString(arr));

		int[] reverse = reverse(arr);

		Map<Integer, Data> max = new HashMap<Integer, Data>();
		Map<Integer, Data> min = new HashMap<Integer, Data>();

		Map<Integer, Data> maxRev = new HashMap<Integer, Data>();
		Map<Integer, Data> minRev = new HashMap<Integer, Data>();

		for (int i = 0; i < arr.length; i++) {

			findMax(arr, max);
			findMax(reverse, maxRev);

			findMin(arr, min);
			findMin(reverse, minRev);
		}

		int diff = 0;
		String part1 = null;
		String part2 = null;

		for (int i = 1; i < arr.length; i++) {

			Data num1 = max.get(i - 1);
			Data num2 = minRev.get(arr.length - i - 1);

			if (diff < Math.abs(num1.sum - num2.sum)) {
				part1 = num1.toString(arr);
				part2 = num2.toString(arr);
				diff = Math.abs(num1.sum - num2.sum);
			}

			num1 = min.get(i - 1);
			num2 = maxRev.get(arr.length - i - 1);

			if (diff < Math.abs(num1.sum - num2.sum)) {
				part1 = num1.toString(arr);
				part2 = num2.toString(arr);
				diff = Math.abs(num1.sum - num2.sum);
			}

		}

		Log(part1);
		Log(part2);
		Log(diff + "");
	}

	private int[] reverse(int[] arr) {
		int[] arr2 = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			arr2[arr.length - 1 - i] = arr[i];
		}

		return arr2;
	}

	@DataProvider
	public static Object[][] dataProvider() {

		int[] arr1 = { 2, -1, -2, 1, -4, 2, 8 };
		int[] arr2 = { 1, 2, 3, 4, 5 };
		int[] arr3 = { -1, -3, -5, -2, -1, -4 };
		int[] arr4 = { 4, -1, 7 };

		return new Object[][] { { arr1 }, { arr2 }, { arr3 }, { arr4 } };
	}

	private void findMax(int[] arr, Map<Integer, Data> cache) {

		Data rolling = new Data(0, 0, arr[0]);
		Data current = new Data(0, 0, arr[0]);

		cache.put(0, new Data(0, 0, arr[0]));

		for (int i = 1; i < arr.length; i++) {

			if (rolling.sum + arr[i] < 0) {

				rolling.s = i;
				rolling.e = i;
				rolling.sum = arr[i];

			} else {

				rolling.sum += arr[i];
				rolling.e = i;
			}

			if (current.e == i - 1 && current.sum + arr[i] > Math.max(current.sum, arr[i])) {

				current.e = i;
				current.sum += arr[i];

			} else if (current.sum <= arr[i]) {
				current = new Data(i, i, arr[i]);
			}

			if (rolling.sum >= current.sum)
				current = new Data(rolling);

			cache.put(i, new Data(current));

		}
	}

	private void findMin(int[] arr, Map<Integer, Data> cache) {

		Data rolling = new Data(0, 0, arr[0]);
		Data current = new Data(0, 0, arr[0]);

		cache.put(0, new Data(0, 0, arr[0]));

		for (int i = 1; i < arr.length; i++) {

			if (rolling.sum + arr[i] > 0) {

				rolling.s = i;
				rolling.e = i;
				rolling.sum = arr[i];

			} else {

				rolling.sum += arr[i];
				rolling.e = i;
			}

			if (current.e == i - 1 && current.sum + arr[i] < Math.min(current.sum, arr[i])) {

				current.e = i;
				current.sum += arr[i];

			} else if (current.sum >= arr[i]) {
				current = new Data(i, i, arr[i]);
			}

			if (rolling.sum <= current.sum)
				current = new Data(rolling);

			cache.put(i, new Data(current));

		}
	}

	public static class Data {

		int s;
		int e;
		int sum;
		int rollingSum;

		public Data(int s, int e, int sum) {
			this.s = s;
			this.e = e;
			this.sum = sum;
		}

		public Data(Data data) {
			this.s = data.s;
			this.e = data.e;
			this.sum = data.sum;
		}

		public String toString(int[] arr) {

			try {
				return Arrays.toString(Arrays.copyOfRange(arr, s, e + 1)) + ", Sum:" + sum;
			} catch (Exception ex) {
				return "[" + ex.getMessage() + "], Sum:" + sum + ", Start:" + s + ", End:" + e;
			}
		}

	}

}
