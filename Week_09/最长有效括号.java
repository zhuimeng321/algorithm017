// 32. 最长有效括号

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        // dp[i] 表示以第i个元素结尾的有效括号的长度
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    // 正好和上一个形成一个有效的括号
                    dp[i] = (i - 2 >= 0 ? dp[i-2] : 0) + 2;
                } else if (i - 1 - dp[i-1] >= 0 && s.charAt(i-1-dp[i-1]) == '('){
                    // ()((...))场景，匹配到之前的左括号,结果还要加上再之前的
                    dp[i] = dp[i-1] + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}