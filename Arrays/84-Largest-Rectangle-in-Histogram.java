class Solution {
    private int[] NSL(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
            st.pop();
        }
        if(st.isEmpty()){
           res[i] = -1;
        }else{
            res[i] = st.peek();
        }
        st.push(i);
      } 
      return res;
    }

    private int[] NSR(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
           while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
            st.pop();
           }
           if(st.isEmpty()){
            res[i] = arr.length;
           }else{
            res[i] = st.peek();
           }
           st.push(i);
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int n = heights.length;

        int[] NSr = NSR(heights);
        int[] NSl = NSL(heights);

        int[] width = new int[n];
        int[] area = new int[n];

        for(int i=0;i<n;i++){
            width[i] = NSr[i]-NSl[i]-1;
        }
        for(int i=0;i<n;i++){
            area[i] = heights[i] * width[i];
            if(max<area[i]){
                max = area[i];
            }
        }
        return max;
    }
}