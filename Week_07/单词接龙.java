// 127.单词接龙

// 双向bfs
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                HashSet<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            HashSet<String> next = new HashSet<>();
            for (String word : beginSet) {
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    char orig = wordArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[i] = c;
                        String newWord = new String(wordArray);
                        if (endSet.contains(newWord)) {
                            return step + 1;
                        }
                        if (!visited.contains(newWord) && wordSet.contains(newWord)) {
                            visited.add(newWord);
                            next.add(newWord);
                        }
                    }
                    wordArray[i] = orig;
                }
            }
            step++;
            beginSet = next;
        }
        return 0;
    }

}
