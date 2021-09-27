package RECURSION.Type_R1_PrePhase.Print_Ans_in_PrePhase;

import java.util.Scanner;

public class C_DisplayArrayInReversePRE {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        PREprintDisplayArr(arr, n - 1);
    }

    public static void PREprintDisplayArr(int arr[], int idx) {
        if (idx < 0)
            return;

        System.out.println(arr[idx]);
        PREprintDisplayArr(arr, idx - 1);
    }
}
