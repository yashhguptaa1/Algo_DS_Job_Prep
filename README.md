"# Algo_DS_Job_Prep" 
There are already numerous courses,youtube content and websites present to teach you 
the solutions of Algo_Ds problems on LeetCode and InterviewBit.

The Purpose of this repo is to teach how to study these solutions so you can tackle new problems
and develop problem solving skills.

1) While Learning a Topic of DS by studying commonly asked questions, divide that topic according to different approaches and types of questions
in that topic and then bunch the similar types of questions in single clusters

2) Now All approaches for a particular topic are your tools/ways/techniques you can tackle future problems from that topic
The Hard and Medium Level topic will generally be solved by combination of these techniques or extension of these techniques

3) For Each Category of questions note KEYWORDS, BASIC INTUTION(TECHNIQUE) ,POSSIBLE EDGE CASES, GENERAL STRUCTURE of CODE SOLUTION

4 ) Now when you solve a new question,
    a) Note The TOPIC the question is asked from,
    b) (when you practice number of questions you can get idea of topic OR
    c) when you start from BRUTE FORCE APPROACH, you can see what DS/Algo can optimize the solution),
    d) Then once Topic is confirmed
    e) Note the KEYWORDS,
    f) Think of all the TECHNIQUES that you have already studied and try to fit in your solution
    g) Once it is confirmed, DRY RUN on two or three basic test cases(empty || one sized || large sized)
    h) Think of POSSIBLE EDGE CASES AND GENERAL CODE STRUCTURE
    i) LASTLY,the thing to note is the code should have variable names that makes code easier 
    j) to understand without much commenting
    
    Chances are you might not be able to do above steps immediately in high pressure situation
    In such scenarios first start with Brute Force Approach,
    Once you obtain solution using it, you will gain confidence as you can see some of the
    test cases passed.
    Now Optimize your code using the above steps


One way to note how loop works ,that is where it would point
after exiting without dry run is simple

check the breaking condition of loop

for example

for(int i=0 ; i<n;i++)
{
}

basically when loop exits iterator i will point to n

Linked list considering 0 based indexing

Node curr = head
int k = 4;
while(k -- > 0 && curr!=null)
{
curr=curr.next;
}
after exiting loop

The Topics Should be Revised In order
1) Recursion
2) Stacks
3) Linked List
4) Binary Tree
5) Divide and Conquer(Binary Search)
6) Binary Search Tree
7) Arrays
8) Heaps
9) HashMaps
