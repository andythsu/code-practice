import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @Author asu
 * @Date 11/21/2020
 * @Description
 **/
public class CutoffRanksTest {
    private CutoffRanks cutoffRanks;

    @BeforeEach
    public void setup() {
        cutoffRanks = new CutoffRanks();
    }

    @Test
    public void test1() {
        int cutOffRank = 3;
        int[] scores = {100, 2, 2, 2, 2, 2};
        Assertions.assertEquals(6, cutoffRanks.solution(cutOffRank, scores));
    }

    @Test
    public void test2() {
        int cutOffRank = 3;
        int[] scores = {100, 50, 50, 25};
        Assertions.assertEquals(3, cutoffRanks.solution(cutOffRank, scores));
    }
}
