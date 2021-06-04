package STACKS.Category_S1;

import java.util.*;
public class CelebrityProblem {

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        // elimination
        while (st.size() > 1) {
            int i = st.pop();
            int j = st.pop();

            //Since i can never be a celebrity
            // j is a possible celebrity
            //So we push all the posibilities in stack
            //and eliminate or not push in stack that can never be a possiblity
            if (arr[i][j] == 1) {
                // i is not celebrity
                st.push(j);
            } else {
                // j is not celebrity
                st.push(i);
            }
        }

        int candidate = st.pop();

        // check its row
        for (int c = 0; c < arr[0].length; c++) {
            if (arr[candidate][c] == 1) {
                System.out.println("none");
                return;
            }
        }
        // check its colum
        for (int r = 0; r < arr.length; r++) {
            if (r != candidate && arr[r][candidate] == 0) {
                System.out.println("none");
                return;
            }
        }
        System.out.println(candidate);
    }
}
/*
1. You are given a number n, representing the number of people in a party.
2. You are given n strings of n length containing 0's and 1's
3. If there is a '1' in ith row, jth spot, then person i knows about person j.
4. A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
5. If there is a celebrity print it's index otherwise print "none".

Note -> There can be only one celebrity. Think why?


 */