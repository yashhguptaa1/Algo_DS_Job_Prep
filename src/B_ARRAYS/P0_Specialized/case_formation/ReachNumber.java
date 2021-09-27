package B_ARRAYS.P0_Specialized.case_formation;

public class ReachNumber {

    public int reachNumber(int target) {
        target = Math.abs(target);

        int jump = 0;
        int s = 0;

        while (s < target) {
            jump++;
            s += jump;
        }

        if (s == target) {
            return jump;
        } else if ((s - target) % 2 == 0) {
            return jump;
        } else if ((s + jump + 1 - target) % 2 == 0) {
            return jump + 1;
        } else {
            return jump + 2;
        }
    }
}
