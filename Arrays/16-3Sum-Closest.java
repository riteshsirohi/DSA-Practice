class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closetsum = 10000000;

        for (int i = 0; i < nums.length - 2; i++) {

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(closetsum - target)) {
                    closetsum = sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return closetsum;
    }
}