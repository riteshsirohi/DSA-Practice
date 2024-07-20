class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0) return 0;

        Stack<Integer> st = new Stack<>();

        int curr = 0;
        int op = '+';
        char[] arr = s.toCharArray();

        for(int i=0;i<arr.length;i++){
             if(Character.isDigit(arr[i])){
            curr = curr * 10 + arr[i] - '0'; 
             }

        if(!Character.isDigit(arr[i]) && arr[i] != ' ' || i == arr.length-1){
           if(op=='+'){
               st.push(curr);
           }else if(op=='-'){
                st.push(-curr);
           }else if(op=='*'){
               st.push(st.pop()*curr);
           }else if(op=='/'){
               st.push(st.pop()/curr);
           }
           op = arr[i];
           curr = 0;
        }
        }
        int sum = 0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
    }
}