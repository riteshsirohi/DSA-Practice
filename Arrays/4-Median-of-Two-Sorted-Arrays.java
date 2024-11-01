class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                ans.add(nums1[i++]);
            }else{
                ans.add(nums2[j++]);
            }
        }
        while(i<m){
            ans.add(nums1[i++]);
        }
        while(j<n){
            ans.add(nums2[j++]);
        }
        int total = ans.size();

        if((total)%2==1){
            return (double) ans.get(total/2);
        }
        return (double) (ans.get(total/2) + ans.get(total/2-1)) / 2;
    }
}