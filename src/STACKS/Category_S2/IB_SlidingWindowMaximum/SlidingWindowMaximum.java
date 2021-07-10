package STACKS.Category_S2.IB_SlidingWindowMaximum;

import java.util.*;
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] arr, int k) {

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

    public int[] rightGreaterIndex(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }

        //Note here we store default value arr.length for elements that dont have
        //NGR cauz j would overshoot and it will make stop loop while(i+k> rgi[j])
        while (st.size() > 0) {
            res[st.pop()] = arr.length;
        }
        return res;
    }
}

/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the elements of array a.
3. You are given a number k, representing the size of window.
4. You are required to find and print the maximum element in every window of size k.

 */