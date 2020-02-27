import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Author asu
 * @Date 2/26/2020
 * @Description
 **/
public class BuyAndSellStockTest {
    private BuyAndSellStock buyAndSellStock;

    @BeforeEach
    public void setup() {
        buyAndSellStock = new BuyAndSellStock();
    }

    @Test
    @DisplayName("[100, 200, 300] should return 200")
    public void test1() {
        int[] arr = {100, 200, 300};
        Assertions.assertEquals(200, buyAndSellStock.getMaxProfit(arr));
    }

    @Test
    @DisplayName("[150, 200, 100] should return 50")
    public void test2() {
        int[] arr = {150, 200, 100};
        Assertions.assertEquals(50, buyAndSellStock.getMaxProfit(arr));
    }

    @Test
    @DisplayName("[100, 20, 30, 50, 40, 100, 10] should return 80")
    public void test3() {
        int[] arr = {100, 20, 30, 50, 40, 100, 10};
        Assertions.assertEquals(80, buyAndSellStock.getMaxProfit(arr));
    }

}
