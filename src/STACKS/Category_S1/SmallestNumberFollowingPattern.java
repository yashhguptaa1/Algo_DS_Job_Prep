package STACKS.Category_S1;

import java.io.*;
import java.util.*;

public class SmallestNumberFollowingPattern {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // code
        smallestNumber(str);
    }

    //Uses somewhat similar concept of question validate stack sequence
    public static void smallestNumber(String str)
    {
        int counter=1;
        Stack<Integer>st=new Stack<>();

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) == 'd')
            {
                st.push(counter);
                counter++;
            }
            else if(str.charAt(i) == 'i')
            {
                //Push one extra counter before popping cauz
                //Every char maps to two numbers
                // ddd -> 4321
                st.push(counter);
                counter++;
                while (st.size() > 0)
                {
                    System.out.print(st.pop());
                }
            }
        }

        //since for every character of input we have two numbers mapped to it
        st.push(counter);
        while (st.size() > 0)
            System.out.print(st.pop());
    }

}

/*
1. You are given a pattern of upto 8 length containing characters 'i' and 'd'.
2. 'd' stands for decreasing and 'i' stands for increasing
3. You have to print the smallest number, using the digits 1 to 9 only without repetition, such that
the digit decreases following a d and increases follwing an i.

e.g.
d -> 21
i -> 12
ddd -> 4321
iii -> 1234
dddiddd -> 43218765
iiddd -> 126543
 */