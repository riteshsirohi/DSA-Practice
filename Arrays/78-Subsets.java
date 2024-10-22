class Solution {
    private void solve(List<List<Integer>> ans, List<Integer> temp, int index, int[] nums) {
        ans.add(new ArrayList<>(temp));
        
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            solve(ans, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans, new ArrayList<>(), 0, nums); 
        return ans;
    }
}
