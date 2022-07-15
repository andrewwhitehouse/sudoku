package com.oojamaflip;

public class SudokuGenerator {
    public static final int ROWS = 9;
    public static final int COLUMNS = 9;

    public static void main(String[] args) {
        printGrid(populate(newGrid()));
    }

    public int[] newGrid(int rows, int columns) {
        return new int[rows*columns];
    }

    public static int[] populate(int[] grid) {
        int[] newGrid = new int[grid.length];
        System.arraycopy(grid, 0, newGrid, 0, grid.length);
        for(int square=0; square < 9; square++) {
            int[] indexes = new int[] {
                    square*3,
                    square*3+1,
                    square*3+2,
                    square*3+9,
                    square*3+10,
                    square*3+11,
                    square*3+18,
                    square*3+10,
                    square*3+20
            };
            for(int i=0; i < indexes.length; i++) {
                newGrid[indexes[i]] = square+1;
            }
        }
        return newGrid;
    }

    public static int[] newGrid() {
        int ret[] = new int[81];
        return ret;
    }

    public static void printGrid(int[] grid) {
        for(int row=0; row < ROWS; row++) {
            for (int col=0; col < COLUMNS; col++) {
                int index = col+row*COLUMNS;
                if (grid[index] < 10) {
                    System.out.print(" ");
                }
                System.out.print(" " + grid[index]);
            }
            System.out.println();
        }
    }
}
