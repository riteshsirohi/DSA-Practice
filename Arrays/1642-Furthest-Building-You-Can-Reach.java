class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);

        int i=0;
        for(;i<n-1;i++){
            if(heights[i]>=heights[i+1]){
                continue;
            }
            int diff = heights[i+1]-heights[i];

            if(diff<=bricks){
              bricks -= diff;
              pq.offer(diff);
            }else if(ladders>0){
                if(!pq.isEmpty()){
                    int past_max = pq.peek();
                    if(diff<past_max){
                        bricks += past_max;
                        pq.poll();
                        bricks -= diff;
                        pq.offer(diff);
                    }
                }
            ladders--;
            }else{
                break;
            }
        }
        return i;
    }
}