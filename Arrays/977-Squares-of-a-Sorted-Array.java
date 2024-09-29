class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0; 
        int right = nums.length-1;
        int index = nums.length-1;

        while(left<=right){
            int lsum = nums[left]*nums[left];
            int rsum = nums[right]*nums[right];

            if(lsum>rsum){
                res[index] = lsum;
                left++;
            }else{
                res[index] = rsum;
                right--;
            }
            index--;
        }
        return res;
    }
}