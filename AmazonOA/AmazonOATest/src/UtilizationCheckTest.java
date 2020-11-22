import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Author asu
 * @Date 11/21/2020
 * @Description
 **/
public class UtilizationCheckTest {
    private UtilizationCheck utilizationCheck;

    @BeforeEach
    public void setup() {
        utilizationCheck = new UtilizationCheck();
    }

    @Test
    @DisplayName("test 1")
    public void test1() {
        int instances = 5;
        int[] averageUtil = {30, 5, 4, 8, 19, 89};
        Assertions.assertEquals(3, utilizationCheck.solution(instances, averageUtil));
    }

    @Test
    @DisplayName("test 2")
    public void test2() {
        int instances = 1;
        int[] averageUtil = {5, 10, 80};
        Assertions.assertEquals(2, utilizationCheck.solution(instances, averageUtil));
    }
}
