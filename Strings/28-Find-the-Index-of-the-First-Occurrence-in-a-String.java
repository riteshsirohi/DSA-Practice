class Solution {
    public int strStr(String haystack, String needle) {
        char[] s1 = haystack.toCharArray();
        char[] s2 = needle.toCharArray();

        for (int i = 0; i <= s1.length - s2.length; i++) {
            int j;
            for (j = 0; j < s2.length; j++) {
                if (s1[i + j] != s2[j]) {
                    break;
                }
            }
            if (j == s2.length) {
                return i; 
            }
        }
        return -1;
    }
}
//haystack.indexOf(needle);