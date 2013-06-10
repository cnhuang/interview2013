package q.com.google;

import org.testng.annotations.Test;

import util.Question;

public class GenerateRandomNumberWithAGivenDist extends Question {

	@Override
	public String getQuestion() {
		return "http://www.careercup.com/question?id=17433662";
	}

	@Test
	public void generate() {

		int[] input = { 1, 2, 4, 5, 1, 3 };

		int[] accumulate = new int[input.length];

		int count = 0;
		for (int i = 0; i < input.length; i++) {
			count += input[i];
			accumulate[i] = count;
		}

		for (int i = 0; i < count; i++) {

			for (int j = 0; j < accumulate.length; j++) {
				if (i < accumulate[j]) {
					Log("Rand " + i + ", return:" + j);
					break;
				}
			}
		}
	}
}
