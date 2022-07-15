package com.oojamaflip;

public class Grid {
    private int verticalBoxes;
    private int horizontalBoxes;
    private int boxSize;
    private int[] values;

    public Grid(int verticalBoxes, int horizontalBoxes, int boxSize) {
        this.verticalBoxes = verticalBoxes;
        this.horizontalBoxes = horizontalBoxes;
        this.boxSize = boxSize;
        values = new int[(verticalBoxes*boxSize)*(horizontalBoxes*boxSize)];
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for(int rowIndex=0; rowIndex < verticalBoxes*boxSize; rowIndex++) {
            for(int colIndex=0; colIndex < horizontalBoxes*boxSize; colIndex++) {
                buffer.append(values[rowIndex*colIndex]);
                buffer.append(colIndex == horizontalBoxes*boxSize-1 ? "\n" : "  ");
            }
        }
        return buffer.toString();
    }

//    public Grid populate(int boxIndex, int value, IntSelector selector) {
//        Grid newGrid = new Grid(verticalBoxes, horizontalBoxes, boxSize);
//        int topLeftColumnIndex = boxIndex*horizontalBoxes*boxIndex;
//        int topLeftRowIndex = boxIndex*verticalBoxes*boxIndex;
//        newGrid.values[]
//    }
}
