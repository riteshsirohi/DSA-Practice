class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0;
        int left = 0;
        int right = col-1;
        int bottom = row-1;

        int dir=0;

        while(top<=bottom && left<=right){
            if(dir==0){
                for(int i=left;i<=right;i++){
                    ans.add(matrix[top][i]);
                }
                top++;
            }
            if(dir==1){
                for(int i=top;i<=bottom;i++){
                    ans.add(matrix[i][right]);
                }
                right--;
            }
            if(dir==2){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(dir==3){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir+1)%4;
        }
        return ans;
    }
}