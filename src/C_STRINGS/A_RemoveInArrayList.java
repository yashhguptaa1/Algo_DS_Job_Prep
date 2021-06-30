package C_STRINGS;

import java.util.*;

//THE MOST IMPORTANT THING TO NOTE HERE IS THAT
//IF WE REMOVE ITEMS IS ARRAYLIST WE MUST DO IT
//BY STARTING LOOP FROM END

public class A_RemoveInArrayList {

    public static void solution(ArrayList<Integer> al){

        for(int i=al.size()-1;i>=0;i--)
        {
            int val = al.get(i);
            if(isPrime(val) == true)
            {
//                System.out.println(al.get(i));
                al.remove(i);
            }
        }

    }
    public static boolean isPrime(int num)
    {

        //Note Since 1 is factor of every number
        //start loop from 2
        for(int div=2; div*div <= num; div++)
        {
            if(num % div == 0)
            {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);
    }

}

/*
Remove Primes
Easy  Prev   Next
1. You are given an ArrayList of positive integers.
2. You have to remove prime numbers from the given ArrayList and return the updated ArrayList.

Note -> The order of elements should remain same.
 */