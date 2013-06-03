package dp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class RunUpStairs extends Question {

	private int iteration;

	@Override
	public String getQuestion() {
		return "Find # of ways to run up N stairs. You can run either 1, 2 , or 3 stairs per step";
	}

	@Test(dataProvider = "dataProvider")
	public void run(int N) {

		Log("\n\nStairs:" + N);
		iteration = 0;
		Log("No cache:" + run_noCache(N) + " approaches.");
		Log("No cache:" + iteration + " iterations.");

		iteration = 0;
		Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
		Log("Cache:" + run_cache(N, cache) + " approaches.");
		Log("Cache:" + iteration + " iterations.");
	}

	private Integer run_noCache(int N) {

		iteration++;

		if (N == 0)
			return 1;
		if (N < 0)
			return 0;

		return (run_noCache(N - 1) + run_noCache(N - 2) + run_noCache(N - 3));
	}

	private Integer run_cache(int N, Map<Integer, Integer> cache) {

		iteration++;

		if (cache.containsKey(N))
			return cache.get(N);

		int approaches = 0;
		if (N == 0)
			approaches = 1;
		else if (N < 0)
			approaches = 0;

		else
			approaches = (run_cache(N - 1, cache) + run_cache(N - 2, cache) + run_cache(
					N - 3, cache));

		cache.put(N, approaches);

		return approaches;
	}

	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
	}

}
