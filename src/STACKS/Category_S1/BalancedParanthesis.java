package STACKS.Category_S1;

import java.util.*;

public class BalancedParanthesis {

    public boolean isValid(String str) {
        Stack<Character> trackRecentOpeningParanthesis=new Stack<>();
        HashMap<Character,Character>mappingClosingToOpening=new HashMap<>();
        mappingClosingToOpening.put(')','(');
        mappingClosingToOpening.put('}','{');
        mappingClosingToOpening.put(']','[');

        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);

            //push all opening brackets into stack
            //Saving all previous histories/most recent opening
            if(ch == '(' || ch == '{' || ch == '[')
            {
                trackRecentOpeningParanthesis.push(ch);
            }
            else if(mappingClosingToOpening.containsKey(ch))
            {
                //if ch is a character it will skip this elseif
                //if ch is any one of closing Paranthesis
                if(!trackRecentOpeningParanthesis.isEmpty() &&
                        (trackRecentOpeningParanthesis.peek() == mappingClosingToOpening.get(ch)))
                {
                    //pop the corresponding opening bracket
                    //as valid pair of parans found
                    trackRecentOpeningParanthesis.pop();
                }

                else
                    return false;

            }

        }

        //There might be a test case where there are more number of opening paranthesis than closing ones
        //the stack will not be empty in that case
        //This test case should return false as its invalid string
        return trackRecentOpeningParanthesis.isEmpty();
    }
}

/*
20. Valid Parentheses
Easy

7591

310

Add to List

Share
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 */