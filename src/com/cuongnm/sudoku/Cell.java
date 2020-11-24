package com.cuongnm.sudoku;

public class Cell {
	private int row;
	private int col;
	private int value;

	public Cell() {
		this.row = 0;
		this.col = 0;
		this.value = 0;
	}

	public Cell(int row, int col, int value) {
		super();
		this.row = row;
		this.col = col;
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cell) {
			Cell cell = (Cell) obj;
			if (this.row == cell.row && this.col == cell.col && this.value == cell.value) {
				return true;
			}
		}
		return false;
	}

	public void printCell(Cell cell) {
		System.out.println("Row: " + cell.row + " ; Col: " + cell.col + " ; Value: " + cell.value);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static void main(String[] args) {
		Cell cell = new Cell(1, 2, 3);
		Cell otherCell1 = new Cell(1, 2, 3);
		Cell otherCell2 = new Cell(2, 2, 3);
		cell.printCell(otherCell2);
		System.out.println(cell.equals(otherCell1));
		System.out.println(cell.equals(otherCell2));
	}
}
