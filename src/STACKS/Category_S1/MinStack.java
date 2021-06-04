package STACKS.Category_S1;

import java.util.*;

public class MinStack {


// SOLVING MINSTACK PROBLEM USING CONSTANT SPACE
//My submission on Interviewbit

    Stack<Integer>allElements=new Stack<>();
    int minSoFar=Integer.MAX_VALUE;
    public void push(int val) {

        //if new value smaller than minNum already present update minNum
        //TO DETECT AT WHICH POINT WE RECIEVED New MinValue we store a small fake value

        // 2 * NewMin - OldMin

        //  that updates its previous min
        //thus it is smaller than Value of actual num
        if(minSoFar > val) {
            // min. update
            allElements.push(val + val - minSoFar);
            // update min
            minSoFar = val;
        }
        else
        {
            allElements.push(val);
        }

    }

    public void pop() {

        if(allElements.size() == 0)
            return ;

        if(allElements.peek() < minSoFar)
        {
            // get the value of stack
            int actualCurrMin = minSoFar;
            //In Brute Force Approach we were using 2nd STACK to store all previous minValues
            //that we obtained so when we popped our current min we could obtain min just before it
            // from 2nd stack as it stored all previous min

            //Now to code without using extra space we use concept of encryption decryption
            // update oldmin  // origVal is the Current Min (Current state)
            //stored value : [ origVal + (origVal - MostRecentPreviousMin)]
            //Now to get back MostRecentPreviousMin using currentMin
            // (2 * origVal) - [ origVal + (origVal - MostRecentPreviousMin)]
            //= (origVal + origVal) - [origVal + origVal -  MostRecentPreviousMin]
            //= (origVal + origVal) - origVal - origVal + MostRecentPreviousMin
            //=MostRecentPreviousMin

            int encryptedValInStack = allElements.pop();
            minSoFar = 2 * actualCurrMin - encryptedValInStack;

            //return actualCurrMin;
        }

        else
        {
            //else just pop curr ele
            allElements.pop();

        }


    }

    public int top() {

        if(allElements.size() == 0)
            return -1;

        if(allElements.peek() < minSoFar)
            return minSoFar;

        return allElements.peek();

    }

    public int getMin() {

        if(allElements.size() == 0)
            return -1;

        return minSoFar;
    }

}

/*

CODE FROM INTERVIEWBIT SUBMISSION


SOLUTION FROM INTERVIEWBIT 1
CREATE A new type of NODE class which also contains min value so far


class Solution {
    class Node{
        int val, min;
        Node next;

        Node(int val, int min){
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }
    Node head;
    public void push(int x) {
        Node l1;
        if(head == null){
            l1 = new Node(x, x);
        } else {
            l1 = new Node(x, Math.min(x, head.min));
            l1.next = head;
        }
        head = l1;
    }

    public void pop() {
        if(head != null){
            head = head.next;
        }
    }

    public int top() {
        if(head == null){
            return -1;
        }
        return head.val;
    }

    public int getMin() {
        if(head == null){
            return -1;
        }
        return head.min;
    }
}
.........................................................................................................
SOLUTION FROM INTERVIEWBIT 2
CREATE A 2nd Stack to store all previous min value obtained so far

class Solution {
    Stack<Integer> minStack = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
     public Solution() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
    //Push all the elements to stack
        stack.push(x);
        //Only Push ele here if its minSoFar or there is no minValue obtained till now
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

...........................................................................................................

Solution from pepcoding
public static class MinStack {
        Stack<Integer> data;
        int min;

        public MinStack() {
            data = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        int size() {
            // write your code here
            return data.size();
        }

        void push(int val) {
            // write your code here
            if(min > val) {
                // min. update
                // 2 * val - oldMin
                data.push(val + val - min);
                // update min
                min = val;
            } else {
                data.push(val);
            }
        }

        int pop() {
            // write your code here
            if(stack.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            if(data.peek() < min) {
                // get the value of stack
                int val = min;
                // update oldmin
                min = 2 * val - data.pop();
                return val;
            } else {
                return data.pop();
            }
        }

        int top() {
            // write your code here
            if(data.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            if(data.peek() < min) {
                return min;
            } else {
                return data.peek();
            }
        }

        int min() {
            // write your code here
            if(data.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return min;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("P")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("p")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("t")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("g")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }



INPUT

19 P 10 P 9 g P 8 g P 7 g P 6 g p g p g p g p g p g

 9 8 7 6 7 8 9 10 -1
*/

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack?
A: In this case, return -1.

Q: What should pop do on empty stack?
A: In this case, nothing.

Q: What should top() do on empty stack?
A: In this case, return -1
 NOTE : If you are using your own declared global variables, make sure to clear them out in the constructor.
 */