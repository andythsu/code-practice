import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Author asu
 * @Date 5/19/2020
 * @Description
 **/
public class MaxContiguousArrayTest {
    MaxContiguousArray maxContiguousArray;

    @BeforeEach
    public void setup() {
        maxContiguousArray = new MaxContiguousArray();
    }

    @Test
    @DisplayName("test 1")
    public void test1() {
        int[] a = {1, 2, 3};
        int[] b = {2, 3};
        int[] c = {2};
        int[] expected = {3};
        int[] actual = maxContiguousArray.findMaxContiguousArray(a, b, c);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("test 2")
    public void test2() {
        int[] a = {1, 2, 3};
        int[] b = {2, 3};
        int[] c = {};
        int[] expected = {2, 3};
        int[] actual = maxContiguousArray.findMaxContiguousArray(a, b, c);
        Assertions.assertArrayEquals(expected, actual);
    }
}
