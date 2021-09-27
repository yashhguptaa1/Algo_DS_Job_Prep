package STACKS.Category_S1.InterviewBit;

import java.util.*;

public class MergeOverlappingIntevals {

    public static class Pair implements Comparable<Pair> {
        int st = 0;
        int end = 0;

        public Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }

        public int compareTo(Pair o) {
            return this.st - o.st;
        }
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        st.push(pairs[0]);
        for (int i = 1; i < pairs.length; i++) {
            Pair p = pairs[i];

            // agr current meeting(state) ka start time
            // most recent previous meeting ke end time se kam (phle) he
            // we merge these intervals
            if (p.st <= st.peek().end) {
                // end time may be update
                // end time of the two merged intervals will be maximum
                // end time out of the two intervals
                if (p.end > st.peek().end) {
                    st.peek().end = p.end;
                }
            } else {
                st.push(p);
            }
        }

        // our answer is currently in reversed form
        // reverse answer to get correct flow
        Stack<Pair> rst = new Stack<>(); // reverse stack
        while (st.size() > 0)
            rst.push(st.pop());
        while (rst.size() > 0) {
            Pair rem = rst.pop();
            System.out.println(rem.st + " " + rem.end);
        }
    }

}
/*
 * FROM INTERVIEWBIT They already provided us with a class to store pairs of
 * start and end time In this case we sort like below
 * 
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 * 
 * public class Solution { public ArrayList<Interval> merge(ArrayList<Interval>
 * intervals) { ArrayList<Interval> result = new ArrayList<>();
 * 
 * Interval pairs[] = new Interval[intervals.size()]; for(int i =
 * 0;i<intervals.size();i++) { pairs[i] = new Interval(intervals.get(i).start
 * ,intervals.get(i).end ); }
 * 
 * Arrays.sort(pairs,new SortByStartTime());
 * 
 * Stack<Interval>meetingsSoFar=new Stack<>();
 * 
 * meetingsSoFar.push(pairs[0]);
 * 
 * for(int i = 1;i<pairs.length;i++) { Interval curr=pairs[i];
 * 
 * if(curr.start <= meetingsSoFar.peek().end) {
 * 
 * if(curr.end > meetingsSoFar.peek().end) { meetingsSoFar.peek().end =
 * curr.end; } } else { meetingsSoFar.push(curr); } } while
 * (!meetingsSoFar.isEmpty()) { result.add(meetingsSoFar.pop()); }
 * 
 * Collections.reverse(result);
 * 
 * return result; }
 * 
 * class SortByStartTime implements Comparator<Interval> { public int
 * compare(Interval s1,Interval s2) { return s1.start - s2.start; }
 * 
 * } }
 */