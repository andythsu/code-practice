import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

/**
 * test class for CoinChange
 * @author tsu
 * @since 2019-06-27
 */
public class CoinChangeTest {

    private List<CoinChange.Coin> coins;
    private int target;
    private CoinChange coinChange;

    @BeforeEach
    public void setup(){
        coins = new ArrayList<CoinChange.Coin>() {{
            add(new CoinChange.Coin(1, 0));
            add(new CoinChange.Coin(2, 3));
            add(new CoinChange.Coin(5, 1));
            add(new CoinChange.Coin(10, 10));
        }};

        target = 16;

        coinChange = new CoinChange();
    }
    @Test
    @DisplayName("target is 16 should only have 1 answer")
    public void test1(){
        int result = coinChange.dp(coins, target);
        Assertions.assertTrue(result > 0);
        Assertions.assertEquals(1, result);
    }

}
