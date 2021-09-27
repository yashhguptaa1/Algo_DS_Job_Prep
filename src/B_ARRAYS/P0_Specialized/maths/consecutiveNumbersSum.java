package B_ARRAYS.P0_Specialized.maths;

public class consecutiveNumbersSum {
    public int consecutiveNumberSum(int n) {
        int count = 0;
        for (int k = 1; k * (k - 1) < 2 * n; k++) {
            int numerator = n - (k * (k - 1) / 2);
            if (numerator % k == 0) {
                count++;
                // System.out.println(numerator / k + " " + k);
            }

        }
        return count;
    }
}
