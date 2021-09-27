package B_ARRAYS.P0_Specialized.sliding_window;

public class FirstNegativeIntEveryK {

    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        int indx = N;
        long[] res = new long[N - (K - 1)];

        // mark -ve in last k size window
        for (int i = N - 1; i >= N - K; i--) {
            if (A[i] < 0)
                indx = i;
        }

        // travel from N - K to 0 and set in result
        for (int i = N - K; i >= 0; i--) {

            // probable first negative in k sized window
            if (A[i] < 0)
                indx = i;

            // does the index where we met the negative integer most recently
            // does this index lies in k sized window formed after the current index
            if (indx < i + K) {
                res[i] = A[indx];
            } else {
                res[i] = 0;
            }
        }
        return res;
    }
}
/*
 * We start the loop from end so that we can find RESULT in single itertion =>
 * TC:O(n) if we start the loop from beginning of array, we would need second
 * loop to iterate over k window thus => TC :O(nk)
 */