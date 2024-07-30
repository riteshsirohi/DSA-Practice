class StockSpanner {
    Stack<Pair<Integer,Integer>> st;
    int count = 0;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        while(!st.isEmpty() && st.peek().getKey() <= price){
            st.pop();
        }
        
        int ans;
        if(st.isEmpty()){
            ans = count + 1;
        } else {
            ans = count - st.peek().getValue();
        }
        
        st.push(new Pair<>(price, count++));
        return ans;
    }
}
