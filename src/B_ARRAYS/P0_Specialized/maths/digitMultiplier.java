package B_ARRAYS.P0_Specialized.maths;

public class digitMultiplier {

    static String getSmallest(Long num) {

        if (num == 1)
            return "1";

        String res = "";

        // starting from 9 so we have to find least number of factors
        for (int i = 9; i >= 2; i--) {
            while (num % i == 0) {
                // appending in reverse order to obtain smallest number
                res = i + res;
                num /= i;
            }
        }

        // if num is now a prime number greater than 9
        return num != 1 ? "-1" : res;
    }
}
