package B_ARRAYS.P2_Store_left_right;

public class maxChunks2 {
    public int maxChunksToSorted2(int[] arr) {
        int n = arr.length;
        int chunks = 0;

        // prepare right min
        int[] rightMin = new int[n + 1];
        rightMin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        // solve count of using using a leftmax variable
        int leftmax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            leftmax = Math.max(leftmax, arr[i]);

            if (leftmax <= rightMin[i + 1])
                chunks++;
        }
        return chunks;
    }
}
