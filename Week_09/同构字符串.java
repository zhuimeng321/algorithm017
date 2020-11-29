// 205. 同构字符串

// 映射到第三方再对比
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
                return false;
            }
            if (mapS[s.charAt(i)] == 0) {
                mapS[s.charAt(i)] = i + 1;
                mapT[t.charAt(i)] = i + 1;
            }
        }
        return true;
    }
}