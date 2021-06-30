package B_ARRAYS.Type_Partition_Solved_Unsolved;

//Initial template for Java

import java.io.*;

public class Segregate012_DutchNationalFlag
{

    public static void sort012(int arr[], int n)
    {
        //As we solve our array gets divided into three segments

        //First Segment is Sorted subarray consisting of only 0s
        //To track this segment we keep a pointer Idx_First1  just after this segment
        // Thus it will point to first 1 as after all 0s comes 1s subarray

        //Second Segment contains the elements yet to tackled
        //We track this segment using two pointers as this
        // unsolved segment can contain 0s, 1s and 2s
        // firstIdx_UnsolvedSegment
        // lastIdx_UnsolvedSegment

        //Third Segment is Sorted subarray of only 2s
        //To track this segment we keep pointer lastIdx_UnsolvedSegment that points
        //to index just before this segment which is the last index of unsolved segment
        int firstIdx_UnsolvedSegment = 0; // first unsolved
        int Idx_First1 = 0; // first 1
        int lastIdx_UnsolvedSegment = arr.length - 1; // last unsolved

        while(firstIdx_UnsolvedSegment <= lastIdx_UnsolvedSegment) {
            if(arr[firstIdx_UnsolvedSegment] == 0) {
                swap(arr, firstIdx_UnsolvedSegment, Idx_First1);
                firstIdx_UnsolvedSegment++;
                Idx_First1++;
            } else if(arr[firstIdx_UnsolvedSegment] == 1) {
                firstIdx_UnsolvedSegment++;
            } else {
                swap(arr, firstIdx_UnsolvedSegment, lastIdx_UnsolvedSegment);
                lastIdx_UnsolvedSegment--;
            }
        }
        // code here
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// { Driver Code Starts.

class GFG {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Segregate012_DutchNationalFlag ob=new Segregate012_DutchNationalFlag();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends
