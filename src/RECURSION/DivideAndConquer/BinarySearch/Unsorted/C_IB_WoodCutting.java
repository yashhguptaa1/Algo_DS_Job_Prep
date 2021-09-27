package RECURSION.DivideAndConquer.BinarySearch.Unsorted;

public class C_IB_WoodCutting {

    public int solve(int[] A, int B) {

        int minCut = 0;
        int maxCut = 0;
        int optimalCut = 0;

        for (int x : A) {
            maxCut = Math.max(maxCut, x);
        }

        while (minCut <= maxCut) {
            int mid = minCut + (maxCut - minCut) / 2;
            long wood = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] - mid > 0) {
                    wood += A[j] - mid;
                }

            }
            if (wood >= (long) B) {
                minCut = mid + 1;
                optimalCut = Math.max(optimalCut, mid);
            } else {
                maxCut = mid - 1;
            }

        }

        return optimalCut;
    }
}
