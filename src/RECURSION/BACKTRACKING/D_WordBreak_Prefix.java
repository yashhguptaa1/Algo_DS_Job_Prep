package A_recursion.BACKTRACKING;

import java.util.*;
public class D_WordBreak_Prefix {

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> res=new ArrayList<>();

        if(s.length()==0)
            return res;

        //Given in ques
        //All the strings of wordDict are unique.
        //Make HashSet of Dictionary to search in constant time
        HashSet<String>dict=new HashSet<>();

        for(String str : wordDict)
            dict.add(str);

        wordBreakHelper(s,"",res,dict);

        Collections.reverse(res);
        return res;

    }

    public void wordBreakHelper(String str,String ansSoFar,List<String>res,HashSet<String>dict)
    {

        if(str.length() == 0)
        {
            StringBuffer temp=new StringBuffer(ansSoFar);
            temp.deleteCharAt(temp.length()-1);
            res.add(temp.toString());
            return;
        }

        for(int i=0;i<str.length();i++)
        {
            String left = str.substring(0,i+1);
            if(dict.contains(left))
            {
                String right = str.substring(i+1);

                wordBreakHelper(right,ansSoFar + left + " ",res,dict);
            }
        }
    }
}
