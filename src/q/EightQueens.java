package q;

import static org.testng.AssertJUnit.assertEquals;
import java.util.Arrays;

import org.testng.annotations.Test;

import util.Question;

public class EightQueens extends Question {

	/*
	 * http://www.careercup.com/question?id=13014684
	 * 
	 * Write an Algorithm and then code for N Queens problem. If there is no
	 * solution print "No Solution" or else print the board giving out positions
	 * of Queens on the board
	 */

	@Override
	public String getQuestion() {
		return "http://www.careercup.com/question?id=13014684";
	}

	int solutions;

	@Test
	public void find() {

		solutions = 0;
		char[][] board = new char[8][8];
		for (int i = 0; i < 8; i++)
			Arrays.fill(board[i], ' ');
		boolean[] rowAvail = new boolean[8];
		Arrays.fill(rowAvail, true);

		find(0, board, rowAvail);

		assertEquals(92, solutions);
	}

	private void find(int colIndex, char[][] board, boolean[] rowAvail) {

		if (colIndex == rowAvail.length) {
			Log("\n\nFound");
			for (int row = 0; row < board.length; row++) {
				Log(Arrays.toString(board[row]));
			}
			solutions++;
			return;
		}

		for (int i = 0; i < rowAvail.length; i++) {

			if (rowAvail[i]) {

				boolean pass = true;
				for (int j = colIndex - 1; j >= 0; j--) {

					int leftUpperIndex = i - (colIndex - j);

					if (leftUpperIndex >= 0)
						if (board[leftUpperIndex][j] == 'Q') {
							pass = false;
							break;
						}

					int leftLowerIndex = i + (colIndex - j);
					if (leftLowerIndex < rowAvail.length)
						if (board[leftLowerIndex][j] == 'Q') {
							pass = false;
							break;
						}

				}

				if (pass) {
					rowAvail[i] = false;
					board[i][colIndex] = 'Q';
					find(colIndex + 1, board, rowAvail);
					rowAvail[i] = true;
					board[i][colIndex] = ' ';
				}
			}
		}

	}
}
