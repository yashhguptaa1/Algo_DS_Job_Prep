package STACKS.Category_S1;

import java.io.*;
import java.util.*;

public class ValidateStackSequence {
    public static boolean validateStackSequences(int pushed[],int popped[])
    {
        int n=pushed.length;

        Stack<Integer>tracker=new Stack<>();

        int j=0;

        for(int i=0;i<n;i++)
        {
            while(tracker.size()>0 && j<n && tracker.peek() == popped[j])
            {
                tracker.pop();
                j++;
            }
            tracker.push(pushed[i]);

        }

        while(tracker.size()>0 && j<n && tracker.peek() == popped[j])
        {
            tracker.pop();
            j++;
        }

        return tracker.isEmpty();
    }

    //Without using extra space Constant Space
//    public static boolean validateStackSequences(int pushed[],int popped[])
//    {
//        int n=pushed.length;
//        int tracker=0;
//
//        int j=0;
//
//        for(int i=0;i<n;i++)
//        {
//            while(tracker.size()>0 && j<n && tracker.peek() == popped[j])
//            {
//                tracker.pop();
//                j++;
//            }
//            tracker.push(pushed[i]);
//
//        }
//
//        while(tracker.size()>0 && j<n && tracker.peek() == popped[j])
//        {
//            tracker.pop();
//            j++;
//        }
//
//        return tracker.isEmpty();
//    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);

        int n= sc.nextInt();

        int pushed[]=new int[n];
        int popped[]=new int[n];

        for(int i=0;i<n;i++)
        {
            pushed[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++)
        {
            popped[i]=sc.nextInt();
        }

        System.out.println(validateStackSequences(pushed,popped));
    }
}
/*
Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.

Input Format

An integer n
Two arrays of length n denoting pushed and popped array
Constraints

0 <= pushed.length == popped.length <= 1000
0 <= pushed[i], popped[i] < 1000
pushed is a permutation of popped.
pushed and popped have distinct values.
Output Format

true or false

Sample Input 0

5
1 2 3 4 5
4 5 3 2 1
Sample Output 0

true
Explanation 0

pushed = [1,2,3,4,5]
popped = [4,5,3,2,1]
Explanation: We might do the following sequence: push(1), push(2), push(3), push(4), pop() -> 4, push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Sample Input 1

5
1 2 3 4 5
4 3 5 1 2
Sample Output 1

false
Explanation 1

Explanation: 1 cannot be popped before 2.
 */