package STACKS.Category_S1;

import java.util.Stack;

public class NextGreaterOnLeft {

    public int[] nextGreaterLeft(int arr[])
    {
        int res[]=new int[arr.length];

        //Store Indices of Elements Smaller Than Current Ele
        //Elements in stack will be present in Decreasing Order [ Bottom to Top]
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);

        for(int i=arr.length-2;i>=0;i--)
        {
            while (st.size() > 0 && arr[st.peek()] < arr[i])
            {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }

        while (!st.isEmpty())
        {
            res[st.pop()]= 0;
        }

        return res;
    }

}
