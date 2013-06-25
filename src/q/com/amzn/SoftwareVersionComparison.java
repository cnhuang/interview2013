package q.com.amzn;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class SoftwareVersionComparison extends Question {

	@Override
	public String getQuestion() {
		return null;
	}

	@Test(dataProvider = "dataProvider")
	public void compare(String v1, String v2, Integer r) {

		String[] v1s = v1.split("\\.");
		String[] v2s = v2.split("\\.");
		Log(Arrays.toString(v1s));
		Log(Arrays.toString(v2s));
		int i = compare(v1s, v2s, 0);
		assertEquals(r.intValue(), i);
		
	}

	public int compare(String[] v1, String[] v2, int index) {

		Log("\n" + index);
		Log(Arrays.toString(v1));
		Log(Arrays.toString(v2));

		Integer version1 = (v1 == null || v1.length <= index) ? 0 : Integer.parseInt(v1[index]);
		Log(version1);
		Integer version2 = (v2 == null || v2.length <= index) ? 0 : Integer.parseInt(v2[index]);
		Log(version2);

		int r = version1.compareTo(version2);
		Log("r=" + r);

		if (r == 0 && (v1.length - 1 > index || v2.length - 1 > index)) {
			return compare(v1, v2, index + 1);
		} else
			return r;
	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] {

		{ "2", "2", 0 },

		{ "2", "2.0", 0 },

		{ "2", "2.0.1", -1 },

		{ "2", "3", -1 },

		{ "3", "2", 1 },

		{ "2.0.2", "2.0.1", 1 },

		{ "2", "2", 0 },

		};
	}

}
