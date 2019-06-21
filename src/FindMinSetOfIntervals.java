import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * given list of intervals, find the minimum set that covers all intervals
 * <p>
 * Copyright © 2019, Oracle and/or its affiliates. All rights reserved.
 *
 * @author tsu
 * @since 2019-06-21
 */
public class FindMinSetOfIntervals {
    private static class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString(){
            return "["+start+","+end+"]";
        }
    }
    public static void main(String[] args){
        /* test case 1 */
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,5));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(3,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(6,9));
        find(intervals);

        /* test case 2 */
        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(1,5));
        intervals2.add(new Interval(2,4));
        intervals2.add(new Interval(4,8));
        find(intervals2);

        /* test case 3 */
        List<Interval> intervals3 = new ArrayList<>();
        intervals3.add(new Interval(0,5));
        intervals3.add(new Interval(0,4));
        intervals3.add(new Interval(7,9));
        intervals3.add(new Interval(6,10));
        find(intervals3);

        /* test case 4 */
        List<Interval> intervals4 = new ArrayList<>();
        intervals4.add(new Interval(0,3));
        intervals4.add(new Interval(5,7));
        intervals4.add(new Interval(2,4));
        intervals4.add(new Interval(8,10));
        find(intervals4);

    }

    public static void find(List<Interval> intervals){
        // sort the intervals by ascending order
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        List result = new ArrayList<>();
        int min = intervals.get(0).start;
        int max = intervals.get(0).end;
        for(int i=1; i<intervals.size(); i++){
            int currentStart = intervals.get(i).start;
            int currentEnd = intervals.get(i).end;
            // if start of next interval intersects with previous or right on, update "max end"
            if(max >= currentStart){
                max = Math.max(max, currentEnd);
            }
            // else create a new interval
            else{
                result.add(new Interval(min, max));
                max = currentEnd;
                min = currentStart;
            }
        }
        // add the last case
        result.add(new Interval(min,max));
        System.out.println("result: " + Arrays.toString(result.toArray()));
    }
}
