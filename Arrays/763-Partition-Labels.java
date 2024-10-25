class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] lastidx = new int[26];
        
        for(int i=0;i<s.length();i++){
           lastidx[s.charAt(i)-'a'] = i;
          }  int j = 0;
           int start = 0;
           for(int i=0;i<s.length();i++){
             j = Math.max(j, lastidx[s.charAt(i)-'a']);
             if(i==j){
                ans.add(i-start+1);
                start = i+1;
             }
           }
        return ans;
    }
}