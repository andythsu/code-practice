import org.junit.jupiter.api.*;

/**
 * @author tsu
 * @since 2019-07-03
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MinGasStationTest {

    private MinGasStation minGasStation;

    @BeforeAll
    public void setUp(){
        minGasStation = new MinGasStation();
    }

    @Test
    @DisplayName("1 trip")
    public void test1(){
        int[] gasStations = new int[]{1,2,3,4,5};
        int[] gasAvailable = new int[]{1,2,3,4,5};
        int capacity = 16;
        int result = minGasStation.solution(gasStations, gasAvailable, capacity);
        Assertions.assertEquals(1, result);
    }

    @Test
    @DisplayName("no answer")
    public void test2(){
        int[] gasStations = new int[]{1,2,3,4,5};
        int[] gasAvailable = new int[]{1,2,3,4,5};
        int capacity = 3;
        int result = minGasStation.solution(gasStations, gasAvailable, capacity);
        Assertions.assertEquals(-1, result);
    }

    @Test
    @DisplayName("2 trips")
    public void test3(){
        int[] gasStations = new int[]{5,20,1,2,3};
        int[] gasAvailable = new int[]{5,50,7,8,9};
        int capacity = 25;
        int result = minGasStation.solution(gasStations, gasAvailable, capacity);
        Assertions.assertEquals(2, result);
    }
}
