package STACKS.Category_S1.L503_NextGreaterElement2;

import java.util.Arrays;
import java.util.Stack;

public class ngrCircularArr {

    public int[] nextGreaterElements(int[] nums) {

        int n=nums.length;
        int res []=new int [n];
        Arrays.fill(res,-1);

        Stack<Integer>indices=new Stack<>();

        for(int i=0;i<n*2;i++)
        {
            while (!indices.isEmpty() && nums[indices.peek()] < nums[i % n])
            {
                res[indices.pop()] = nums[i % n];
            }

            if(i<n)
                indices.push(i);
        }
        return res;
    }
}
