package STACKS.Category_S1.L901_OnlineStockSpan;

import java.util.*;

public class StockSpanner {

    class Pair {
        int index;
        int price;
    }

    Stack<Pair> st;
    int time;

    public StockSpanner() {

        time = 0;
        st = new Stack<>();

        Pair delimiter = new Pair();
        delimiter.index = -1;
        delimiter.price = 1000000;
        // To denote stack is empty
        st.push(delimiter);
    }

    public int next(int price) {

        Pair stock = new Pair();
        stock.index = time;
        stock.price = price;
        time++;

        // Next greater on left
        while (st.peek().price <= stock.price) {
            st.pop();
        }
        int res = stock.index - st.peek().index;

        st.push(stock);

        return res;

    }

}
