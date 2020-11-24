package com.cuongnm.sudoku;

import java.util.Arrays;

public class Sudoku {

	private Cell[][] board = new Cell[9][9];

	public Sudoku() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new Cell(0, 0, j);
			}
		}
	}

	// inputCells la mang 2 chieu, phan tu mang la mang 1 chieu gom 3 phan tu (row,
	// col, value)
	public Sudoku(int[][] inputCells) {
		int row = -1;
		int col = -1;
		int value = -1;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = new Cell();
			}
		}
		for (int i = 0; i < inputCells.length; i++) {
			row = inputCells[i][0];
			col = inputCells[i][1];
			value = inputCells[i][2];
			board[row][col].setValue(value);
		}
	}

	public void printBoard(Cell[][] board) {
		System.out.println("START");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (j % 9 == 8) {
					System.out.print(board[i][j].getValue());
					System.out.println();
				} else {
					if (j % 3 == 2) {
						System.out.print(board[i][j].getValue() + "\t|\t");
					} else {
						System.out.print(board[i][j].getValue() + "\t");
					}
				}

			}
			if (i % 3 == 2) {
				System.out
						.println("----------------------------------------------------------------------------------");
			} else {
				System.out.println();
			}
		}
		System.out.println("END");
	}

	private boolean isRowValid(int row, int value) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][i].getValue() == value) {
				return false;
			}
		}
		return true;
	}

	private boolean isColValid(int col, int value) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col].getValue() == value) {
				return false;
			}
		}
		return true;
	}

	private boolean isRecValid(int row, int col, int value) {
		int r = 3 * (row / 3);
		int c = 3 * (col / 3);
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (board[i][j].getValue() == value) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(int row, int col, int value) {
		if (isColValid(col, value) && isRowValid(row, value) && isRecValid(row, col, value)) {
			return true;
		}
		return false;
	}

	public Cell[][] getBoard() {
		return board;
	}

	public void backtracking(int row, int col) {
		if (col == 9) {
			if (row == 8) {
				printBoard(this.board);
				return;
			} else {
				backtracking(row + 1, 0);
			}
		} else if (board[row][col].getValue() == 0) {
			for (int i = 1; i <= 9; i++) {
				if (isValid(row, col, i)) {
					board[row][col].setValue(i);
					backtracking(row, col + 1);
					board[row][col].setValue(0);
				}
			}
		} else {
			backtracking(row, col + 1);
		}
	}

	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku(new int[][] { { 0, 0, 5 }, { 0, 1, 3 }, { 0, 4, 7 }, { 1, 0, 6 }, { 1, 3, 1 },
				{ 1, 4, 9 }, { 1, 5, 5 }, { 2, 1, 9 }, { 2, 2, 8 }, { 2, 7, 6 }, { 3, 0, 8 }, { 3, 4, 6 }, { 3, 8, 3 },
				{ 4, 0, 4 }, { 4, 3, 8 }, { 4, 5, 3 }, { 4, 8, 1 }, { 5, 0, 7 }, { 5, 4, 2 }, { 5, 8, 6 }, { 6, 1, 6 },
				{ 6, 6, 2 }, { 6, 7, 8 }, { 7, 3, 4 }, { 7, 4, 1 }, { 7, 5, 9 }, { 7, 8, 5 }, { 8, 4, 8 }, { 8, 7, 7 },
				{ 8, 8, 9 } });

//		sudoku.printBoard(sudoku.getBoard());
//		System.out.println();
		sudoku.backtracking(0, 0);
	}
}
