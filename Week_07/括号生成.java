// 22.括号生成

class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        dfs(ans, n, 0, 0, "");
        return ans;
    }

    public void dfs(ArrayList<String> list, int max, int left, int right, String str) {
        if (left == max && right == max) {
            list.add(str);
            return;
        }
        if (left < max) {
            dfs(list, max, left + 1, right, str + "(");
        }
        if (right < left) {
            dfs(list, max, left, right + 1, str + ")");
        }
    }
}
