package B_ARRAYS.P0_Specialized.Segregate_Mark_ArrIndex;

import java.util.*;

public class bestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        ArrayList<Integer> xcord = new ArrayList<>();
        // fill xcordinate in sorted manner -> row wise traversal
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1)
                    xcord.add(r);
            }
        }
        ArrayList<Integer> ycord = new ArrayList<>();
        // fill ycordinate in sorted manner -> column wise traversal
        for (int c = 0; c < grid[0].length; c++) {
            for (int r = 0; r < grid.length; r++) {
                if (grid[r][c] == 1)
                    ycord.add(c);
            }
        }
        // find meeting point
        int x = xcord.get(xcord.size() / 2);
        int y = ycord.get(ycord.size() / 2);
        int dist = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    dist += Math.abs(x - r) + Math.abs(y - c);
                }
            }
        }
        return dist;
    }
}
