package A_MATH;

import java.util.*;

public class K_DecimalToAnyBase {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }

    //Keep on dividing num by b
    public static int getValueInBase(int num, int b){

        int res=0;
        int placeValue=0;
        while (num != 0)
        {
            int rem = num % b;
            res = (int)Math.pow(10,placeValue)*rem + res;

            //update values
            num= num / b;
            placeValue++;
        }

        return res;

    }

}
/*
/*
Decimal To Any Base
Easy  Prev   Next
1. You are given a decimal number n.
2. You are given a base b.
3. You are required to convert the number n into its corresponding value in base b.
 */