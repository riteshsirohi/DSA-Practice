class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>> st = new Stack<>();

        for(char ch:s.toCharArray()){
            if(!st.isEmpty() && st.peek().getKey()==ch){
                int count = st.pop().getValue();
                st.push(new Pair<>(ch,count+1));
            }else{
                st.push(new Pair<>(ch,1));
            }
            if(st.peek().getValue()==k){
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Pair<Character,Integer> pair:st){
            char ch = pair.getKey();
            int count = pair.getValue();
            for(int i=0;i<count;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}