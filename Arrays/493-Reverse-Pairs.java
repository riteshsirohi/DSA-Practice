class Solution {
    public int reversePairs(int[] nums) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<j && j<n && nums[i]>nums[j]*2){
                    count++;
                }
            }
        }
        return count;
    }
}