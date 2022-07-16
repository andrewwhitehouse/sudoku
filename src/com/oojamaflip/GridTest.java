package com.oojamaflip;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GridTest {
    @Test
    void shouldGenerateGrid() {
        Grid grid = new Grid(2, 2, 2);
        int[][] expected = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        Assertions.assertArrayEquals(expected, toArray(grid));
    }

    @Test
    void shouldPopulateFirstBoxes() {
        List<Grid> grids = new Grid(2, 2, 2)
                .populate(0, 1);
        assertEquals(4, grids.size());
    }

    @Test
    void shouldGetResult() {
        Grid grid = Grid.generate();
        assertNotNull(grid);
    }

//    @Test
//    void shouldPopulateAllBoxes() {
//        Grid grid = new Grid(2, 2, 2)
//                .populate(0, 1)
//                .populate(1, 1)
//                .populate(2, 1)
//                .populate(3, 1);
//
//        int[][] expected = new int[][]{
//                {1, 0, 0, 0},
//                {0, 0, 1, 0},
//                {0, 1, 0, 0},
//                {0, 0, 0, 1}
//        };
//        System.out.println(grid.toString());
//        Assertions.assertArrayEquals(expected, toArray(grid));
//    }

//    @Test
//    void shouldPopulateNineByNineGrid() {
//        Grid grid = new Grid(3, 3, 3);
//        for(int value=1; value <= 9; value++) {
//            for(int boxIndex=0; boxIndex < 9; boxIndex++) {
//                grid = grid.populate(boxIndex, value);
//            }
//        }
//        System.out.println(grid.toString());
//        assertEquals(1, grid.getValue(0, 0));
//    }

    private int[][] toArray(Grid grid) {
        int ret[][] = new int[grid.rowCount()][grid.columnCount()];
        for(int rowIndex=0; rowIndex < grid.rowCount(); rowIndex++) {
            for(int colIndex=0; colIndex< grid.columnCount(); colIndex++) {
                ret[rowIndex][colIndex] = grid.getValue(rowIndex, colIndex);
            }
        }
        return ret;
    }
}
