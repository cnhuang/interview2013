package q.leetcode;

import util.Question;

public class WordSearch extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a 2D board and a word, find if the word exists in the grid.
		 * 
		 * The word can be constructed from letters of sequentially adjacent
		 * cell, where "adjacent" cells are those horizontally or vertically
		 * neighboring. The same letter cell may not be used more than once.
		 * 
		 * For example, Given board =
		 * 
		 * [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns true,
		 * word = "SEE", -> returns true, word = "ABCB", -> returns false.
		 */
		return "http://leetcode.com/onlinejudge#question_79";
	}

	public boolean exist(char[][] board, String word) {

		if (word == null || word.length() == 0) {
			return true;
		}

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {

				if (exist(board, word, 0, visited, row, col))
					return true;
			}
		}

		return false;

	}

	public boolean exist(char[][] board, String word, int index, boolean[][] visited, int row,
			int col) {

		if (index == word.length())
			return true;

		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
			return false;

		if (visited[row][col])
			return false;

		if (word.charAt(index) == board[row][col]) {

			visited[row][col] = true;

			boolean exist = false;

			if (exist(board, word, index + 1, visited, row + 1, col))
				exist = true;

			else if (exist(board, word, index + 1, visited, row - 1, col))
				exist = true;

			else if (exist(board, word, index + 1, visited, row, col + 1))
				exist = true;

			else if (exist(board, word, index + 1, visited, row, col - 1))
				exist = true;

			visited[row][col] = false;

			return exist;
		} else {
			return false;
		}

	}
}
