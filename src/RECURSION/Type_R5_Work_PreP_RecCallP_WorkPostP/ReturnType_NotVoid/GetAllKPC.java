package RECURSION.Type_R5_Work_PreP_RecCallP_WorkPostP.ReturnType_NotVoid;

import java.util.*;
public class GetAllKPC {

    public static String codes[]={".;" , "abc","def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx","yz"};

    public static void main(String[] args) throws Exception {

        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        ArrayList<String> res=getKpc(str);
        System.out.println(res);
    }

    //Basically using Recursion we are reaching the last character and getting an empty bucket
    //now while going back( popping the recursive call from stack) we make arraylist and update ans
    public static ArrayList<String > getKpc(String str)
    {
        if(str.length() == 0)
        {
            ArrayList<String>emptyBucket=new ArrayList<>();
            emptyBucket.add("");
            return emptyBucket;
        }

        char ch= str.charAt(0);
        String restOfStr=str.substring(1);
        ArrayList<String>resFromRec=getKpc(restOfStr);

        char codesForCurr[]=codes[ch-'0'].toCharArray();
        ArrayList<String>currRecRes=new ArrayList<>();

        for(char code: codesForCurr)
        {

            for(String s:resFromRec)
            {
                currRecRes.add(code +s);

            }
        }
        return currRecRes;
    }

}
