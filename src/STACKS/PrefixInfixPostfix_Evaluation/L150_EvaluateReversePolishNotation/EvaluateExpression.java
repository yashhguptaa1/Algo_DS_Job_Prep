package STACKS.PrefixInfixPostfix_Evaluation.L150_EvaluateReversePolishNotation;

import java.util.*;

public class EvaluateExpression {

    public int evalRPN(String[] A) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            String s1 = A[i];

            // if current String is a number operand push it in stack

            // NOTE
            // THIS IS A GOOD WAY TO CHECK IF INPUT IS A NUMBER IF WE DONT KNOW THE RANGE OF
            // INPUT
            // CHECK WHETHER UNITS DIGIT FALLS IN BETWEEN 0 to 9
            if (s1.charAt(s1.length() - 1) >= '0' && s1.charAt(s1.length() - 1) <= '9')
                s.push(Integer.parseInt(s1));
            else {

                // if current string is an operator
                // pop the first two elements from stack which are the first
                // two operands for current operator to work on
                // note first pop is assigned to b that is it will be second operand
                int b = s.pop();
                int a = s.pop();

                // now use operator on the two operands and store the result back
                // into stack which will become one of the operand in future
                if (s1.charAt(0) == '+')
                    s.push(a + b);
                else if (s1.charAt(0) == '-')
                    s.push(a - b);
                else if (s1.charAt(0) == '*')
                    s.push(a * b);
                else
                    s.push(a / b);
            }
        }
        // top of stack will contain the answer
        return s.peek();
    }

    public int evalRPNversion2(String[] A) {
        if (A.length == 0)
            return -1;
        Stack<String> stack = new Stack<String>();
        for (String s : A) {
            if (s.equals("*") || s.equals("/") || s.equals("-") || s.equals("+")) {
                // pop the stack
                int opernad2 = Integer.parseInt(stack.pop());
                int opernad1 = Integer.parseInt(stack.pop());
                int ans = 0;
                if (s.equals("*")) {
                    ans = opernad1 * opernad2;
                } else if (s.equals("/")) {
                    ans = opernad1 / opernad2;
                } else if (s.equals("-")) {
                    ans = opernad1 - opernad2;
                } else if (s.equals("+")) {
                    ans = opernad1 + opernad2;
                }
                stack.push("" + ans);
            } else {
                stack.push(s);
            }
        }
        String ans = stack.pop();
        return Integer.parseInt(ans);
    }

}

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * 
 * 
 * Input Format
 * 
 * The only argument given is character array A. Output Format
 * 
 * Return the value of arithmetic expression formed using reverse Polish
 * Notation. For Example
 * 
 * Input 1: A = ["2", "1", "+", "3", "*"] Output 1: 9 Explaination 1: starting
 * from backside: : ( )*( ) 3: ()*(3) +: ( () + () )*(3) 1: ( () + (1) )*(3) 2:
 * ( (2) + (1) )*(3) ((2)+(1))*(3) = 9
 * 
 * Input 2: A = ["4", "13", "5", "/", "+"] Output 2: 6 Explaination 2: +: ()+()
 * /: ()+(() / ()) 5: ()+(() / (5)) 1: ()+((13) / (5)) 4: (4)+((13) / (5))
 * (4)+((13) / (5)) = 6
 */