class Solution {
    private int[] NSR(int[] arr){
        int[] res= new int[arr.length];
        Stack<Integer> st = new Stack<>();
        int Rend=arr.length;

        for(int i=arr.length-1;i>=0;i--){
                while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    res[i]=st.peek();
                }else{
                    res[i]=Rend;
                }
            st.push(i);
            }
        return res;
        }
    private int[] NSL(int[] arr){
        int[] res= new int[arr.length];
        Stack<Integer> st = new Stack<>();
        int Lend=-1;

        for(int i=0;i<arr.length;i++){
                while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    res[i]=st.peek();
                }else{
                    res[i]=Lend;
                }
            st.push(i);
            }
        return res;
        }

    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        
        int[] nsl = NSL(heights);
        int[] nsr=  NSR(heights);

        int[] width = new int[n];
        int[] area= new int[n];
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
           width[i]=nsr[i]-nsl[i]-1;
        }
        for(int i=0;i<n;i++){
           area[i]=heights[i]*width[i];
           if(max<area[i]){
               max=area[i];
           }
        }
        return max;
    }
}