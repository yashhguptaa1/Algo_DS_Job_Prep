package RECURSION.BACKTRACKING.Type1_PlaceUnplace;

import java.util.*;

public class kPartitions {

    // k-partition
    public static int count = 1;

    public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
        if (i > n) {
            if (ans.size() == k) {
                System.out.print(count + ". ");
                for (int j = 0; j < ans.size(); j++) {
                    ArrayList<Integer> list = ans.get(j);
                    System.out.print(list + " ");
                }
                System.out.println();
                count++;
            }
            return;
        }
        // n - 1, k work, add with previous options
        for (int j = 0; j < ans.size(); j++) {
            ArrayList<Integer> list = ans.get(j);
            list.add(i);
            solution(i + 1, n, k, rssf, ans);
            list.remove(list.size() - 1);
        }

        // n - 1, k - 1, start from myself if size + 1 <= k
        if (ans.size() + 1 <= k) {
            ArrayList<Integer> mres = new ArrayList<>();
            mres.add(i);
            ans.add(mres);
            solution(i + 1, n, k, rssf, ans);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // for(int i = 0; i < k; i++) {
        // ans.add(new ArrayList<>());
        // }
        solution(1, n, k, 0, ans);
        scn.close();
    }
}