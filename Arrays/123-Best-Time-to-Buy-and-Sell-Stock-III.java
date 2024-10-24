class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

       if(n==0) return 0;

       int fb = Integer.MIN_VALUE;
       int sb = Integer.MIN_VALUE;
       int fs = 0;
       int ss = 0;

       for(int i=0;i<n;i++){
        fb = Math.max(fb, -prices[i]);
        fs = Math.max(fs, fb+prices[i]);
        sb = Math.max(sb, fs-prices[i]);
        ss = Math.max(ss, sb+prices[i]);
       }
       return ss;
    }
}