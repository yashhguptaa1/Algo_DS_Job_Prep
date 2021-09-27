package STACKS.Category_S1.L496_NextGreaterElement1;

import java.util.Stack;

//Store Indices of Elements Smaller Than Current Ele in STACK
//Work only when Current element is greater than topmost element of stack
//Elements in stack will be present in Decreasing Order [ Bottom to Top]
public class NextGreaterOnRight {

    public int[] nextGreaterRight(int arr[]) {
        int res[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            res[st.pop()] = 0;
        }

        return res;
    }

}
/*
 * 1. You are given a number n, representing the size of array a. 2. You are
 * given n numbers, representing elements of array a. 3. You are required to
 * "next greater element on the right" for all elements of array 4. Input and
 * output is handled for you.
 * 
 * "Next greater element on the right" of an element x is defined as the first
 * element to right of x having value greater than x. Note -> If an element does
 * not have any element on it's right side greater than it, consider -1 as it's
 * "next greater element on right" e.g. for the array [2 5 9 3 1 12 6 8 7] Next
 * greater for 2 is 5 Next greater for 5 is 9 Next greater for 9 is 12 Next
 * greater for 3 is 12 Next greater for 1 is 12 Next greater for 12 is -1beb
 * Next greater for 6 is 8 Next greater for 8 is -1 Next greater for 7 is -1
 */