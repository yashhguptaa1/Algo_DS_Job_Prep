package RECURSION.Type_R2_PostOrder_Rec_Call.Work_ReturnAns_in_PostPhase.SingleRecCall;

import java.util.*;

public class PowerLogarithmic {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(powerBtr(x, n));
    }

    public static int powerBtr(int x, int n) {
        if (n == 0)
            return 1;

        
        int xpnb2 = powerBtr(x, n / 2);
        int xn = xpnb2 * xpnb2;

        if (n % 2 == 1) {
            xn = xn * x;
        }

        return xn;
    }

    public static int powerBtrShorthandVersion(int x, int n) {
        if (n == 0)
            return 1;

        return (n % 2 == 1) ? powerBtrShorthandVersion(x, n / 2) * powerBtrShorthandVersion(x, n / 2) * x
                : powerBtrShorthandVersion(x, n / 2) * powerBtrShorthandVersion(x, n / 2);
    }
}
