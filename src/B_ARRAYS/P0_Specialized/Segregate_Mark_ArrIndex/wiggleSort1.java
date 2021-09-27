package B_ARRAYS.P0_Specialized.Segregate_Mark_ArrIndex;

public class wiggleSort1 {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void wiggleSort(int[] arr) {

        // a <= c >= b
        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0) {
                // even index
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            } else {
                // odd index
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }
}
