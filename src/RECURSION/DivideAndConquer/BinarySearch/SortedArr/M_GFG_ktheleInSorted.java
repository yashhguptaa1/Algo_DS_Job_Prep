package RECURSION.DivideAndConquer.BinarySearch.SortedArr;

public class M_GFG_ktheleInSorted {

    public long kthElement(int arr1[], int arr2[], int n, int m, int k) {

        // ensure binary search chote vale array pr lgaye
        if (n > m) {
            return kthElement(arr2, arr1, m, n, k);
        }

        // low = if k-m becomes negative , it must have atleast 0 value
        // high = if k is less than size of second array
        // we want only k elements
        int low = Math.max(0, k - m), high = Math.min(k, n);

        while (low <= high) {
            int cut1 = (low + high) >> 1;

            // instead of considering the combined both arrays
            // we only consider k elements combined
            int cut2 = k - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

            // in the combined array the last element will be the kth element
            // since we are not combining we are checking the max of the l1 and l2
            // toc check the last element of the left half of combined sorted array
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 1;
    }

    public int kthElementBrute(int arr1[], int arr2[], int n, int m, int k) {

        int count = 0;
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                count++;

                if (count == k)
                    return arr1[i];

                i++;
            } else {
                count++;

                if (count == k)
                    return arr2[j];

                j++;

            }
        }

        while (i < n) {
            count++;

            if (count == k)
                return arr1[i];

            i++;
        }

        while (j < m) {
            count++;

            if (count == k)
                return arr2[j];

            j++;
        }
        return -1;
    }
}
