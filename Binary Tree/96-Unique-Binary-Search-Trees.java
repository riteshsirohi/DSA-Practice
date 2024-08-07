class Solution {
    public int numTrees(int n) {
        // Initialize a memoization table with -1 (indicating uncomputed values)
        int[][] memo = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        return numsTree(1, n, memo);
    }

    public int numsTree(int start, int end, int[][] memo) {
        if (start >= end) {
            return 1;
        }
        if (memo[start][end] != -1) {
            return memo[start][end];
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            count += numsTree(start, i - 1, memo) * numsTree(i + 1, end, memo);
        }
        memo[start][end] = count;
        return count;
    }
}
