package STACKS.Category_S1.L901_OnlineStockSpan;

import java.io.*;
import java.util.*;

public class StockSpan {

    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = stockSpan(a);
        display(span);
    }

    //NEXT GREATER ON LEFT INDEX VERSION

    public static int[] stockSpan(int arr[])
    {
        int n=arr.length;
        int res[]=new int[n];
        Stack<Integer> indx=new Stack<>();
        indx.push(n-1);

        for(int i=n-2;i>=0;i--)
        {
            while (indx.size()>0 && arr[indx.peek()] < arr[i])
            {
                res[indx.pop()] = i;
            }
            indx.push(i);
        }
        while (indx.size() > 0)
        {
            res[indx.pop()] = -1;
        }

        //Using indexes to count number of days passed between
        // the current day and the first day before today when price was higher than today
        for(int i=0; i< res.length; i++)
        {
            res[i]=i-res[i];
        }
        return res;
    }
}

/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the prices of a share on n days.
3. You are required to find the stock span for n days.
4. Stock span is defined as the number of days passed between the current day and the first day before today when price was higher than today.

e.g.
for the array [2 5 9 3 1 12 6 8 7]
span for 2 is 1
span for 5 is 2
span for 9 is 3
span for 3 is 1
span for 1 is 1
span for 12 is 6
span for 6 is 1
span for 8 is 2
span for 7 is 1
 */