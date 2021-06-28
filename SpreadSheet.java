package com.company;

public class SpreadSheet {

    private final int numRows;
    private final int numCols;
    private final Cell[][] cells;

    public SpreadSheet(int rows, int cols) {
        numRows = rows;
        numCols = cols;
        cells = new Cell[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int row, int col) {
        if (0 <= row && row < numRows && 0 <= col && col < numCols) {
            return cells[row][col];
        }
        return null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result.append(cells[i][j].getValue()).append('\t');
            }
            result.append('\n');
        }
        return result.toString();
    }
}
