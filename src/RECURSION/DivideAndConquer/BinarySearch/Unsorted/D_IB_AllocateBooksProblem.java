package RECURSION.DivideAndConquer.BinarySearch.Unsorted;

import java.util.*;

public class D_IB_AllocateBooksProblem {

    // the book with maximum pages will be read by atleast 1 student
    // so it means for every distribution the maximum pages a child
    // can read will always be bigger or equalto book with maximum pgs
    // Thus our Low rangeval for binary search is book with maximum pgs

    // Our High rangeval is when you give all books to a single student
    // that is sum of all pages

    /*
     * A = [12, 34, 67, 90] low = 90 high = 203
     * 
     * mid= (90+203)/2
     */

    public int books(ArrayList<Integer> A, int B) {

        if (B > A.size())
            return -1;

        int sum = 0;
        int max = 0;

        for (int val : A) {
            sum += val;
            max = Math.max(max, val);
        }
        int high = sum;
        int low = max;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(A, mid, B) == true) {
                // Store best ans so far
                ans = mid;

                // Try to minimize the max value
                high = mid - 1;
            } else {
                // load bhdaya jaaye
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(ArrayList<Integer> A, int maxInCurrDistribution, int B) {
        int student = 1;
        int sumSoFar = 0;

        for (int i = 0; i < A.size(); i++) {
            sumSoFar += A.get(i);

            // Ab baaki bche hue books ke liye mjhe ek aur student
            // ya next student ko diya jayega
            if (sumSoFar > maxInCurrDistribution) {

                // next student uthaya
                student++;

                // Jis book ke karan overload hua previous student pr
                // ab new student ko vo book assign krenge starting me
                // kyunki hr bcha ek book toh padhega
                sumSoFar = A.get(i);
            }
        }
        // Agr saare students ko atleast ek book mil chuki he toh bdho aage
        return student <= B;
    }

}

/*
 * IMPORTANT RULES TO BE FOLLOWED A book (cannot be divided into pages) will be
 * allocated to exactly one student. Each student has to be allocated at least
 * one book. Allotment should be in contiguous order, for example: A student
 * cannot be allocated book 1 and book 3, skipping book 2.
 */

/*
 * For Example
 * 
 * Input 1: A = [12, 34, 67, 90] B = 2 Output 1: 113 Explanation 1: There are 2
 * number of students. Books can be distributed in following fashion : 1) [12]
 * and [34, 67, 90] Max number of pages is allocated to student 2 with 34 + 67 +
 * 90 = 191 pages 2) [12, 34] and [67, 90] Max number of pages is allocated to
 * student 2 with 67 + 90 = 157 pages 3) [12, 34, 67] and [90] Max number of
 * pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
 * 
 * Of the 3 cases, Option 3 has the minimum pages = 113.
 */