import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
       int start = 0;
       int end = nums.length-1;
       int res = 0;
        while(start<end){
            res+=nums[end--]-nums[start++];
        }
        return res;
    }
}
/*
 Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int res = 0;

        for (int num : nums) {
            res += Math.abs(num - median);
        }
        return res;
*/