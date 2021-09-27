package B_ARRAYS.P1_TwoPtr_lo_hi;

import java.util.*;

public class threeSum {

    public static List<List<Integer>> threeEleSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int val1 = nums[i];
            int smallTarget = target - val1;

            List<List<Integer>> subres = twoSum(nums, i + 1, nums.length - 1, smallTarget);
            for (List<Integer> list : subres) {
                list.add(val1);
                res.add(list);
            }
        }
        return res;
    }

    private static List<List<Integer>> twoSum(int[] arr, int st, int end, int target) {
        int lo = st;
        int hi = end;
        List<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            if (lo != st && arr[lo] == arr[lo - 1]) {
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
