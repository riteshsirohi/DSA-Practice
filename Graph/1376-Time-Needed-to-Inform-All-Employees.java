class Solution {
    int ans = 0;
   private void DFS( ArrayList<ArrayList<Integer>> adj, int curr, int[] informtime, int currtime){
       ans = Math.max(ans,currtime);

       for(int v : adj.get(curr)){
          DFS(adj,v,informtime,currtime+informtime[curr]);
       }
   }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<manager.length;i++){
            int emp = i;
            int mangr = manager[i];
            if(mangr!=-1)
            adj.get(mangr).add(emp);
        }
        DFS(adj,headID,informTime,0);

        return ans;
    }
}