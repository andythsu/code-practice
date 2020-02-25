import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author asu
 * @Date 2/25/2020
 */
public class DecryptWordTest {
    private DecryptWord decryptWord;

    @BeforeEach
    public void setup() {
        decryptWord = new DecryptWord();
    }

    @Test
    @DisplayName("abcsabce should return [[3, 7]]")
    public void test1() {
        List<List<Integer>> result = decryptWord.decrypt("abcsabce");
        String expected = "[[3, 7]]";
        Assertions.assertEquals(expected, Arrays.toString(result.toArray()));
    }

    @Test
    @DisplayName("ssacecae should return [[0, 4], [1, 7]]")
    public void test2() {
        List<List<Integer>> result = decryptWord.decrypt("ssacecae");
        String expected = "[[0, 4], [1, 7]]";
        Assertions.assertEquals(expected, Arrays.toString(result.toArray()));
    }

    @Test
    @DisplayName("abcsdee should return [[3, 5]]")
    public void test3() {
        List<List<Integer>> result = decryptWord.decrypt("abcsdee");
        String expected = "[[3, 5]]";
        Assertions.assertEquals(expected, Arrays.toString(result.toArray()));
    }
}
