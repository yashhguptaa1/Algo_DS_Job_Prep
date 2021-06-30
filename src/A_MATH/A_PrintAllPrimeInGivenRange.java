package A_MATH;

import java.util.*;

public class A_PrintAllPrimeInGivenRange {

    /*
    if
    P*Q = n

    then it is never possible that
    P > sqrt(n)  AND
    Q > sqrt(n)
     */


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int low=scn.nextInt();
        int high=scn.nextInt();

        for(int num = low ;num <=high;num++)
        {
            int numOfFactors=0;

            //Note Since 1 is factor of every number
            //start loop from 2
            for(int div=2; div*div <= num; div++)
            {
                if(num % div == 0)
                {
                    numOfFactors++;
                    break;
                }
            }

            //If current number has no factors print
            // num ,its prime
            if(numOfFactors == 0)
                System.out.println(num);

        }

    }
}

/*
Print All Primes Till N
Easy  Prev   Next
1. You've to print all prime numbers between a range.
2. Take as input "low", the lower limit of range.
3. Take as input "high", the higher limit of range.
4. For the range print all the primes numbers between low and high (both included).
Input Format
low
high



 */

/*
Time Complexity allowed For every Question is 1 second
It is equal to 10^9 operations

So if
n = 10^9

so Allowed time complexity is O(n) or less
testcases = x
 */