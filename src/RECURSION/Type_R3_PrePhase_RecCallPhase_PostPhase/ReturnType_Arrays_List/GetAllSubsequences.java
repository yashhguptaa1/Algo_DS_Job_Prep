package RECURSION.Type_R3_PrePhase_RecCallPhase_PostPhase.ReturnType_Arrays_List;

import java.util.*;
public class GetAllSubsequences {

    public static void main(String[] args) throws Exception {

        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        ArrayList<String>res=getSubSeq(str);
        System.out.println(res);
    }

    public static ArrayList<String > getSubSeq(String str)
    {
        if(str.length() == 0)
        {
            ArrayList<String>emptyBucket=new ArrayList<>();
            emptyBucket.add("");
            return emptyBucket;
        }

        char ch= str.charAt(0);

        ArrayList<String>resFromRec=getSubSeq(str.substring(1));

        //UPDATE ANS SO FAR WHEN YOU RETURN BACK TO THIS CALL
        ArrayList<String>currRecRes=new ArrayList<>();

        for(String s: resFromRec)
            currRecRes.add("" +s);

        for(String s:resFromRec)
            currRecRes.add(ch + s);

        return currRecRes;
    }

}
