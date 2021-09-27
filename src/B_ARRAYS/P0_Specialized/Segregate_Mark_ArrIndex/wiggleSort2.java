package B_ARRAYS.P0_Specialized.Segregate_Mark_ArrIndex;

import java.util.*;

public class wiggleSort2 {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n]; // dupliicate array

        for (int i = 0; i < n; i++)
            arr[i] = nums[i];

        Arrays.sort(arr);

        int j = n - 1;
        int i = 1;

        // fill odd index
        while (i < n) {
            nums[i] = arr[j];
            j--;
            i += 2;
        }

        // fill even index
        i = 0;
        while (i < n) {
            nums[i] = arr[j];
            j--;
            i += 2;
        }
    }

}
