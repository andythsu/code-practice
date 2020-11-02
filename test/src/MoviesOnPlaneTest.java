import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Author asu
 * @Date 11/2/2020
 * @Description
 **/
public class MoviesOnPlaneTest {
    private MoviesOnPlane moviesOnPlane;

    @BeforeEach
    public void setUp() {
        moviesOnPlane = new MoviesOnPlane();
    }

    @Test
    @DisplayName("1 test case")
    public void test1() {
        int[] movieDurations = {90, 85, 75, 60, 120, 150, 125};
        int d = 250;
        int[] solution = moviesOnPlane.solution(movieDurations, d);
        Assertions.assertEquals(solution[0], 0);
        Assertions.assertEquals(solution[1], 6);
    }
}
