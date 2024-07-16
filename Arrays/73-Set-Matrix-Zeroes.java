class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashMap<Integer, Boolean> x = new HashMap<>();
        HashMap<Integer, Boolean> y = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    x.put(i, true);
                    y.put(j, true);
                }
            }
        }

        for (int i : x.keySet()) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int j : y.keySet()) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
