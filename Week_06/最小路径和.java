// 64. 最小路径和


// 经典的动态规划题目
// 1.分解为子问题
// 2.定义状态转移

//时间复杂度：O(mn),空间复杂度：O(mn)
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rn = grid.length;
        int cn = grid[0].length;
        int[][] dp = new int[rn][cn];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rn; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < cn; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < rn; i++) {
            for (int j = 1; j < cn; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[rn-1][cn-1];
    }
}