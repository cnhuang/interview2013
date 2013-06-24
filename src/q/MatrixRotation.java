package q;

import java.util.Arrays;

import org.testng.annotations.Test;

import util.Question;

public class MatrixRotation extends Question {

	@Override
	public String getQuestion() {
		return "Crack code interview p101";
	}

	@Test
	public void RotationTest() {
		int N = 5;
		int[][] data = new int[N][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				data[i][j] = N * i + j + 1;

		System.out.println("Before Rotation");
		for (int i = 0; i < N; i++)
			System.out.println(Arrays.toString(data[i]));

		Rotation(data, N);

		System.out.println("After Rotation");
		for (int i = 0; i < N; i++)
			System.out.println(Arrays.toString(data[i]));
	}

	public void Rotation(int[][] data, int N) {
		for (int row = 0; row < N / 2; row++) {
			for (int col = row; col < N - row - 1; col++) {
				int width = N - 1;

				int tmp = data[row][col];
				data[row][col] = data[width - col][row];
				data[width - col][row] = data[width - row][width - col];
				data[width - row][width - col] = data[col][width - row];
				data[col][width - row] = tmp;
			}
		}
	}

	@Test
	public void RotationTest2() {
		int ROW = 6;
		int COL = 6;

		int[][] data = new int[ROW][COL];

		for (int i = 0; i < ROW; i++)
			for (int j = 0; j < COL; j++)
				data[i][j] = i * COL + j + 10;

		System.out.println("Before Rotation2");
		for (int i = 0; i < ROW; i++)
			System.out.println(Arrays.toString(data[i]));

		Rotation2(data, ROW, COL);

		System.out.println("After Rotation2");
		for (int i = 0; i < ROW; i++)
			System.out.println(Arrays.toString(data[i]));

	}

	public void Rotation2(int[][] data, int ROW, int COL) {

		for (int row = 0; row < ROW / 2; row++) {

			int rowStartIndex = row;
			int rowEndIndex = ROW - rowStartIndex - 1;
			int colStartIndex = row;
			int colEndIndex = COL - row - 1;
			// col is reduced by 2 (start+1, end-1)
			int colWidth = colEndIndex - colStartIndex + 1;

			//don't have to do the last element
			for (int col = 0; col < colWidth-1; col++) {

				// top
				int tmp = data[row][colStartIndex + col];

				// very right col to top
				Log("\n" + data[rowStartIndex + col][colEndIndex] + " to "
						+ data[row][colStartIndex + col]);
				data[row][colStartIndex + col] = data[rowStartIndex + col][colEndIndex];

				// to button to right
				Log(data[rowEndIndex][colEndIndex - col] + " to "
						+ data[rowStartIndex + col][colEndIndex]);
				data[rowStartIndex + col][colEndIndex] = data[rowEndIndex][colEndIndex
						- col];

				// left to button
				Log(data[rowEndIndex - col][colStartIndex] + " to "
						+ data[rowEndIndex][colEndIndex - col]);
				data[rowEndIndex][colEndIndex - col] = data[rowEndIndex - col][colStartIndex];

				Log(tmp + " to " + data[rowEndIndex - col][colStartIndex]);
				data[rowEndIndex - col][colStartIndex] = tmp;

			}
			
			System.out.println("\nBetween Rotation2");
			for (int i = 0; i < ROW; i++)
				System.out.println(Arrays.toString(data[i]));
		}

	}

}
