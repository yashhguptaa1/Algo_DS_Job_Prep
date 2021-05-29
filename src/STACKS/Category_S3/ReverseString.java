package STACKS.Category_S3;


import java.io.*;
import java.util.*;

public class ReverseString {

    public String reverseString(String A) {

        String res="";
        Stack<Character>st=new Stack<>();

        for(int i=0;i<A.length();i++)
        {
            char ch=A.charAt(i);
            st.push(ch);
        }

        while(!st.isEmpty())
        {
            res=res+st.pop().toString();
        }

        return res;
    }
}
