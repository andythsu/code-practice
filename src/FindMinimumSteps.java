import java.util.Arrays;

/**
 * @author: Andy Su
 * @since: 2019-11-05
 * @description: given a matrix, find minimum steps to reach the end
 */
public class FindMinimumSteps {
    public static int SHORTEST_COUNT = Integer.MAX_VALUE;
    public static char[][] SHORTEST_PATH = null;
    public static void main(String[] args){
        char[][] map = {
                {'S', 'x', 'E'},
                {' ', ' ', ' '},
                {' ', 'x', ' '}
        };
        bfs(map);
        System.out.println(SHORTEST_COUNT);
        print(SHORTEST_PATH);
    }
    public static int bfs(char[][] map){
        // locate the starting point
        for(int r=0; r<map.length; r++){
            for(int c=0; c<map[r].length; c++){
                if(map[r][c] == 'S'){
                    traverse(map, r, c, 0);
                }
            }
        }
        // cannot locate the starting point, so 0 possibilities
        return 0;
    }

    private static boolean isOutOfBound(int r, int c, char[][] map) {
        return r < 0 || r >= map.length || c < 0 || c >= map[r].length;
    }

    private static void print(char[][] visited) {
        for(char[] v : visited){
            System.out.println(Arrays.toString(v));
        }
    }

    public static void traverse(char[][] map, int r, int c, int minPath){
        if(isOutOfBound(r, c, map) ||
                map[r][c] == 'x' ||
                map[r][c] == 'v')
            return;

        if(map[r][c] == 'E') {
            if(minPath < SHORTEST_COUNT){
                SHORTEST_COUNT = minPath;
                SHORTEST_PATH = deepCopy(map);
            }
        }

        char[] oldValues = new char[4];

        map[r][c] = 'v';

        if(!isOutOfBound(r,c-1, map)) oldValues[0] = map[r][c-1];
        traverse(map, r, c-1, minPath + 1);
        if(!isOutOfBound(r,c-1, map)) map[r][c-1] = oldValues[0];

        if(!isOutOfBound(r,c+1, map)) oldValues[1] = map[r][c+1];
        traverse(map, r, c+1, minPath + 1);
        if(!isOutOfBound(r,c+1, map)) map[r][c+1] = oldValues[1];

        if(!isOutOfBound(r+1,c, map)) oldValues[2] = map[r+1][c];
        traverse(map, r+1, c, minPath + 1);
        if(!isOutOfBound(r+1,c, map)) map[r+1][c] = oldValues[2];

        if(!isOutOfBound(r-1,c, map)) oldValues[3] = map[r-1][c];
        traverse(map, r-1, c, minPath + 1);
        if(!isOutOfBound(r-1,c, map)) map[r-1][c] = oldValues[3];
    }

    private static char[][] deepCopy(char[][] map) {
        char[][] copy = new char[map.length][map[0].length];
        for(int r=0; r<copy.length; r++){
            for(int c=0; c<copy[r].length; c++){
                copy[r][c] = map[r][c];
            }
        }
        return copy;
    }
}
