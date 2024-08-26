class Solution {
    public int minSteps(String s, String t) {
        int[] sfreq = new int[26];
        int[] tfreq = new int[26];

        for(int i=0;i<s.length();i++){
            sfreq[s.charAt(i)-'a']++;
            tfreq[t.charAt(i)-'a']++;
        }
        int res=0;

        for(int i=0;i<26;i++){
            if(sfreq[i]>tfreq[i]){
                res+=sfreq[i]-tfreq[i];
            }
        }
        return res;
    }
}