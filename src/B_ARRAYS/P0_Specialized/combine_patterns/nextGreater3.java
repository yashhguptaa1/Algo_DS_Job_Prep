package B_ARRAYS.P0_Specialized.combine_patterns;

public class nextGreater3 {

    // When iterating from end of array find element
    // which is responsible for shifting from increasing order to decreasing order
    private static int dipIndex(char[] arr) {
        int indx = arr.length - 2;
        while (indx >= 0 && (arr[indx] >= arr[indx + 1])) {
            indx--;
        }
        return indx;
    }

    // When iterating from end of array find element
    // which is just greater than arr[dipIndex] and as rightmost as possible
    private static int ceilIndex(char[] arr, int indx) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > arr[indx]) {
                return i;
            }
        }
        return -1;
    }

    private static void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static void reverse(char[] arr, int indx) {
        int left = indx;
        int right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public static String nextGreaterElement_(String str) {

        // BC
        if (str.length() == 1)
            return "-1";
        char[] arr = str.toCharArray();

        // Step 1
        int dipIndx = dipIndex(arr);
        if (dipIndx == -1) {
            return "-1";
        }

        // Step 2
        int ceilIndx = ceilIndex(arr, dipIndx);

        // Step 3
        swap(arr, dipIndx, ceilIndx);

        // Step 4
        reverse(arr, dipIndx + 1);

        return String.valueOf(arr);
    }

    // for leetcode, above problem
    public int nextGreaterElement(int n) {
        String str = n + "";
        String res_ = nextGreaterElement_(str);
        long res = Long.parseLong(res_);
        if (res <= Integer.MAX_VALUE) {
            return (int) res;
        } else {
            return -1;
        }
    }
}
