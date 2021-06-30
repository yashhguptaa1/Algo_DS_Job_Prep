package DYNAMIC_PROGRAMMING.L_ArrangeBuildings;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/arrange-buildings-official/ojquestion
public class Pep_ArrangeBuildings {

    // ~~~~~~~~~~~~Arrange Buildings~~~~~~~~~~~
    public static long arrangeBuildings(int n) {
        long building = 1;
        long space = 1;

        for(int i = 2; i <= n; i++) {
            long n_building = space;
            long n_space = building + space;

            space = n_space;
            building = n_building;
        }
        long res = building + space;
        return res * res;
    }

}
/*
1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.
 */