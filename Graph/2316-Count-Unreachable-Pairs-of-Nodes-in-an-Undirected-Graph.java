class Solution {
    int[] parent;
    int[] rank;
    int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    void union(int x, int y){
        int xparent = find(x);
        int yparent = find(y);

        if(xparent==yparent)return;

        if(rank[xparent]<rank[yparent]){
            parent[xparent] = yparent;
        }else if(rank[xparent]>rank[yparent]){
            parent[yparent] = xparent;
        }else{
            parent[xparent]=yparent;
            rank[yparent]++;
        }
    }
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }

        for(int[] x : edges){
            int u = x[0];
            int v = x[1];

            union(u,v);
        }
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int root = find(i);
            map.put(root,map.getOrDefault(root,0)+1);
        }
         long totalPairs = 0;
        long rem = n;
        for (int size : map.values()) {
            totalPairs += size * (rem - size);
            rem -= size;
        }

        return totalPairs;
    }
}