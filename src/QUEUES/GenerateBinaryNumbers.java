package QUEUES;

import java.util.*;
public class GenerateBinaryNumbers {

    // gfg -> generateBinary link :
    // https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1
    public static ArrayList<String> generate(int n) {
        ArrayList<String> res = new ArrayList<>();

        Queue<String> qu = new ArrayDeque<>();

        qu.add("1");

        for (int i = 0; i < n; i++) {
            String rem = qu.remove();

            res.add(rem);
            qu.add(rem + "0");
            qu.add(rem + "1");
        }
        return res;
    }
}
