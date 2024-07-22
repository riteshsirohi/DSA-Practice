class Solution {
    public void Dfs(char[][]grid,int row,int col,boolean[][]visited){
        if(row<0 || col<0 ||row>=grid.length|| col>=grid[0].length||visited[row][col]|| grid[row][col] =='0'){
            return;
        }
        visited[row][col]=true;
        Dfs(grid,row,col-1,visited);
        Dfs(grid,row-1,col,visited);
        Dfs(grid,row,col+1,visited);
        Dfs(grid,row+1,col,visited);
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited= new boolean[m][n];
        int Numberofislands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j] =='1'){
                    Dfs(grid,i,j,visited);
                    Numberofislands++;
                }
            }
        }
        return Numberofislands;
    }
}