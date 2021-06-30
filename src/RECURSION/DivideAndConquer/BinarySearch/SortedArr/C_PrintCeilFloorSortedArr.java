package RECURSION.DivideAndConquer.BinarySearch.SortedArr;

import java.util.*;

public class C_PrintCeilFloorSortedArr {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int arr1[]=new int[n1];
        for(int i=0;i<n1;i++)
            arr1[i]=sc.nextInt();

        int data=sc.nextInt();
        int res[]=new int[2];

        ceilFloor(arr1,data);

        System.out.println(arr1[res[1]]);
        System.out.println(arr1[res[0]]);
    }

    public static void ceilFloor(int arr[],int data)
    {
        int left = 0;
        int right=arr.length - 1;

        int ceil = -1;
        int floor= -1;

        while (left<=right)
        {
            int mid=(left +right)/2;
            if(data == arr [mid])
            {
                ceil=mid;
                floor=mid;
                break;
            }
            else if(data < arr[mid])
            {
                ceil = mid;
                right=mid - 1;
            }
            else if( data > arr[mid])
            {
                floor = mid;
                left = mid + 1;
            }
        }

        System.out.println(arr[ceil]);
        System.out.println(arr[floor]);
    }
}

/*

3. You are given another number d.
4. You are required to find the ceil and floor of d in array a.
Sample Input
10
1
5
10
15
22
33
40
42
55
66
34
Sample Output
40
33
 */