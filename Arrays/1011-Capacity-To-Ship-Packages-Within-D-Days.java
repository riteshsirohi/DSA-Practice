class Solution {
    private int find(int[] weights, int cap){
        int days = 1, load = 0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]+load>cap){
                days++;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for(int i=0;i<weights.length;i++){
            right += weights[i];
            left = Math.max(left,weights[i]);
        }

        while(left<=right){
            int mid = (left + right)/2;

            int nofdays = find(weights,mid);

            if(nofdays<=days){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
       return left;
    }
}