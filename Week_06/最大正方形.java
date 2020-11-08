// 221. 最大正方形

// 时间复杂度：O(mn),空间复杂度:O(mn)
// 思路：求最大边长，最大变长=min（左方，上方，左上方） + 1 （当前位置为1时）

class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSlide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                    maxSlide = Math.max(maxSlide, dp[i][j]);
                }
            }
        }
        return maxSlide * maxSlide;
    }
}