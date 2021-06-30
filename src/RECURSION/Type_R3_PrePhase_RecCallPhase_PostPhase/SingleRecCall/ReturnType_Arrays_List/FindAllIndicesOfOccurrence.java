package RECURSION.Type_R3_PrePhase_RecCallPhase_PostPhase.SingleRecCall.ReturnType_Arrays_List;

import java.io.*;

public class FindAllIndicesOfOccurrence {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());

        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int data, int idx, int count) {
        if (idx == arr.length) {
            return new int[count];
        }

        if (arr[idx] == data)
            count++;

        int[] ans = allIndices(arr, data, idx + 1, count);

        if (arr[idx] == data)
            ans[count - 1] = idx;

        return ans;
    }

}
