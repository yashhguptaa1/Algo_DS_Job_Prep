package B_ARRAYS.P0_Specialized.combine_patterns;

public class maximumSwap {
    public int maxSwap(int n) {
        String num = n + "";
        // convert number into string
        char[] arr = num.toCharArray();

        int[] lastIndxOfDigit = new int[10];
        // travel and fill last index of digits
        for (int i = 0; i < arr.length; i++) {
            lastIndxOfDigit[arr[i] - '0'] = i;
        }

        // travel and find swapping point
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';
            int indx = i;
            for (int j = 9; j > digit; j--) {
                // greater digit have max index then set it in indx and break
                if (lastIndxOfDigit[j] > i) {
                    indx = lastIndxOfDigit[j];
                    break;
                }
            }
            if (indx != i) {
                swap(arr, i, indx);
                break;
            }
        }
        String res = String.valueOf(arr);
        // convert string into number
        return Integer.parseInt(res);
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
