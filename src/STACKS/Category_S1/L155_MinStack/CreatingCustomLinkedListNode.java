package STACKS.Category_S1.L155_MinStack;

public class CreatingCustomLinkedListNode {

    class MinStack {

        class Node{
            int val, minSofar;
            Node next;

            Node(int val, int minSofar){
                this.val = val;
                this.minSofar = minSofar;
                this.next = null;
            }
        }

        Node topOfStack;


        public MinStack() {

            topOfStack=null;

        }

        public void push(int x) {
            Node l1;
            if(topOfStack == null){
                l1 = new Node(x, x);
            } else {
                l1 = new Node(x, Math.min(x, topOfStack.minSofar));
                l1.next = topOfStack;
            }
            topOfStack = l1;
        }

        public void pop() {
            if(topOfStack != null){
                topOfStack = topOfStack.next;
            }
        }

        public int top() {
            if(topOfStack == null){
                return -1;
            }
            return topOfStack.val;
        }

        public int getMin() {
            if(topOfStack == null){
                return -1;
            }
            return topOfStack.minSofar;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
