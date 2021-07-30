package A_recursion.Type_R1_PrePhase.Work_in_PrePhase.Print_Ans_in_BaseCase;

import java.util.Scanner;

public class PrintEncodings {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String inp= sc.next();
        encodings(inp,"");
    }

    public static void encodings(String str,String pathSoFar)
    {
        if(str.length() == 0)
        {
            System.out.println(pathSoFar);
            return;
        }
        int dig1=str.charAt(0)-'0';

        if(dig1 == 0)
        {
            return;
        }

        char ch1=(char)(dig1 + 'a' - 1);
        String afterOneChar= str.substring(1);
        encodings(afterOneChar,pathSoFar + ch1);

        if(str.length() > 1)
        {
            int dig2=str.charAt(1) - '0';
            int twoDig= dig1 * 10 +dig2;
            if(twoDig <=26)
            {
                char ch2=(char) (twoDig + 'a' -1 );
                String afterTwoChar=str.substring(2);
                encodings(afterTwoChar,pathSoFar + ch2);
            }
        }
    }
}
