package com.oojamaflip;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GridTest {
    @Test
    void shouldGenerateGrid() {
        Grid grid = new Grid(2, 2, 2);
        String expected =
                "0  0  0  0\n" +
                "0  0  0  0\n" +
                "0  0  0  0\n" +
                "0  0  0  0\n";
        Assertions.assertEquals(expected, grid.toString());
    }
}
