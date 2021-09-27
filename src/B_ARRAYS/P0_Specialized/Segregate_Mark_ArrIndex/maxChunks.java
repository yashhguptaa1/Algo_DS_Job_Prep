package B_ARRAYS.P0_Specialized.Segregate_Mark_ArrIndex;

public class maxChunks {
    public int maxChunksToSorted1(int[] arr) {

        // chunks : Maximum number of chunks than can be made
        int chunks = 0;

        // max : Max valued Element So Far as we iterrate on array
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);

            // we reach ith index where we would have placed the max ele
            // if array was sorted
            if (max == i)
                chunks++;
        }
        return chunks;
    }
}
