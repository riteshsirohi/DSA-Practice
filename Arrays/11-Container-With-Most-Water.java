class Solution {
    private int compare(int[] height,int left,int right){
      int diff = Math.abs(left-right);
      int min = Math.min(height[left],height[right]);
      int water=diff*min;
      return water;
    }
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxwater=0;

        while(left<right){
           int water=compare(height,left,right);
           maxwater=Math.max(maxwater,water);

           if(height[left]<height[right]){
               left++;
           }else{
               right--;
           }
        }
        return maxwater;
    }
}