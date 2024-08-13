class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        Stack<Integer> count = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num=0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
            num = num * 10 + ch - '0';
            }else if(ch=='['){
               count.push(num);
               st.push(sb.toString());
               sb = new StringBuilder();
               num=0;
            }else if(ch==']'){
              StringBuilder temp = new StringBuilder(st.pop());
              int size = count.pop();
              for(int i=0;i<size;i++){
                temp.append(sb);
              }
              sb=temp;
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}