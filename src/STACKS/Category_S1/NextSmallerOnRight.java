package STACKS.Category_S1;

import java.util.Stack;

public class NextSmallerOnRight {

    public int[] nextSmallerRight(int arr[])
    {
        int res[]=new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i=1;i<arr.length;i++)
        {
            while (st.size() > 0 && arr[st.peek()] > arr[i])
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
