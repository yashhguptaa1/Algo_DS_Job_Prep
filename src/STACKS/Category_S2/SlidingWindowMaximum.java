package STACKS.Category_S2;

import java.util.*;
public class SlidingWindowMaximum {

    public static int[] slidingMaximum(final int[] arr, int k) {

        if(k >= arr.length)
        {
            int maxSofar=Integer.MIN_VALUE;
            for(int p=0;p<arr.length;p++)
            {
                maxSofar=Math.max(arr[p],maxSofar);
            }
            return new int[]{maxSofar};
        }

        int[] rgi = rightGreaterIndex(arr);
        int ans[]=new int[arr.length-k + 1];
        int idx=0;
        int j = 0;

        //For every window that starts at i
        //we find maximum in that window
        for (int i = 0; i <= arr.length - k; i++) {

            //Since j is used to traverse on ARRAY of NGR
            //Also we need to track NGR only after the start of
            //current sliding window
            if (i > j) {
                j = i;
            }

            //if we make bar chart of NGR
            //we can see between two NGR all elements are smaller than both
            //of these NGR

            //j NGR se NGR ki jump lgata jaata he
            //aur vahan ruk jata he jiska NGR current window se bahar he
            while (i + k > rgi[j]) {
                j = rgi[j];
            }
            ans[idx++]=arr[j];
            //System.out.println(arr[j]);
        }
        return ans;
    }

    public static int[] rightGreaterIndex(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        while (st.size() > 0) {
            res[st.pop()] = arr.length;
        }
        return res;
    }
}
