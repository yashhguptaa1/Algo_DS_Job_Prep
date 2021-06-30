package RECURSION.BACKTRACKING;

import java.util.*;

//It is like Item Chooses box
//Items that is characters( PREFIXES)
//chooses
//Where to place brackets
//Levels : Prefix
//BreadthVise : Placing Brackets

public class C_PalidromePartition {

    public List<List<String>> partition(String s) {

        List<List<String>> res=new ArrayList<List<String>>();

        if(s.length()==0)
            return res;

        List<String>temp=new ArrayList<>();
        addPalindrome(s,0,temp,res);

        return res;
    }

    public boolean isPalindrome(String str)
    {
        int li = 0;
        int ri = str.length()-1;

        while(li < ri )
        {
            char left=str.charAt(li);
            char right=str.charAt(ri);
            if(left != right)
            {
                return false;
            }

            li++;
            ri--;

        }
        return true;
    }

    public void addPalindrome(String str,int start,List<String>partition,List<List<String>> res)
    {
        if( str.length() == 0)
        {
            List<String>temp=new ArrayList<>(partition);

            res.add(new ArrayList<>(temp));

            return;
        }

        for(int i=0;i<str.length();i++)
        {
            String prefix = str.substring(0,i+1);
            String ros = str.substring(i+1);
            if(isPalindrome(prefix)){

                partition.add(prefix);
                addPalindrome(ros,i,partition,res);
                partition.remove(partition.size()-1);
            }
        }
    }
}

/*
131. Palindrome Partitioning
Medium

3674

117

Add to List

Share
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.



Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]


Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
 */

//This solution is like
//box Chooses Item
//Brackets Chooses which Prefix it will take under consideration
//Placing Brackets denote Levels
//BreadthVise: Prefix being considered
/*
public ArrayList<ArrayList<String>> partition(String s) {
	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

	if (s == null || s.length() == 0) {
		return result;
	}

	ArrayList<String> partition = new ArrayList<String>();//track each possible partition
	addPalindrome(s, 0, partition, result);

	return result;
}

private void addPalindrome(String s, int start, ArrayList<String> partition,
		ArrayList<ArrayList<String>> result) {
	//stop condition
	if (start == s.length()) {
		ArrayList<String> temp = new ArrayList<String>(partition);
		result.add(temp);
		return;
	}

	for (int i = start + 1; i <= s.length(); i++) {
		String str = s.substring(start, i);
		if (isPalindrome(str)) {
			partition.add(str);
			addPalindrome(s, i, partition, result);
			partition.remove(partition.size() - 1);
		}
	}
}
 */