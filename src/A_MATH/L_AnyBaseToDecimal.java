package A_MATH;

import java.util.*;

public class L_AnyBaseToDecimal {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int d = getValueInDecimal(n, b);
        System.out.println(d);
    }

    //Keep on multiplying each digit by base raise to power of placevalue

    public static int getValueInDecimal(int num,int base)
    {
        int ans=0;
        int placeValue=0;

        while (num != 0)
        {
            int rem = num % 10;
            ans += rem*(int)Math.pow(base,placeValue);

            //update values
            num = num /10;
            placeValue++;
        }
        return ans;
    }

}


/*
Any Base To Decimal
Easy  Prev   Next
1. You are given a number n.
2. You are given a base b. n is a number on base b.
3. You are required to convert the number n into its corresponding value in decimal number system.
 */