import java.util.ArrayList;
import java.util.List;

/**
 * @Author asu
 * @Date 2/20/2021
 * @Description Given a 2d array made of 1s and 0s,  return the sizes of each island in descending order
 * an island is defined as 0's that are surrounding by 1's
 **/
public class SizeOfIslands {
    public List<Integer> count(int[][] grid) {
        List<Integer> sizes = new ArrayList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int[] size = {0};
                if (grid[r][c] == 0) {
                    dfs(grid, r, c, size);
                    sizes.add(size[0]);
                }
            }
        }
        sizes.sort((o1, o2) -> o2 - o1);
        return sizes;
    }

    private void dfs(int[][] grid, int r, int c, int[] size) {
        // check wall or visited
        if (grid[r][c] != 0) return;
        // check bounds
        if (r < 0 || r > grid.length || c < 0 || c > grid[r].length) return;

        grid[r][c] = 2; // set to 2 if visited
        size[0]++;

        dfs(grid, r, c + 1, size); // right
        dfs(grid, r + 1, c, size); // down
        dfs(grid, r, c - 1, size); // left
        dfs(grid, r - 1, c, size);// up
    }
}
