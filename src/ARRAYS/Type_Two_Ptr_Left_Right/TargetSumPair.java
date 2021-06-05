package ARRAYS.Type_Two_Ptr_Left_Right;

import java.util.Arrays;

public class TargetSumPair {

    public static void targetSumPair(int[] arr, int target) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            int sum = arr[left] + arr[right];

            if(sum == target) {
                System.out.println(arr[left] + ", " + arr[right]);
                left++;
                right--;
            } else if(sum > target) {
                right--;
            } else {
                left++;
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
