package STACKS.PrefixInfixPostfix_Evaluation.L224_BasicCalculator;

import java.util.*;

public class infixEvaluation {
    public static int priority(char op) {
        if (op == '/' || op == '*')
            return 2;
        else if (op == '+' || op == '-')
            return 1;
        else
            return 0;
    }

    public static int evaluate(int val1, int val2, char op) {
        if (op == '*') {
            return val1 * val2;
        } else if (op == '/') {
            return val1 / val2;
        } else if (op == '+') {
            return val1 + val2;
        } else if (op == '-') {
            return val1 - val2;
        } else {
            return 0;
        }
    }

    // infix
    public static int infixEvaluation(String str) {
        // To Store operators such as ) ( + * - /
        Stack<Character> ostack = new Stack<>(); // operator stack

        // To store operands and also the intermediate result after using operands
        // on top two operands
        Stack<Integer> vstack = new Stack<>(); // value stack

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch >= '0' && ch <= '9') {
                vstack.push((int) (ch - '0'));
            } else if (ch == '(') {
                ostack.push(ch);
            } else if (ch == ')') {
                while (ostack.peek() != '(') {
                    int val2 = vstack.pop();
                    int val1 = vstack.pop();
                    char op = ostack.pop();

                    int res = evaluate(val1, val2, op);
                    vstack.push(res);
                }
                ostack.pop(); // this pop is for opening bracket
            } else {
                // solve equal priority now, otherwise after loop we iterate in it with right to
                // left direction
                // because of behaviuour of stack

                // Three conditions when we pop that must satisfy together to allow POP
                // Higher Priority vale ko phle solve kro
                while (ostack.size() > 0 && ostack.peek() != '(' && priority(ostack.peek()) >= priority(ch)) {
                    int val2 = vstack.pop();
                    int val1 = vstack.pop();
                    char op = ostack.pop();

                    int res = evaluate(val1, val2, op);
                    vstack.push(res);
                }
                ostack.push(ch);
            }
        }

        // some element may be present in stack
        while (ostack.size() > 0) {
            int val2 = vstack.pop();
            int val1 = vstack.pop();
            char op = ostack.pop();

            int res = evaluate(val1, val2, op);
            vstack.push(res);
        }

        return vstack.pop();
    }

    public static void main(String[] args) {
        String inp = "4+ -4";
        System.out.println(infixEvaluation(inp));
    }
}
