import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author asu
 * @date 2/20/2020
 */
public class NumberToWordTest {
    private NumberToWord numberToWord;

    @BeforeEach
    public void setUp() {
        numberToWord = new NumberToWord();
    }

    @Test
    @DisplayName("17")
    public void test1() {
        int number = 17;
        Assertions.assertEquals("seventeen", numberToWord.convert(number));
    }

    @Test
    @DisplayName("117")
    public void test2() {
        int number = 117;
        Assertions.assertEquals("one seventeen", numberToWord.convert(number));
    }

    @Test
    @DisplayName("315")
    public void test3() {
        int number = 315;
        Assertions.assertEquals("three fifteen", numberToWord.convert(number));
    }
}
