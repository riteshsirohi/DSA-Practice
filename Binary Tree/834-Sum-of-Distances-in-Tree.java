class Solution {
    List<List<Integer>> adj;
    int[] count, answer;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        adj = new ArrayList<>();
        count = new int[n];
        answer = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        DFS(0,-1);
        DFS2(0,-1,n);

        return answer;
    }
    private void DFS(int node, int parent){
        count[node]+=1;
        for(int neighbour:adj.get(node)){
            if(neighbour==parent) continue;
            DFS(neighbour,node);
            count[node]+=count[neighbour];
            answer[node] += answer[neighbour]+count[neighbour];
        }
    }
    private void DFS2(int node, int parent, int n){
        for(int neighbour:adj.get(node)){
            if(neighbour==parent) continue;

            answer[neighbour] = answer[node]-count[neighbour]+(n-count[neighbour]);
            DFS2(neighbour,node,n);
        }
    }
}