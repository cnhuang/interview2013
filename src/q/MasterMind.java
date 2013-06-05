package q;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.testng.annotations.Test;

import util.Question;

public class MasterMind extends Question {

	Random rand = new Random(System.currentTimeMillis());
	String[] candidate = { "R", "G", "B", "Y" };

	@Override
	public String getQuestion() {

		return "Cracking the code interview: 17.5";
	}

	@Test
	public void play() {

		String[] answer = new String[4];

		for (int i = 0; i < 4; i++) {
			answer[i] = candidate[rand.nextInt(candidate.length)];
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Answer:" + Arrays.toString(answer));

		while (true) {

			System.out.println("Please guess");
			String guess = scanner.next();

			if (guess == null || guess.length() != answer.length) {
				System.out.println("Invalid answer");
				continue;
			}

			Map<String, Integer> answerCount = new HashMap<String, Integer>();
			for (String str : answer) {
				if (answerCount.containsKey(str))
					answerCount.put(str, answerCount.get(str) + 1);
				else
					answerCount.put(str, 1);
			}

			int ACount = 0;
			int BCount = 0;

			for (int i = 0; i < guess.length(); i++) {

				String ans = guess.substring(i, i + 1);

				if (answerCount.containsKey(ans) && answerCount.get(ans) > 0) {

					if (answer[i].equals(ans))
						ACount++;
					else
						BCount++;

					answerCount.put(ans, answerCount.get(ans) - 1);
				}
			}

			System.out.println(ACount + "A" + BCount + "B");

			if (ACount == answer.length)
				break;
		}

	}
}
