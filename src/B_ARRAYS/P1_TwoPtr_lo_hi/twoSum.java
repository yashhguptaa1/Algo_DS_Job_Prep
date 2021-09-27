package B_ARRAYS.P1_TwoPtr_lo_hi;

import java.util.*;

public class twoSum {

    public static List<List<Integer>> twoSum_(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            if (lo != 0 && arr[lo] == arr[lo - 1]) {
                lo++;
                continue;
            }
            int sum = arr[lo] + arr[hi];
            if (sum == target) {
                List<Integer> subres = new ArrayList<>();
                subres.add(arr[lo]);
                subres.add(arr[hi]);
                res.add(subres);

                lo++;
                hi--;
            } else if (sum > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return res;
    }
}
