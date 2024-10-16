class Solution {
    private void solve(int start, int[] candidates, List<List<Integer>> ans, List<Integer> temp, int target){
         if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
         }
         if(target<0){
            return;
         }
 
        for(int i=start;i<candidates.length;i++){
            temp.add(candidates[i]);
            solve(i,candidates,ans,temp,target-candidates[i]);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(0,candidates,ans,new ArrayList<>(), target);

        return ans;
    }
}