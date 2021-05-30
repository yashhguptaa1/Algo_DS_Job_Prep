package STACKS.PrefixInfixPostfix_Evaluation;

import java.util.*;
public class EvaluateExpression {

    public int evalRPN(String[] A) {
        Stack<Integer> s = new Stack<>();

        for(int i = 0 ; i < A.length ; i++){
            String s1 = A[i];

            //if current String is a number operand push it in stack
            if(s1.charAt(s1.length() - 1) >= '0' && s1.charAt(s1.length() - 1) <= '9')
                s.push(Integer.parseInt(s1));
            else{

                //if current string is an operator
                //pop the first two elements from stack which are the first
                //two operands for current operator to work on
                int b = s.pop();
                int a = s.pop();

                //now use operator on the two operands and store the result back
                //into stack which will become one of the operand in future
                if(s1.charAt(0) == '+')
                    s.push(a + b);
                else if(s1.charAt(0) == '-')
                    s.push(a - b);
                else if(s1.charAt(0) == '*')
                    s.push(a * b);
                else
                    s.push(a / b);
            }
        }
        //top of stack will contain the answer
        return s.peek();
    }

    public int evalRPNversion2(String[] A) {
        if(A.length == 0)
            return -1;
        Stack<String> stack = new Stack<String>();
        for(String s : A) {
            if(s.equals("*") || s.equals("/") || s.equals("-") || s.equals("+")){
                // pop the stack
                int opernad2 = Integer.parseInt(stack.pop());
                int opernad1 = Integer.parseInt(stack.pop());
                int ans=0;
                if(s.equals("*")){
                    ans = opernad1 * opernad2;
                } else if( s.equals("/")){
                    ans = opernad1 / opernad2;
                } else if(s.equals("-")){
                    ans = opernad1 - opernad2;
                } else if(s.equals("+")){
                    ans = opernad1 + opernad2;
                }
                stack.push(""+ans);
            } else {
                stack.push(s);
            }
        }
        String ans = stack.pop();
        return Integer.parseInt(ans);
    }

}

/*

 */