class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] inrecursion = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                DFS(graph,i,visited,inrecursion);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(inrecursion[i]==false){
                   res.add(i);
            }
        }
        return res;
    }
    private boolean DFS(int[][] graph, int u, boolean[] visited, boolean[] inrecursion){
        visited[u]=true;
        inrecursion[u]=true;

        for(int v : graph[u]){
           if(!visited[v] && DFS(graph,v,visited,inrecursion)){
            return true;
           }else if(inrecursion[v]==true){
            return true;
           }
        }
        inrecursion[u]=false;
        return false;
    }
}