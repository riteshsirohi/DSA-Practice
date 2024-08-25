class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

       for(int i : asteroids){
        while(!st.isEmpty() && i<0 && st.peek()>0){

            int sum = i + st.peek();

            if(sum<0){
                st.pop();
            }else if(sum>0){
                i=0;
            }else{
                st.pop();
                i=0;
            }
        }
        if(i!=0){
            st.push(i);
        }
       }
         int k = st.size()-1;
         int[] res = new int[st.size()];
         while(!st.isEmpty()){
            res[k--]=st.pop();
         }
       return res;
    }
}