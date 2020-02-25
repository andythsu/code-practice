import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author asu
 * @Date 2/25/2020
 * @Description given a string, you need to identify the starting and end point of each encrypted word, which are indicated by s and e
 * Every starting index needs to have an end index, but not every end index has a starting index
 * Example input :  ("abcsabce")
 * output:  [{3,7}]
 */
public class DecryptWord {
    public List<List<Integer>> decrypt(String str) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 's') queue.add(i);
            if (c == 'e' && !queue.isEmpty()) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(queue.remove());
                temp.add(i);
                result.add(temp);
            }
        }
        return result;
    }
}
