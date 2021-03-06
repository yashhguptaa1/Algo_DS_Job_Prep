package STACKS.Category_S2.L84_LargestRectangleInHistogram;

import java.util.*;

public class LargestRectangleHistogram {

    // Our previous state (histories) present in stack are all elements bigger than
    // current element on its right
    // when we get current element smaller than elements in stack we start updating
    // /doing our work

    // NEXT SMALLER ON LEFT INDEX VERSION
    public static int[] leftSmallerIndex(ArrayList<Integer> A) {
        int[] res = new int[A.size()];
        Stack<Integer> st = new Stack<>();
        st.push(A.size() - 1);

        for (int i = A.size() - 2; i >= 0; i--) {
            while (st.size() > 0 && A.get(st.peek()) > A.get(i)) {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        while (st.size() > 0) {
            res[st.pop()] = -1;
        }
        return res;
    }

    // Our previous state (histories) present in stack are all elements bigger than
    // current element on its left
    // when we get current element smaller than elements in stack we start updating
    // /doing our work that is store its index

    // NEXT SMALLER ON RIGHT INDEX VERSION
    public static int[] rightSmallerIndex(ArrayList<Integer> A) {
        int[] res = new int[A.size()];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < A.size(); i++) {
            while (st.size() > 0 && A.get(st.peek()) > A.get(i)) {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        while (st.size() > 0) {
            res[st.pop()] = A.size();
        }
        return res;
    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        int area = 0;

        int[] leftBoundary = leftSmallerIndex(A);
        int[] rightBoundary = rightSmallerIndex(A);

        int lb = 0;
        int rb = 0;

        for (int i = 0; i < A.size(); i++) {
            int width = rightBoundary[i] - leftBoundary[i] - 1;
            int height = A.get(i);

            // area = Math.max(area, width * height);
            if (area < width * height) {
                area = width * height;
                lb = leftBoundary[i];
                rb = rightBoundary[i];
            }
        }
        return area;
    }

}

/*
 * 
 * COnsider Input
 * 
 * 
 * | | | | | | | | | | | | | | | | | | . | | | | | 6 0 2 5 4 5 1 0 1 2 3 4 5 6
 * 
 * Largest area is 4 * {BASED ON INDEXING}(6-2 -1)
 * 
 * As can be seen for current bar 4 Next smaller on left of 4 decreases the
 * height of the rectangle making it less than4 we also know that elements
 * between 4 and next smaller on left are either equal to 4 or greater than 4 so
 * if we take a rectangle of height 4 we can include these bars
 * 
 * 
 * 
 * 1. You are given a number n, representing the size of array a. 2. You are
 * given n numbers, representing the height of bars in a bar chart. 3. You are
 * required to find and print the area of largest rectangle in the histogram.
 * 
 * e.g. for the array [6 2 5 4 5 1 6] -> 12
 */
