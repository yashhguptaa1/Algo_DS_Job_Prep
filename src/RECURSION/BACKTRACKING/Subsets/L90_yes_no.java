package RECURSION.BACKTRACKING.Subsets;

import java.util.*;

public class L90_yes_no {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        // map duplicateItem to lastBoxNumber visited
        // basically we want to store which boxnumber selected current duplicate item
        // when we get duplicate item again we must ensure a different box should select
        // current duplicateItem
        // since its combination we only give chance to boxnumber greater than last one
        // sorted order me lga rhe he vrna permutation bn jayegi
        HashMap<Integer, Integer> i2b = new HashMap<>();

        for (int x : nums) {
            i2b.put(x, -1);
        }

        System.out.println(i2b);
        combinations(0, new ArrayList<>(), i2b, res, nums);
        return res;
    }

    public void combinations(int currIdx, List<Integer> asf, HashMap<Integer, Integer> i2b, List<List<Integer>> res,
            int nums[]) {
        if (currIdx == nums.length) {
            res.add(new ArrayList<>(asf));
            return;
        }

        int loi = i2b.get(nums[currIdx]);
        if (loi != asf.size()) {
            // YES

            // MARK
            asf.add(nums[currIdx]);
            i2b.put(nums[currIdx], currIdx);

            // LEVEL
            combinations(currIdx + 1, asf, i2b, res, nums);

            // UNMARK
            asf.remove(asf.size() - 1);
            i2b.put(nums[currIdx], -1);

            // NO
            combinations(currIdx + 1, asf, i2b, res, nums);
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 2 };
        L90_yes_no r = new L90_yes_no();
        System.out.println(r.subsetsWithDup(nums));

    }
}
