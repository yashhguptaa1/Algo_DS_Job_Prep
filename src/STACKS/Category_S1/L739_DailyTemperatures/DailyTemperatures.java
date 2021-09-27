package STACKS.Category_S1.L739_DailyTemperatures;

import java.util.*;

public class DailyTemperatures {

    // NEXT GREATER ON RIGHT INDEX VERSION
    public int[] dailyTemperatures(int[] t) {

        int res[] = new int[t.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < t.length; i++) {
            while (st.size() > 0 && t[st.peek()] < t[i]) {
                res[st.pop()] = i;
            }

            st.push(i);
        }
        while (st.size() > 0) {
            /*
             * If there is no future day for which this is possible, keep answer[i] == 0
             * instead.
             */
            int indx = st.pop();
            res[indx] = indx;
        }

        // To count the number of days you will have to wait for warmer days
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] - i;
        }

        return res;
    }
}
/*
 * 739. Daily Temperatures Medium
 * 
 * 4344
 * 
 * 131
 * 
 * Add to List
 * 
 * Share Given a list of daily temperatures temperatures, return a list such
 * that, for each day in the input, tells you how many days you would have to
 * wait until a warmer temperature. If there is no future day for which this is
 * possible, put 0 instead.
 * 
 * For example, given the list of temperatures temperatures = [73, 74, 75, 71,
 * 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * Note: The length of temperatures will be in the range [1, 30000]. Each
 * temperature will be an integer in the range [30, 100].
 */