package q;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class SwapTwoNumInPlace extends Question {

	@Override
	public String getQuestion() {

		return "Swap 2 numbers in place";
	}

	@Test(dataProvider = "dataProvider")
	public void swap(int a, int b) {

		int oldA = a;
		int oldB = b;
		
		a ^= b;
		b ^= a;
		a ^= b;

		assertEquals(oldA, b);
		assertEquals(oldB, a);
	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] { { 1, 0 }, { 1, 2 }, { 1, -1 }, { 1, 1 },
				{ 0, 0 }, { 0, 2 }, { 0, -1 }, { -1, 0 }, { -1, 2 },
				{ -1, -1 }, { -1, -2 }, };
	}

}
