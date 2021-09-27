package B_ARRAYS.P0_Specialized.maths;

import java.util.*;

public class factorialOfLargeNumber {

    // Step 1
    // Make a custom Linked List
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            this.data = d;
            this.prev = null;
            this.next = null;
        }
    }

    static void multiply(Node tail, int num) {

        Node itr = tail;
        Node prevNode = tail;

        int carry = 0;

        while (itr != null) {
            int tempAns = itr.data * num + carry;
            itr.data = tempAns % 10;
            carry = tempAns / 10;
            prevNode = itr;

            itr = itr.prev;
        }

        while (carry != 0) {
            prevNode.prev = new Node((int) (carry % 10));
            carry /= 10;
            prevNode = prevNode.prev;
        }
    }

    static ArrayList<Integer> factorial(int N) {

        // Create a node and initialise it by 1
        // Replicating BASECASE of recursion
        Node endOfLL = new Node(1);

        for (int i = 2; i <= N; i++) {
            // Run a loop from 2 to n and
            multiply(endOfLL, i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        Node end = endOfLL;
        while (end != null) {
            // System.out.print(head.data);
            res.add(end.data);
            end = end.prev;
        }

        Collections.reverse(res);
        return res;
    }
}
