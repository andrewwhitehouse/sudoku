package com.oojamaflip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {
    private int verticalBoxes;
    private int horizontalBoxes;
    private int boxSize;
    private int[] values;

    public Grid(int verticalBoxes, int horizontalBoxes, int boxSize) {
        this.verticalBoxes = verticalBoxes;
        this.horizontalBoxes = horizontalBoxes;
        this.boxSize = boxSize;
        initializeValues();

    }

    private void initializeValues() {
        values = new int[rowCount() * columnCount()];
    }

    public int getValue(int rowIndex, int colIndex) {
        return values[rowIndex * columnCount() + colIndex];
    }

    private void setValue(int rowIndex, int colIndex, int value) {
        values[rowIndex * columnCount() + colIndex] = value;
    }

    public int rowCount() {
        return verticalBoxes * boxSize;
    }

    public int columnCount() {
        return horizontalBoxes * boxSize;
    }

    public static Grid copy(Grid grid) {
        Grid newGrid = new Grid(grid.verticalBoxes, grid.horizontalBoxes, grid.boxSize);
        System.arraycopy(grid.values, 0, newGrid.values, 0, grid.values.length);
        return newGrid;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        int rowLength = horizontalBoxes * boxSize;
        for (int rowIndex = 0; rowIndex < verticalBoxes * boxSize; rowIndex++) {
            for (int colIndex = 0; colIndex < horizontalBoxes * boxSize; colIndex++) {
                buffer.append(values[rowIndex * rowLength + colIndex]);
                buffer.append(colIndex == horizontalBoxes * boxSize - 1 ? "\n" : "  ");
            }
        }
        return buffer.toString();
    }

    private boolean columnContainsValue(int colIndex, int value) {
        for (int rowIndex = 0; rowIndex < rowCount(); rowIndex++) {
            if (getValue(rowIndex, colIndex) == value) {
                return true;
            }
        }
        return false;
    }

    private boolean rowContainsValue(int rowIndex, int value) {
        for (int colIndex = 0; colIndex < columnCount(); colIndex++) {
            if (getValue(rowIndex, colIndex) == value) {
                return true;
            }
        }
        return false;
    }

    public List<Grid> populate(int boxIndex, int value) {
        int topLeftColumnIndex = (boxIndex % horizontalBoxes) * boxSize;
        int topLeftRowIndex = (boxIndex / verticalBoxes) * boxSize;
        List<Position> availablePositions = new ArrayList();
        for (int rowIndex = 0; rowIndex < boxSize; rowIndex++) {
            for (int colIndex = 0; colIndex < boxSize; colIndex++) {
                int tmpValue = getValue(rowIndex + topLeftRowIndex,
                        colIndex + topLeftColumnIndex);
                if (tmpValue == 0
                        && !columnContainsValue(colIndex+topLeftColumnIndex, value)
                        && !rowContainsValue(rowIndex+topLeftRowIndex, value)) {
                    availablePositions.add(new Position(rowIndex+topLeftRowIndex,
                            colIndex+topLeftColumnIndex));
                }
            }
        }
        List<Grid> grids = new ArrayList<>();
        availablePositions.forEach(position -> {
            Grid newGrid = copy(this);
            newGrid.setValue(position.getRow(), position.getColumn(), value);
            grids.add(newGrid);
        });
        return grids;
    }

    public static Grid generate() {
        Grid grid = new Grid(3, 3, 3);
        for(int boxIndex=0; boxIndex < grid.horizontalBoxes*grid.verticalBoxes; boxIndex++) {
            grid = grid.populate(boxIndex, 1).get(0);
        }
        List<Grid> grids = Arrays.asList(grid);
        for(int value=2; value <= 9; value++) {
            List<Grid> newList = new ArrayList<>();
            for(Grid g: grids) {
                for(int boxIndex=1; boxIndex < grid.verticalBoxes*grid.horizontalBoxes; boxIndex++) {
                    newList.addAll(g.populate(boxIndex, value));
                }
            }
            grids = newList;
        }
        return grids.get(0);
    }

    static class Position {
        private int row;
        private int column;

        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }
}
