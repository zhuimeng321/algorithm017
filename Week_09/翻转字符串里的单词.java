// 151. 翻转字符串里的单词

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1, j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            sb.append(s.substring(i + 1, j + 1) + ' ');
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }
}