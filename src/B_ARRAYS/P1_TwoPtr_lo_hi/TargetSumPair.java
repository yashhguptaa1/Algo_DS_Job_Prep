package B_ARRAYS.P1_TwoPtr_lo_hi;

import java.util.Arrays;

public class TargetSumPair {

    public static void targetSumPair(int[] arr, int target) {
        Arrays.sort(arr);

        int lo = 0;
        int hi = arr.length - 1;

        while(lo < hi) {
            int sum = arr[lo] + arr[hi];

            if(sum == target) {
                System.out.println(arr[lo] + ", " + arr[hi]);
                lo++;
                hi--;
            } else if(sum > target) {
                hi--;
            } else {
                lo++;
            }
        }
    }

}

/*
Sample Input
12
9
-48
100
43
84
74
86
34
-37
60
-29
44
160
Sample Output
60, 100
74, 86
 */
