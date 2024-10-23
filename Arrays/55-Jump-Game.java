class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1) return true;

         int left = 0;
         int right = 0;

         while(right<n-1){
            int farther = 0;

            for(int i=left;i<=right;i++){
                farther = Math.max(farther, i+nums[i]);
            }
            if(farther >= n-1){
                return true;
            }
            left = right + 1;
            right = farther;

            if (left > right) {
                return false;
            }
         }
        return false;
    }
}