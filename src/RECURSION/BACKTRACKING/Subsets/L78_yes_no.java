package A_recursion.BACKTRACKING.Subsets;

import java.util.*;

public class L78_yes_no {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();
        combinations(0,new ArrayList<>(),res,nums);
        return res;

    }
    public void combinations(int currIdx,List<Integer>asf,List<List<Integer>>res,int nums[])
    {
        if(currIdx == nums.length)
        {
            res.add(new ArrayList<>(asf));
            return;
        }

        //YES

        //MARK
        asf.add(nums[currIdx]);
        //LEVEL
        combinations(currIdx+1,asf,res,nums);
        //UNMARK
        asf.remove(asf.size()-1);

        //NO
        combinations(currIdx+1,asf,res,nums);
    }

    public static void main(String[] args) {
        int nums[]={1,2,3};
        L78_yes_no r=new L78_yes_no();
        System.out.println(r.subsets(nums));
    }
}

//Kis box ne last time current item ko select kiya tha
