class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;

        for (int i = 0; i < nums.length; i++) {
            right = Math.max(right, nums[i]);
        }
        int res = right;
        while (left < right) {
            int penalty = (left + right) / 2;
            int op = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > penalty) {
                    if (nums[i] % penalty == 0) {
                        op += nums[i] / penalty - 1;
                    } else {
                        op += nums[i] / penalty;
                    }
                }
            }
            if(op<=maxOperations){
                res = penalty;
                right = penalty;
            }else{
                left = penalty+1;
            }
        }
        return res;
    }
}