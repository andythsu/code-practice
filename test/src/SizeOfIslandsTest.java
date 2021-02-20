import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author asu
 * @Date 2/20/2021
 * @Description
 **/
public class SizeOfIslandsTest {
    private SizeOfIslands sizeOfIslands;

    @BeforeEach
    public void setUp() {
        sizeOfIslands = new SizeOfIslands();
    }

    @Test
    public void test1() {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1},
        };
        displayGrid(grid);
        List<Integer> expected = Arrays.asList(4, 4, 2, 2);
        Assertions.assertEquals(expected, sizeOfIslands.count(grid));
    }


    @Test
    public void test2() {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        displayGrid(grid);
        List<Integer> expected = Arrays.asList(39, 18, 17, 13, 2);
        Assertions.assertEquals(expected, sizeOfIslands.count(grid));
    }

    private void displayGrid(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }
}
