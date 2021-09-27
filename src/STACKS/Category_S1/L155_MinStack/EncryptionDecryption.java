package STACKS.Category_S1.L155_MinStack;

import java.util.*;

public class EncryptionDecryption {
    class MinStack {

        Stack<Integer> allElements;
        int minSoFar = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack() {

            allElements = new Stack<>();
        }

        public void push(int val) {

            // if new value smaller than minNum already present update minNum
            // TO DETECT AT WHICH POINT WE RECIEVED New MinValue we store a small fake value

            // 2 * NewMin - OldMin

            // that updates its previous min
            // thus it is smaller than Value of actual num

            if (allElements.isEmpty()) {
                allElements.push(val);
                minSoFar = val;
            } else if (minSoFar > val) {
                // min. update
                allElements.push(val + val - minSoFar);
                // update min
                minSoFar = val;
            } else {
                allElements.push(val);
            }

        }

        public void pop() {

            if (allElements.size() == 0)
                return;

            // when we get a newMin val
            // we encrypt and Push in stack (val + val - oldMin)
            // which is always smaller than the actual newMin
            // Thus this is the point Where we achieved newMin
            if (allElements.peek() < minSoFar) {
                // get the value of stack
                int actualCurrMin = minSoFar;
                // In Brute Force Approach we were using 2nd STACK to store all previous
                // minValues
                // that we obtained so when we popped our current min we could obtain min just
                // before it
                // from 2nd stack as it stored all previous min

                // Now to code without using extra space we use concept of encryption decryption
                // update oldmin // origVal is the Current Min (Current state)
                // stored value : [ origVal + (origVal - MostRecentPreviousMin)]
                // Now to get back MostRecentPreviousMin using currentMin
                // (2 * origVal) - [ origVal + (origVal - MostRecentPreviousMin)]
                // = (origVal + origVal) - [origVal + origVal - MostRecentPreviousMin]
                // = (origVal + origVal) - origVal - origVal + MostRecentPreviousMin
                // =MostRecentPreviousMin

                int encryptedValInStack = allElements.pop();
                minSoFar = 2 * actualCurrMin - encryptedValInStack;

                // return actualCurrMin;
            }

            else {
                // else just pop curr ele
                allElements.pop();

            }

        }

        public int top() {

            if (allElements.size() == 0)
                return -1;

            // when we get a newMin val
            // we encrypt and Push in stack (val + val - oldMin)
            // which is always smaller than the actual newMin
            if (allElements.peek() < minSoFar)
                return minSoFar;

            return allElements.peek();

        }

        public int getMin() {

            if (allElements.size() == 0)
                return -1;

            return minSoFar;
        }

    }

    /**
     * Your MinStack object will be instantiated and called as such: MinStack obj =
     * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
     * param_4 = obj.getMin();
     */
}
