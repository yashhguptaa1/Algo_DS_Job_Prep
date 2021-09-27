package B_ARRAYS.Type_Sorting;

import java.util.*;

public class mergeIntervals {
    public int[][] merge(int[][] intervals) {

        // Sorting on basis of starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // not sure the number of intervals
        // how to make list of arrays
        ArrayList<ArrayList<Integer>> merged = new ArrayList<>();

        // add first interval
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(intervals[0][0]);
        temp.add(intervals[0][1]);
        merged.add(temp);

        for (int i = 1; i < intervals.length; i++) {
            ArrayList<Integer> prevMergedInterval = merged.get(merged.size() - 1);

            if (intervals[i][0] <= prevMergedInterval.get(1)) {
                // new points for merged interval
                int newStartPoint = prevMergedInterval.get(0);
                int newEndPoint = Math.max(intervals[i][1], prevMergedInterval.get(1));

                // remove old interval
                merged.remove(prevMergedInterval);

                // add new merged interval
                ArrayList<Integer> temp2 = new ArrayList<>();
                temp2.add(newStartPoint);
                temp2.add(newEndPoint);
                merged.add(temp2);
            } else {
                // add new interval to merged list
                ArrayList<Integer> temp2 = new ArrayList<>();
                temp2.add(intervals[i][0]);
                temp2.add(intervals[i][1]);
                merged.add(temp2);
            }
        }

        int res[][] = new int[merged.size()][2];

        for (int i = 0; i < merged.size(); i++) {
            res[i][0] = merged.get(i).get(0);
            res[i][1] = merged.get(i).get(1);

        }
        return res;
    }
}
