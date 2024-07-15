class Solution {
    public int findDuplicate(int[] nums) {
    int[] arr = new int[nums.length];
    for(int n : nums){
        arr[n]++; // each n in nums corresponding arr idx is updated
        
        if(arr[n]>1){
            return n;
        }
    }
    return -1;
    }
}