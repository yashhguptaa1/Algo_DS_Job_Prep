package STACKS.PrefixInfixPostfix_Evaluation;
import java.util.*;

public class PostfixEvaluationAndConversions {

    public static int evaluate(int val1, int val2, char op) {
        if(op == '*') {
            return val1 * val2;
        } else if(op == '/') {
            return val1 / val2;
        } else if(op == '+') {
            return val1 + val2;
        } else if(op == '-') {
            return val1 - val2;
        } else {
            return 0;
        }
    }
    // // postfix
    public static void postfixEvaluation(String str) {
        Stack<Integer> vstack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch >= '0' && ch <= '9') {
                vstack.push(ch - '0');
            } else {
                int val2 = vstack.pop();
                int val1 = vstack.pop();

                int res = evaluate(val1, val2, ch);
                vstack.push(res);
            }
        }
        System.out.println(vstack.pop());
    }

    public static void postfixToPrefix(String str) {
        Stack<String> vstack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch >= '0' && ch <= '9') {
                vstack.push("" + ch);
            } else {
                String val2 = vstack.pop();
                String val1 = vstack.pop();

                // int res = evaluate(val1, val2, ch);
                String res = ch + val1 + val2;
                vstack.push(res);
            }
        }
        System.out.println(vstack.pop());
    }

    public static void postixToinfix(String str) {
        Stack<String> vstack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch >= '0' && ch <= '9') {
                vstack.push("" + ch);
            } else {
                String val2 = vstack.pop();
                String val1 = vstack.pop();

                // int res = evaluate(val1, val2, ch);
                String res = "(" + val1 + ch + val2 + ")";
                vstack.push(res);
            }
        }
        System.out.println(vstack.pop());
    }
}
