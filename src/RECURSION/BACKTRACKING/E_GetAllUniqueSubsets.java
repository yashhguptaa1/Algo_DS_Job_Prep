package RECURSION.BACKTRACKING;


//Going to Solve using
//Item chooses box
//Each number denotes each respective level
//BreadthVise : each number has options to which set does it want to go to
//              There are two options given to each number
//              1) Go /Append in existing set
//              2) Create a new set using current number

public class E_GetAllUniqueSubsets {


}

/*
698. Partition to K Equal Sum Subsets
Medium

3145

200

Add to List

Share
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.



Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false


Constraints:

1 <= k <= nums.length <= 16
1 <= nums[i] <= 104
The frequency of each element is in the range [1, 4].
 */