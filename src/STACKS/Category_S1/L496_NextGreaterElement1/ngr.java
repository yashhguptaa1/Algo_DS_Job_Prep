package STACKS.Category_S1.L496_NextGreaterElement1;

import java.util.*;

public class ngr {

    public int[] nextGreaterElement(int[] nums1, int[] arr) {

        HashMap<Integer,Integer> mapEleToNgr =new HashMap<>();

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i=1;i<arr.length;i++)
        {
            while (st.size() > 0 && arr[st.peek()] < arr[i])
            {
                int idx= st.pop();
                mapEleToNgr.put(arr[idx],arr[i]);
            }
            st.push(i);
        }

        while (!st.isEmpty())
        {
            int idx= st.pop();
            mapEleToNgr.put(arr[idx], -1);
        }

        int n = nums1.length;

        int res[]=new int[n];

        for(int i=0;i<n;i++)
        {
            res[i]=mapEleToNgr.get(nums1[i]);
        }
        return res;
    }

}
