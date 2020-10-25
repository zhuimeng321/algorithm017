// 127. 单词接龙
class Solution {
	// 思路：把问题规化为多叉树的层级遍历
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return level;
                }
                char[] curArray = cur.toCharArray();
                for (int i = 0; i < curArray.length; i++) {
                    char old = curArray[i];
                    for (int j = 0; j < 26; j++) {
                        curArray[i] = (char) ('a' + j);
                        String tmp = new String(curArray);
                        if (!visited.contains(tmp) && wordSet.contains(tmp)) {
                            visited.add(tmp);
                            queue.offer(tmp);
                        }
                    }
                    curArray[i] = old;
                }
            }
            level++;
        }
        return 0;
    }
}