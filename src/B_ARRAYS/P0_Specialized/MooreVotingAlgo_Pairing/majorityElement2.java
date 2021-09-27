package B_ARRAYS.P0_Specialized.MooreVotingAlgo_Pairing;

import java.util.*;

public class majorityElement2 {
    private boolean checkFreqM2(int[] arr, int val) {
        int count = 0;
        for (int e : arr) {
            if (e == val)
                count++;
        }
        return count > arr.length / 3;
    }

    public List<Integer> majorityElement(int[] arr) {
        // find valid candidates fore majority
        int val1 = arr[0];
        int count1 = 1; // count1 -> count of val1 for current window to make triplets

        int val2 = arr[0];
        int count2 = 0; // count2 -> count of val2 for current window to make triplets

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == val1) {
                count1++;
            } else if (arr[i] == val2) {
                count2++;
            } else {
                if (count1 == 0) {
                    val1 = arr[i];
                    count1 = 1;
                } else if (count2 == 0) {
                    val2 = arr[i];
                    count2 = 1;
                } else {
                    // triplet is found, reduce freq of val1 & val2 from count1 and count2
                    count1--;
                    count2--;
                }
            }
        }

        // check if it have freq more than n/3 using val1 and val2
        List<Integer> list = new ArrayList<>();
        boolean check1 = checkFreqM2(arr, val1);
        if (check1 == true)
            list.add(val1);

        if (val1 == val2)
            return list;

        boolean check2 = checkFreqM2(arr, val2);
        if (check2 == true)
            list.add(val2);

        return list;
    }

}
