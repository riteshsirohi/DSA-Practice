class Solution {
    public int maxSubArray(int[] nums) {
        int currsum = nums[0];
        int max = nums[0];

        for(int i=1;i<nums.length;i++){
            currsum = Math.max(nums[i], currsum+nums[i]);

            if(currsum>max){
              max = currsum;
            }
        }
        return max;
    }
}