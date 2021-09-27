package STACKS.Pep_BuildStack;

import java.io.*;
import java.util.*;

public class UsingQueuePopEfficient {
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

        // basically we ensure that top of stack is denoted by
        // the front of queue from where we can remove ele in constant time
        void push(int val) {
            // 1. fill helperQ from mainQ
            while (mainQ.size() > 0) {
                helperQ.add(mainQ.remove());
            }
            // 2. add new element in mainQ
            mainQ.add(val);
            // 3. refill mainQ from helperq
            while (helperQ.size() > 0) {
                mainQ.add(helperQ.remove());
            }
        }

        int pop() {
            if (mainQ.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            return mainQ.remove();
        }

        int top() {
            if (mainQ.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            return mainQ.peek();
        }

        public boolean empty() {
            return (mainQ.size() == 0);
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
 * Sample Input push 10 push 20 push 5 push 8 push 2 push 4 push 11 top size pop
 * top size pop top size pop top size pop top size pop top size pop top size pop
 * quit Sample Output 11 7 11 4 6 4 2 5 2 8 4 8 5 3 5 20 2 20 10 1 10
 * 
 */