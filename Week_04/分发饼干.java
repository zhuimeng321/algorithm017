// 455. 分发饼干

class Solution {
	// 时间复杂度：O(nlog(n) + mlog(m) + max(m,n));空间复杂度：O(1)
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++){
            if (g[i] <= s[j]) {
                i++;
            }
        }
        return i;
    }
}