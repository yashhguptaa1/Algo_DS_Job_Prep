package STACKS.BuildStack;
import java.io.*;
import java.util.*;

public class UsingQueue_PushEfficient {
    public static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            mainQ.add(val);
        }


        int pop() {
            if (mainQ.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            // Remove n - 1 elements from mainQ, add it in helper Q
            while (mainQ.size() > 1) {
                helperQ.add(mainQ.remove());
            }
            // get the value of nth element from mainQ
            int val = mainQ.peek();
            // remove nth element
            mainQ.remove();
            // change reference
            // As our helper queue is like the stack with top element popped
            //so make helper queue as mainq now
            Queue<Integer> temp = mainQ;
            mainQ = helperQ;
            helperQ = temp;
            // return val
            return val;
        }

        int top() {
            if (mainQ.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            // n - 1 remove from mainQ, add it in helper Q
            while (mainQ.size() > 1) {
                helperQ.add(mainQ.remove());
            }
            // get the value of nth element from mainQ
            int val = mainQ.peek();
            // add nth value in helperQ
            helperQ.add(mainQ.remove());
            // change reference
            Queue<Integer> temp = mainQ;
            mainQ = helperQ;
            helperQ = temp;
            // return val
            return val;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        QueueToStackAdapter st = new QueueToStackAdapter();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            }
            str = br.readLine();
        }
    }
}

/*
Sample Input
push 10
push 20
push 5
push 8
push 2
push 4
push 11
top
size
pop
top
size
pop
top
size
pop
top
size
pop
top
size
pop
top
size
pop
top
size
pop
quit
Sample Output
11
7
11
4
6
4
2
5
2
8
4
8
5
3
5
20
2
20
10
1
10

 */