package q.com.amzn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import util.Question;

public class FindTheKthMostFreqWord extends Question {

	@Override
	public String getQuestion() {
		return null;
	}

	@Test
	public void test() {

		List<String> input = Arrays.asList(new String[] { "g", "g", "g", "g", "g", "a", "b", "b",
				"c", "a", "b", "d", "d", "e", "f" });
		MostFrequentWord mfw = new MostFrequentWord(input);

		for (int i = 1; i <= 10; i++) {
			Log(i + " mfw");
			Log(mfw.getMostFreqWord(i));
		}
	}

	@Test
	public void test2() {

		List<Integer> input = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 3, 2, 1 });
		Collections.sort(input);

		Log(input);

		Collections.sort(input, new Comparator<Integer>() {

			public int compare(Integer arg0, Integer arg1) {
				if (arg0 == arg1)
					return 0;
				if (arg0 < arg1)
					return 1;
				else
					return -1;
			}
		});

		Log(input);
	}

	public static class MostFrequentWord {

		private Object[] indexArray;
		private Map<Integer, List<String>> freqStringMap;

		public MostFrequentWord(List<String> input) {

			if (input == null || input.size() == 0) {
				throw new IllegalArgumentException();
			}

			preProcess(input);
		}

		private void preProcess(List<String> input) {

			Map<String, Integer> wordCountMap = new HashMap<String, Integer>();

			for (String str : input) {
				Integer count = wordCountMap.get(str);
				if (count == null) {
					wordCountMap.put(str, 1);
				} else {
					wordCountMap.put(str, count + 1);
				}
			}

			freqStringMap = new HashMap<Integer, List<String>>();

			for (Entry<String, Integer> entry : wordCountMap.entrySet()) {

				List<String> strs = freqStringMap.get(entry.getValue());

				if (strs == null) {
					strs = new LinkedList<String>();
					freqStringMap.put(entry.getValue(), strs);
				}

				strs.add(entry.getKey());
			}

			indexArray = freqStringMap.keySet().toArray();
			Arrays.sort(indexArray);
		}

		public List<String> getMostFreqWord(int n) {

			if (n > indexArray.length || n < 1)
				return null;
			else {
				return freqStringMap.get(indexArray[indexArray.length - n]);
			}
		}
	}
}
