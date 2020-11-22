import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author asu
 * @Date 11/2/2020
 * @Description https://leetcode.com/discuss/interview-question/313719/Amazon-or-Online-Assessment-2019-or-Movies-on-Flight
 **/
public class MoviesOnPlane {
    public int[] solution(int[] durations, int flight) {
        int[] answer = new int[2];
        int target = flight - 30;
        if (target < 30) {
            return null;
        }
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < durations.length; i++) {
            list.add(new Pair(i, durations[i]));
        }

        // sort ascending
        Collections.sort(list, (Pair p1, Pair p2) -> p1.value - p2.value);

        int left = 0;
        int right = list.size() - 1;
        int max = 0;
        while (left < right) {
            int sum = list.get(left).value + list.get(right).value;
            if (sum > target) {
                right--;
            } else {
                // check duplicate
                if (sum == max) {
                    if (answer[1] < list.get(right).index) {
                        answer[0] = list.get(left).index;
                        answer[1] = list.get(right).index;
                    }
                } else if (sum > max) {
                    answer[0] = list.get(left).index;
                    answer[1] = list.get(right).index;
                }
                left++;
            }
        }
        return answer;
    }

    class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
