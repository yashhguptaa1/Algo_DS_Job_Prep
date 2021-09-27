package B_ARRAYS.P0_Specialized.Segregate_Mark_ArrIndex;

public class rangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];

        // make impact of query on res
        for (int i = 0; i < updates.length; i++) {
            int st = updates[i][0];
            int end = updates[i][1];
            int inc = updates[i][2];

            res[st] += inc;

            if (end + 1 < length) {
                res[end + 1] -= inc;
            }
        }

        // apply impact on res using prefix sum
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }

}
