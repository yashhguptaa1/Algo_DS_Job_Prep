package B_ARRAYS.P0_Specialized.case_formation;

import java.util.*;

public class minPlatforms {
    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0;
        int j = 0;
        int cmax = 0, omax = 0;
        while (i < n) {
            if (arr[i] <= dep[j]) {
                cmax++;
                i++;
            } else {
                cmax--;
                j++;
            }
            omax = Math.max(omax, cmax);
        }
        return omax;
    }

}
