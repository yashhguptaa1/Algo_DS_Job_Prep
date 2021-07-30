package A_recursion.DivideAndConquer.BinarySearch.SortedArr;

public class I_L50_PowerOfNum {

    public double myPow(double x, long n) {

        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }

        double ans;

        if(n<0)
        {

            x=(double)1/x;
            n=-n;
        }

        double temp=myPow(x, n/2) ;


        if(n%2==0){
            ans =((temp)*(temp));
        }else{

            ans= (x*temp)*(temp);
        }



        return ans;

    }
}

/*
On InterviewBit Using Mod
public class Solution {
    //    Mod questions can be solved in two ways
//    First way solve question using long
    public int pow(int x, int n, int d) {
        int ans = (int)pow(x*1L, n*1L, d*1L);
        return ans < 0 ? d + ans : ans;
    }
    public long pow(long x, long n, long d){
        if(x == 0)
            return 0;

        if(n == 0)
            return 1;

        long xpnb2 = pow(x, n/2, d)%d;
        long xn = (xpnb2*xpnb2)%d;

        if(n % 2 == 1)
            xn = (xn * x)%d;

        return xn;
    }

}

public class Solution {
    public int pow(int x, int n, int d) {
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }

        if(x<0){
            return pow(x+d, n, d);
        }
        long ans;
        long temp= pow(x, n/2,d);
        if(n%2==0){
            ans =((temp%d)*(temp%d))%d;
        }else{
            ans= ((((x%d)*(temp%d))%d)*(temp%d))%d;
        }

        return (int)ans;

    }

}

 */