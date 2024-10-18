class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalsum = 0;
        for(int i=0;i<cardPoints.length;i++){
            totalsum += cardPoints[i];
        }
        if(cardPoints.length==k) return totalsum;
        int sum = 0;
        for(int i=0;i<cardPoints.length-k-1;i++){
            sum+= cardPoints[i];
        }
        int ans = 0;
        for(int i=cardPoints.length-k-1;i<cardPoints.length;i++){
            sum += cardPoints[i];
            ans = Math.max(ans,totalsum-sum);
            sum -= cardPoints[i-(cardPoints.length-k-1)];
        }
        return ans;
    }
}