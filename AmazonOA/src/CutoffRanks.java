import java.util.Arrays;

/**
 * @Author asu
 * @Date 11/21/2020
 * @Description https://aonecode.com/amazon-online-assessment-cutoff-ranks
 **/
public class CutoffRanks {
    public int solution(int cutOffRank, int[] scores) {
        Arrays.sort(scores);
        scores = reverseArray(scores);
        int curScore = scores[0];
        scores[0] = 1;
        int curRank = 1;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] != curScore) {
                curRank = i + 1;
                curScore = scores[i];
            }
            scores[i] = curRank;
        }
        int res = 0;
        for (int rank : scores) {
            if (rank <= cutOffRank) {
                res++;
            }
        }
        return res;
    }

    private int[] reverseArray(int[] arr) {
        int length = arr.length - 1;
        int[] reversedArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            reversedArray[length - i] = arr[i];
        }
        return reversedArray;
    }
}
