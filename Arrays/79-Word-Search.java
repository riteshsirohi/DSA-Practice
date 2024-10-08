class Solution {
    boolean solve(char[][] board, int row, int col, int i, int j, int idx, char[] arr){
       if(i>=row || j>=col || i<0 || j<0 || board[i][j]!=arr[idx] || board[i][j]=='.'){
            return false;
        }
        if(idx==arr.length-1){
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '.';

         boolean res = solve(board,row,col,i+1,j,idx+1,arr) ||
        solve(board,row,col,i,j+1,idx+1,arr) ||
        solve(board,row,col,i-1,j,idx+1,arr) ||
        solve(board,row,col,i,j-1,idx+1,arr);

        board[i][j] = temp;
        return res;
    }
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        int row = board.length;
        int col = board[0].length;

       for(int  i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(board[i][j]==arr[0] && solve(board,row,col,i,j,0,arr)){
                return true;
            }
        }
       }
       return false;
    }
}