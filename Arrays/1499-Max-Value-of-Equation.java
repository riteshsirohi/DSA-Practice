class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
       int n = points.length;
        int max = Integer.MIN_VALUE;
        int flag=1;

        for(int i=0;i<n;i++){
            if(flag<i+1) flag = i+1;
            for(int j=flag;j<n;j++){
                int val = Math.abs(points[i][0]-points[j][0]);
                if(val<=k){
                 int eq = points[i][1]+points[j][1]+val;
                 if(eq > max){
                        max = eq;
                        flag = j;
                    }
                }else{
                    break;
                }
            }
        }
        return max;
    }
}