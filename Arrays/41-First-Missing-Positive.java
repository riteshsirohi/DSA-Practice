class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int max = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max = Math.max(max,nums[i]);
        }
        for(int i=1;i<max;i++){
          if(!map.containsKey(i)){
            return i;
          }
       }
       return max+1;
    }
}