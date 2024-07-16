class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        int buy=prices[0];
       for(int i=1;i<prices.length;i++){
         if(buy>=prices[i]){
               buy=prices[i];
         }
         else if(prices[i]-buy>maxprofit){
             maxprofit=prices[i]-buy;
         }
       }
       return maxprofit;
    }
}