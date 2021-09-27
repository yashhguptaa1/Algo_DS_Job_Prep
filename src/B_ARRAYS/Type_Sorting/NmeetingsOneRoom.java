package B_ARRAYS.Type_Sorting;

import java.util.*;

public class NmeetingsOneRoom {

    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        // add your code here

        int meetings[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[1], b[1]));

        // for(int arr[] : meetings)
        // {
        // System.out.print("sp=" +arr[0]);
        // System.out.print("ep=" +arr[1]);

        // System.out.println();
        // }
        int currMeetEp = meetings[0][1];
        int numOfMeetings = 1;

        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > currMeetEp) {
                numOfMeetings++;
                currMeetEp = meetings[i][1];

            }

        }

        return numOfMeetings;
    }
}
