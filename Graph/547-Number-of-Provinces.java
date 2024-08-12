class Solution {
    void DFS(int src, boolean[] visited, int[][] isConnected, int count) {
        visited[src] = true;
        for (int w = 0; w < isConnected.length; w++) {
            if (!visited[w] && isConnected[src][w] == 1) {
                DFS(w, visited, isConnected, count);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i, visited, isConnected, count);
                count++;
            }
        }
        return count;
    }
}
