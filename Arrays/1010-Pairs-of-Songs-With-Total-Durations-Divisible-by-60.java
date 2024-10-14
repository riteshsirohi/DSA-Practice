class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;

        for(int i=0;i<time.length;i++){
            int rem = time[i] % 60;
            int compliment = (60-rem) % 60;

            count += map.getOrDefault(compliment, 0);

            map.put(rem, map.getOrDefault(rem,0)+1);
        }

        return count;
    }
}