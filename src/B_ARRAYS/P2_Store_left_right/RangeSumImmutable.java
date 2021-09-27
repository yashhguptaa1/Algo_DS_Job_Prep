package B_ARRAYS.P2_Store_left_right;

import java.util.*;

public class RangeSumImmutable {
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {
        // code here
        List<Integer> allQueries = new ArrayList<>();

        int sumSoFar[] = new int[n];
        sumSoFar[0] = arr[0];

        // 1 2 3 4
        for (int i = 1; i < n; i++) {
            sumSoFar[i] = arr[i] + sumSoFar[i - 1];
        }
        // 1 3 6 10

        for (int i = 0; i < q; i++) {
            int l = queries[(2 * i)];
            int r = queries[(2 * i + 1)];
            int res = 0;

            // System.out.println("l" +l);
            // System.out.println("r" +r);
            if (r - 1 >= 0) {
                res = sumSoFar[r - 1];
                // System.out.println("res" + res);

                if (l - 1 - 1 >= 0) {
                    res = res - sumSoFar[l - 2];
                    // System.out.println("res" + res);

                }
            }
            allQueries.add(res);
        }
        return allQueries;
    }

}
