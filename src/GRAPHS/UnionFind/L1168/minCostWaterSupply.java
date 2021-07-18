package GRAPHS.UnionFind.L1168;
import java.util.*;

public class minCostWaterSupply {

    int[] par;

    int findPar(int u) {
        return par[u] == -1 ? u : (par[u] = findPar(par[u]));
    }


    public int minCostToSupplyWater(int N, ArrayList<int[]> Edges) {
        par = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            par[i] = i;
        }

        int cost = 0;
        for (int[] edge : Edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            int p1 = findPar(u);
            int p2 = findPar(v);

            if (p1 != p2) {
                par[p1] = p2;
                cost += w;
            }
        }
        return cost;
    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        ArrayList<int[]> PIPES = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            PIPES.add(new int[] { 0, i + 1, wells[i] });
        }

        for (int[] p : pipes)
            PIPES.add(p);

        Collections.sort(PIPES, (a, b) -> {
            return a[2] - b[2];
        });

        return minCostToSupplyWater(n, PIPES);
    }

    public static void main(String[] args) {

    }

}
/*
MST (Pure graph ko aise minimize kro ki saare edges ka sum min hojaye)solve krne ke do tareeke he
Prims
Kruskal

1) Prims me na graph bnana pdhta he,
    Agr bna bnaya graph mil jaaye toh prims lgaayo

2)jb koi prob sirf aur sirf edge ke term me de rkhi ho , toh better hota he kruskal lgana
    kyunki hum edges ko sort kr skte he
 */