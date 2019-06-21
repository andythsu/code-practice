import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tsu
 * @since 2019-05-13
 */
class CoinChange {
    public static class Coin {
        int value;
        int amount;

        public Coin(int value, int amount) {
            this.value = value;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "value: " + this.value;
        }
    }

    public static void main(String[] args) {
        int target = 16;
        System.out.println("target: " + target);

        ArrayList<Coin> coins = new ArrayList<>(getArrayList());
        // sort descending
        coins.sort((Coin o1, Coin o2) -> o2.value - o1.value);
        ArrayList<Coin> greedyResult = new ArrayList<>();
        boolean isGreedyPossible = greedy(new ArrayList<>(coins), target, greedyResult);
        System.out.println("is greedy possible: " + isGreedyPossible);
        if (isGreedyPossible) System.out.println("greedy result: " + Arrays.toString(greedyResult.toArray()));

        ArrayList<Coin> coins2 = new ArrayList<>(getArrayList());
        // sort ascending
        coins2.sort((Coin o1, Coin o2) -> o1.value - o2.value);
        List<List<Coin>> backtrackResult = new ArrayList<>();
        backtrack(coins2, target, backtrackResult, new ArrayList<>());
        boolean isBackTrackPossible = backtrackResult.size() > 0;
        System.out.println("is backtrack possible: " + isBackTrackPossible);
        if (isBackTrackPossible) System.out.println("backtrack result: " + Arrays.toString(backtrackResult.toArray()));


        ArrayList<Coin> coins3 = new ArrayList<>(getArrayList());
        // sort ascending
        coins3.sort((Coin o1, Coin o2) -> o1.value - o2.value);
        System.out.println("number of ways by dp: " + dp(coins3, target));
    }

    public static int dp(List<Coin> coins, int target) {
        int[] table = new int[target + 1];
        Arrays.fill(table, 0);
        // base case, when target is 0, we have 1 way of changing 0 coin
        table[0] = 1;

        for (int i = 0; i < coins.size(); i++) {
            Coin currentCoin = coins.get(i);
            for (int j = 0; j < table.length; j++) {
                if (currentCoin.amount > 0 && currentCoin.value <= j) {
                    int oldTableValue = table[j];
                    table[j] = table[j] + table[j - currentCoin.value];
                    // only update amount of coins when table is altered
                    if (table[j] != oldTableValue) currentCoin.amount -= 1;
                }
            }
        }
        return table[target];
    }

    public static void backtrack(ArrayList<Coin> coins, int target, List<List<Coin>> result, ArrayList<Coin> temp) {
        if (target < 0) return;
        if (target == 0) result.add(new ArrayList<>(temp));
        for (int i = 0; i < coins.size(); i++) {
            Coin currentCoin = coins.get(i);
            if (currentCoin.amount > 0) {
                temp.add(currentCoin);
                currentCoin.amount -= 1;
                backtrack(coins, target - currentCoin.value, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean greedy(ArrayList<Coin> coins, int target, ArrayList<Coin> result) {
        if (coins == null) return false;

        int coinIndex = 0;
        while (target > 0 && coins.size() > coinIndex) {
            Coin c = coins.get(coinIndex);
            if (c.amount == 0 || c.value > target) {
                coinIndex++;
            } else {
                target = target - c.value;
                result.add(c);
                c.amount = c.amount - 1;
            }
        }
        return target == 0;
    }

    public static ArrayList<Coin> getArrayList() {
        ArrayList<Coin> coins = new ArrayList<Coin>() {{
            add(new Coin(1, 0));
            add(new Coin(2, 3));
            add(new Coin(5, 1));
            add(new Coin(10, 10));
        }};
        return new ArrayList<>(coins);
    }

}