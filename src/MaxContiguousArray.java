import java.util.HashSet;
import java.util.Set;

/**
 * @Author asu
 * @Date 5/19/2020
 * @Description given a[], b[], and c[], find max contiguous array in a[] such that elements exist in b[] but not in c[]
 **/
public class MaxContiguousArray {
    public int[] findMaxContiguousArray(int[] a, int[] b, int[] c) {
        Set b_set = new HashSet();
        for (int bb : b) b_set.add(bb);
        Set c_set = new HashSet();
        for (int cc : c) c_set.add(cc);

        int j = a.length - 1;
        while (j >= 0) {
            int start = 0;
            for (int end = j; end < a.length; end++) {
                int[] newArray = formArray(a, start, end, b_set, c_set);
                if (newArray != null) return newArray;
                start++;
            }
            j--;
        }
        return new int[0];
    }

    private int[] formArray(int[] a, int start, int end, Set b, Set c) {
        int[] newArray = new int[end - start + 1];
        for (int i = start, newArrayIndex = 0; i <= end; i++, newArrayIndex++) {
            if (!b.contains(a[i]) || c.contains(a[i])) {
                return null;
            }
            newArray[newArrayIndex] = a[i];
        }
        return newArray;
    }
}
