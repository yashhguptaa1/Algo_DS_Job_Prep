package B_ARRAYS.P0_Specialized;

import java.util.*;

public class CarFleets {
    private class Pair implements Comparable<Pair> {
        int pos;
        int speed;

        public Pair(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        public int compareTo(Pair o) {
            return this.pos - o.pos;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {

        // Creation of MAX heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < position.length; i++) {
            pq.add(new Pair(position[i], speed[i]));
        }

        double maxT = 0; // breakpoint
        int fleets = 0; // fleet count

        while (pq.size() > 0) {
            Pair rem = pq.remove();

            // cars reaching almost at the same time at destination
            // will form a single fleet
            double time = (target - rem.pos) / (rem.speed * 1.0);
            if (time > maxT) {
                fleets++;
                maxT = time;
            }
        }
        return fleets;
    }
}
