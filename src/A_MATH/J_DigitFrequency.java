package A_MATH;

import java.util.*;

public class J_DigitFrequency {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d= sc.nextInt();
        System.out.println(getDigitFrequency(n,d));
    }

    public static int getDigitFrequency(int n,int d)
    {
        int counter=0;

        while (n!=0)
        {
            int r = n%10;
            if(r == d)
                counter++;

            n=n/10;
        }
        return counter;
    }
}
/*
Digit Frequency
Easy  Prev   Next
1. You are given a number n.
2. You are given a digit d.
3. You are required to calculate the frequency of digit d in number n.
 */
