class Solution {
    private int solve(int i, int j, int row, int col, int[][] board){
      int live = 0;

      if(i+1<row && board[i+1][j] == 1 ) live++;
      if(j+1<col && board[i][j+1] == 1 ) live++;
      if(i-1>=0 && board[i-1][j] == 1 ) live++;
      if(j-1>=0 && board[i][j-1] == 1 ) live++;
      if(i+1 <row && j+1<col && board[i+1][j+1] == 1 ) live++;
      if(i-1>=0 && j-1>=0 && board[i-1][j-1] == 1 ) live++;
      if(i+1<row && j-1>=0 && board[i+1][j-1] == 1 ) live++;
      if(i-1>=0 && j+1<col && board[i-1][j+1] == 1 ) live++;
       
       return live;
    }

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] clone = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                clone[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int live = solve(i, j, row, col, clone);
                if (clone[i][j] == 1) {
                    if (live < 2 || live > 3) {
                        board[i][j] = 0;
                    } else {
                        board[i][j] = 1;
                    }
                } else {
                    if (live == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}