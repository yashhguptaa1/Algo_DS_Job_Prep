package STACKS.Category_S2;

import java.util.*;
public class TrappingRainWater {
    public int trap(int[] height) {

        // Stores the indices of the bars
        Stack<Integer> stack = new Stack<>();

        // size of the array
        int n = height.length;

        // Stores the final result that is total water that can be trapped
        int ans = 0;

        // Loop through the each bar
        for (int i = 0; i < n; i++) {

            // Remove bars from the stack
            // until the condition holds

            // We can see this logic is used in
            //NEXT GREATER ON RIGHT
            while ((!stack.isEmpty())
                    && (height[stack.peek()] < height[i])) {

                // store the height present at top of stack
                // and pop it.
                int pop_height = height[stack.peek()];
                stack.pop();

                // If the stack does not have any
                // bars or the the popped bar
                // has no left boundary
                if (stack.isEmpty())
                    break;

                // Get the distance between the
                // left and right boundary of
                // popped bar

                //NGR = Current Bar
                //NGL = stack.peek() that is at top of stack
                int distance = i - stack.peek() - 1;

                // Calculate the min. height
                //water can only be contained to a height
                //till whichever boundary has lower height
                int bounded_min_height= Math.min(height[stack.peek()],height[i]) - pop_height;

                // add water that can be contained on top of
                //bar that was popped
                ans += distance * bounded_min_height;
            }

            // If the stack is either empty or
            // height of the current bar is less than
            // or equal to the top bar of stack

            //also we push the current bar which was NGR for previous
            //bar
            //as Current bar might get a NGR for itself in future
            stack.push(i);
        }

        return ans;

    }
}

/*

WHY WE NEED TO CALCULATE DISTANCE

COnsider Input
            |
            |
|           |
|           |
|           |
|           |
|       |   |
|   .   |   |
6   0   2   8

first we get water at top of bar of 0 height
ans=2 for now

in next iteration water is filled between bar6 and bar2
now we want to fill water in between bar6 and bar8

so for these cases we will need to calculate distance between
bar6 and bar8

Finding NEXT GREATER ON LEFT WILL NOT HELP US
cauz unlike largest area histogram
we want to find water on top of each bar

so if there are many bars of varying heights and they have same
NGR and NGL we can not generalize our solution as each bar will have
different amount on water on top

So to overcome this
We push NGL and smaller than NGL in stack
Whenever our Current Height is NGR for bars we met previously(in stack)
We found RightBoundary for CurrentBar

Since We break as soon as we meet NGR
so it means the bar just before top of stack must have been NGL
for the Popped Bar

*/