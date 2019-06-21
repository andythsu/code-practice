import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two array and a target, find one element from each array that will sum to closest to target
 * @author tsu
 * @since 2019-06-20
 */
public class TwoArray {
    public static void main(String[] args){
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{6,7,8,9,10};
        int target = 17;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // iterate through arr1, find the remainder in arr2 using binary search
        Map<Integer, Integer> result = new HashMap<>();
        for(int i=0; i<arr1.length; i++){
            int remainder = target - arr1[i];
            int valueFoundInSecondArr = binarySearch(arr2, remainder);
            result.put(arr1[i], valueFoundInSecondArr);
        }

        // loop through the map, find the closest to target
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for(Integer key : result.keySet()){
            int value = result.get(key);
            int total = key + value;
            int absDiff = Math.abs(total - target);
            if(absDiff <= min){
                min = absDiff;
                answer[0] = key;
                answer[1] = value;
            }
        }
        System.out.println("array 1: " + Arrays.toString(arr1));
        System.out.println("array 2: " + Arrays.toString(arr2));
        System.out.println("target: " + target);
        System.out.println("closest to target: " + Arrays.toString(answer));
    }
    public static int binarySearch(int[] arr, int target){
        int l=0, r = arr.length - 1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(arr[m] == target){
                return arr[m];
            }
            if(arr[m] < target) {
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        // if we cannot find the needed value, find the closest using left and right
        int leftValue = l >= arr.length ? arr[arr.length - 1] : arr[l];
        int rightValue = r < 0 ? arr[0] : arr[r];
        if(Math.abs(target - leftValue) > Math.abs(target - rightValue)){
            return rightValue;
        }else{
            return leftValue;
        }
    }
}
