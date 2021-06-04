package STACKS.Category_S1;

import java.util.*;
public class RedundantBraces_DuplicateBrackets {
    public static int braces(String A) {

        //To Store and track previous recent states
        //Here previous state will be when was opening bracket obtained
        //and was there operands present in previous state
        Stack<Character>st =new Stack<>();

        //TRAVERSING ALL STATES
        for(int i=0;i<A.length();i++)
        {
            //Our curr
            char currState=A.charAt(i);

            //WE want to do comparison only when our current state becomes ) a closing bracket
            //otherwise go on saving all previous state to be aceessed later
            if(currState != ')')
            {
                st.push(currState);
            }
            else {
                //Now our current State is a closing bracket
                //We compare the MOST RECENT PREVIOUS STATE WITH CURRENT STATE
                //If Most recent state is a opening bracket we determine it to be useless state
                // cauz there are no other (operands) state b/w it
//                if(st.peek() == '(')
//                    return 1;

                //If our Most recent state is not opening bracket we pop(remove)
                // all unnecessary states in between (operands and operators)
                //till our previous state becomes '(' opening bracket

                int ans=1;
                while (st.peek() != '(')
                {
                    Character temp=st.pop();
                    //If there is an operator present in any of previous state in stack
                    //after opening bracket it means brackets are valid
                    if( temp == '+' || temp == '-' ||temp == '*' ||temp == '/')
                    {
                        ans =0;
                    }
                }

                //We found correct previous state for our current state '('
                //Now pop it as it has fulfilled its purpose
                if(ans !=0 )
                    return 1;

                st.pop();
            }
        }
        return 0;
    }
}

/*
Given a string A denoting an expression. It contains the following operators ’+’, ‘-‘, ‘*’, ‘/’.

Chech whether A has redundant braces or not.

Return 1 if A has redundant braces, else return 0.

Note: A will be always a valid expression.



Input Format

The only argument given is string A.
Output Format

Return 1 if string has redundant braces, else return 0.
For Example

Input 1:
    A = "((a + b))"
    A=(a)
Output 1:
    1
    Explanation 1:
        ((a + b)) has redundant braces so answer will be 1.
        (a) has redundant braces
Input 2:
    A = "(a + (a + b))"
Output 2:
    0
    Explanation 2:
        (a + (a + b)) doesn't have have any redundant braces so answer will be 0.
 */