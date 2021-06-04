package STACKS.BuildStack;

import java.io.*;
import java.util.*;

public class TwoStacksInAnArray {

        public static class TwoStack {
            int[] data;
            int tos1;
            int tos2;

            public TwoStack(int cap) {
                // write your code
                //here

                data = new int[cap];
                tos1 = -1;
                tos2 = cap;

            }

            int size1() {
                return tos1 + 1;
            }

            int size2() {
                return data.length - tos2;
            }


            void push1(int val) {
                if(tos1 + 1 < tos2) {
                    data[tos1 + 1] = val;
                    tos1++;
                } else {
                    System.out.println("Stack overflow");
                }
            }

            void push2(int val) {
                if(tos1 + 1 < tos2) {
                    data[tos2 - 1] = val;
                    tos2--;
                } else {
                    System.out.println("Stack overflow");
                }
            }

            int pop1() {
                if(tos1 == -1) {
                    System.out.println("Stack underflow");
                    return -1;
                } else {
                    int val = data[tos1];
                    tos1--;
                    return val;
                }
            }

            int pop2() {
                if(tos2 == data.length) {
                    System.out.println("Stack underflow");
                    return -1;
                } else {
                    int val = data[tos2];
                    tos2++;
                    return val;
                }
            }

            int top1() {
                if(tos1 == -1) {
                    System.out.println("Stack underflow");
                    return -1;
                } else {
                    int val = data[tos1];
                    return val;
                }
            }

            int top2() {
                if(tos2 == data.length) {
                    System.out.println("Stack underflow");
                    return -1;
                } else {
                    int val = data[tos2];
                    return val;
                }
            }
        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            TwoStack st = new TwoStack(n);

            String str = br.readLine();
            while (str.equals("quit") == false) {
                if (str.startsWith("push1")) {
                    int val = Integer.parseInt(str.split(" ")[1]);
                    st.push1(val);
                } else if (str.startsWith("pop1")) {
                    int val = st.pop1();
                    if (val != -1) {
                        System.out.println(val);
                    }
                } else if (str.startsWith("top1")) {
                    int val = st.top1();
                    if (val != -1) {
                        System.out.println(val);
                    }
                } else if (str.startsWith("size1")) {
                    System.out.println(st.size1());
                } else if (str.startsWith("push2")) {
                    int val = Integer.parseInt(str.split(" ")[1]);
                    st.push2(val);
                } else if (str.startsWith("pop2")) {
                    int val = st.pop2();
                    if (val != -1) {
                        System.out.println(val);
                    }
                } else if (str.startsWith("top2")) {
                    int val = st.top2();
                    if (val != -1) {
                        System.out.println(val);
                    }
                } else if (str.startsWith("size2")) {
                    System.out.println(st.size2());
                }
                str = br.readLine();
            }
        }

}
/*
1. You are required to complete the code of our TwoStack class. The class should implement LIFO behaviours for two stacks in the same array.
2. Here is the list of functions that you are supposed to complete
    2.1. push1, push2 -> Should accept new data for appropriate stack if there is
    space available in the underlying array or print "Stack overflow" otherwise.
    2.2. pop1, po2 -> Should remove and return data from appropriate stack if
    available or print "Stack underflow" otherwise and return -1.
    2.3. top1, top2 -> Should return data from appropriate stack if available or print
    "Stack underflow" otherwise and return -1.
    2.4. size1, size2 -> Should return the number of elements available in appropriate
     stack.

     Sample Input
5
push1 10
push1 20
push2 30
push2 40
push2 50
push1 60
top1
pop1
top1
pop1
top2
pop2
top2
pop2
top1
pop1
top2
pop2
quit
Sample Output
Stack overflow
20
20
10
10
50
50
40
40
Stack underflow
Stack underflow
30
30
 */