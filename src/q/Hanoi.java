package q;

import java.util.Stack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class Hanoi extends Question {

	@Override
	public String getQuestion() {
		return "Hanoi";
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider="dataProvider")
	public void move(int size) {

		Stack<Integer>[] stacks = new Stack[3];

		for (int i = 0; i < stacks.length; i++)
			stacks[i] = new Stack<Integer>();

		for (int i = size; i > 0; i--)
			stacks[0].push(i);

		move(stacks[0].size(), stacks[0], stacks[2], stacks[1], stacks);

	}

	private void move(int size, Stack<Integer> from, Stack<Integer> to, Stack<Integer> buffer,
			Stack<Integer>[] stacks) {

		if (size == 1) {
			Integer i = from.pop();
			to.push(i);
			Log("\n[0]" + stacks[0].toString());
			Log("[1]" + stacks[1].toString());
			Log("[2]" + stacks[2].toString());
		} else {
			move(size - 1, from, buffer, to, stacks);
			move(1, from, to, buffer, stacks);
			move(size - 1, buffer, to, from, stacks);
		}
	}

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][] { { 5 } };
	}
}
