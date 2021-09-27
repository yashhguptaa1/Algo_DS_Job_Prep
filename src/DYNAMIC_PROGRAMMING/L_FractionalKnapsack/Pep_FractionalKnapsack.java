package DYNAMIC_PROGRAMMING.L_FractionalKnapsack;

import java.util.*;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/fractional-knapsack-official/ojquestion

class Pep_FractionalKnapsack {
    public static class Fpair implements Comparable<Fpair> {
        int val;
        int wt;
        Double frac;

        public Fpair(int val, int wt) {
            this.val = val;
            this.wt = wt;
            this.frac = val * 1.0 / wt;
        }

        @Override
        public int compareTo(Fpair other) {

            // this is wrong consition because we are running our pq on a double variable
            // return this.frac - other.frac;
            if (this.frac > other.frac) {
                return 1;
            } else if (this.frac < other.frac) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void printFractionalKnapsack(int[] wts, int[] vals, int cap) {

        // Max Heap based on fractions(value/wt)
        // We dont need to sort the whole array based on fractions
        // we only require max fraction in each iteration
        PriorityQueue<Fpair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < wts.length; i++) {
            pq.add(new Fpair(vals[i], wts[i]));
        }
        double profit = 0;

        // This loop ensures as long as our bag is empty we get
        // in each iteration maximum fraction(value/wt) so far.
        while (pq.size() > 0 && cap > 0) {
            Fpair rem = pq.remove();

            // if we can add current item as whole
            if (rem.wt <= cap) {
                profit += rem.val;
                cap -= rem.wt;
            }
            // add current item partially
            // this has max (value/wt)
            // so it is gauranteed only this item can help in getting maximum profit
            else {
                profit += rem.frac * cap;
                cap = 0;
            }
        }

        System.out.println(profit);
    }

}
/*
 * 1. You are given a number n, representing the count of items. 2. You are
 * given n numbers, representing the values of n items. 3. You are given n
 * numbers, representing the weights of n items. 3. You are given a number
 * "cap", which is the capacity of a bag you've. 4. You are required to
 * calculate and print the maximum value that can be created in the bag without
 * overflowing it's capacity. Note1 -> Items can be added to the bag even
 * partially. But you are not allowed to put same items again and again to the
 * bag. Sample Input 10 33 14 50 9 8 11 6 40 2 15 7 2 5 9 3 2 1 10 3 3 5 Sample
 * Output 50.0
 */