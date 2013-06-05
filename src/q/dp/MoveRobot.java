package q.dp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class MoveRobot extends Question {

	private int iteration = 0;

	@Override
	public String getQuestion() {
		return "Given a NxN matrix, find # appraqoches to move from (0,0) to (n-1,n-1). Only move to right and down.";
	}

	@Test(dataProvider = "dataProvider")
	public void move(int N) {

		Log("Matrix Size " + N + "x" + N);
		iteration = 0;
		Log((move(N, 0, 1) + move(N, 1, 0)) + " approaches.");
		Log("No cache:" + iteration + " iterations.");

		iteration = 0;
		Map<String, Integer> cache = new HashMap<String, Integer>();
		Log((move_cache(N, 0, 1, cache) + move_cache(N, 1, 0, cache))
				+ " approaches.");
		Log("Cache:" + iteration + " iterations.");
	}

	private Integer move(int N, int x, int y) {
		// Log("Move to (" + x + "," + y + ")");
		iteration++;
		if (x > N - 1)
			return 0;
		if (y > N - 1)
			return 0;
		if (y == N - 1 && x == N - 1)
			return 1;

		return move(N, x + 1, y) + move(N, x, y + 1);
	}

	private Integer move_cache(int N, int x, int y, Map<String, Integer> cache) {

		String str = x + "-" + y;

		if (cache.containsKey(str))
			return cache.get(str);

		iteration++;
		int approaches = 0;
		if (x > N - 1)
			approaches = 0;
		else if (y > N - 1)
			approaches = 0;
		else if (y == N - 1 && x == N - 1)
			approaches = 1;
		else
			approaches = move_cache(N, x + 1, y, cache)
					+ move_cache(N, x, y + 1, cache);
		
		cache.put(str, approaches);

		return approaches;
	}

	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] { { 2 }, { 3 } };
	}
}
