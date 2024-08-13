class Solution {
    int n;
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;

        for(int i=0;i<n;i++){
            if(found)break;
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    DFS(grid,i,j,q);
                    found=true;
                    break;
                }
            }
        }
         int flips = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                for (int[] dir : directions) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        if (grid[x][y] == 1) {
                            return flips;
                        } else if (grid[x][y] == 0) {
                            grid[x][y] = 2;
                            q.add(new int[]{x, y});
                        }
                    }
                }
            }
            flips++;
        }
        
        return -1; // this should never happen if the input is correct
    }
    
    private void DFS(int[][] grid, int i, int j, Queue<int[]> q){
        if(i<0 || i>=n || j<0 || j>=n || grid[i][j]!=1){
            return;
        }
        grid[i][j]=2;
        q.offer(new int[]{i,j});
        for(int[] dir : directions){
            DFS(grid, i+dir[0], j+dir[1], q);
        }
    }
}