package STACKS.Category_S1.L155_MinStack;

import java.util.*;
public class UsingTwoStacks_ExtraSpace {

    class MinStack {

        /** initialize your data structure here. */
        Stack<Integer> minStack ;//new Stack<Integer>();
        Stack<Integer> stack ;//= new Stack<Integer>();
        public MinStack() {

            stack = new Stack<>();
            minStack = new Stack<>();

        }

        public void push(int x) {
            //Push all the elements to stack
            stack.push(x);
            //Only Push ele here if its less than minSoFar or there is no minValue obtained till now
            if(minStack.isEmpty() || x <= minStack.peek())
                minStack.push(x);
        }

        public void pop() {
            if(!stack.isEmpty()){
                int num = stack.pop();
                if(num == minStack.peek())
                    minStack.pop();
            }
        }

        public int top() {
            if(stack.isEmpty())
                return -1;
            return stack.peek();
        }


        public int getMin() {
            if(minStack.isEmpty())
                return -1;
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

}
