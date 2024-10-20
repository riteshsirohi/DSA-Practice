class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        int count = 0;
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
             if(k==0){
                if(entry.getValue()>=2){
                    count++;
                }
             }else{
                if(map.containsKey(entry.getKey()+k)){
                    count++;
                }
             }
        }
        return count;
    }
}