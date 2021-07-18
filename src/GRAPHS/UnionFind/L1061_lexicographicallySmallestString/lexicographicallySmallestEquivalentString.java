package GRAPHS.UnionFind.L1061_lexicographicallySmallestString;

public class lexicographicallySmallestEquivalentString {

    static int par[]=new int[26];

    public static int findPar(int u)
    {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }

    public static String smallestEquivalentString(String A, String B, String S)
    {
        for (int i = 0; i < 26; i++)
            par[i]=i;

        for (int i = 0; i < A.length(); i++)
        {
            int p1 = findPar(A.charAt(i) - 'a');
            int p2 = findPar(B.charAt(i) - 'a');

            //Since in question its given we have to return lexicographically smallest
            //we make leader of each component the smallest alphabet
            par[p1] = Math.min(p1, p2);
            par[p2] = Math.min(p1, p2);
        }

        String ans = "";
        for (int i = 0; i < S.length(); i++)
        {
            ans += (char)(findPar(S.charAt(i) - 'a') + 'a');
        }

        return ans;
    }

}
