class Solution {
    public int maxProduct(int[] nums) {
        int maxsofar = nums[0];
        int minsofar = nums[0];
        int res = nums[0];

        for(int i=1;i<nums.length;i++){
            int copymax = maxsofar;
            int el = nums[i];

           maxsofar = Math.max(el, Math.max(el*maxsofar, el*minsofar));

           minsofar = Math.min(el, Math.min(el*minsofar, el*copymax)); 

           res = Math.max(res,maxsofar);
        }
        return res;
    }
}