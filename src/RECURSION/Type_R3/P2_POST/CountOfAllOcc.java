package RECURSION.Type_R3.P2_POST;

public class CountOfAllOcc {

    public static int countAllDataOcc(int[] arr, int idx, int data) {
        if (idx == arr.length)
            return 0;

        int recAns = countAllDataOcc(arr, idx + 1, data);
        return arr[idx] == data ? recAns + 1 : recAns;
    }

}
