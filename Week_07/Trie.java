// 208. 实现 Trie (前缀树)

// 时间复杂度为:O(m)，其中m为键值长
// 空间复杂度：O(1)
class Trie {

    class TrieNode {
        private int R = 26;
        private TrieNode[] links;
        private boolean isEnd;

        TrieNode() {
            links = new TrieNode[26];
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }
        
        public boolean containKeys(char c) {
            return links[c - 'a'] != null;
        }

        public void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (!node.containKeys(curLetter)) {
                node.put(curLetter, new TrieNode());
            }
            node = node.get(curLetter);
        }
        node.setEnd(true);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containKeys(curLetter)) {
                node = node.get(curLetter);
            } else {
                return false;
            }
        }
        return node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curLetter = prefix.charAt(i);
            if (node.containKeys(curLetter)) {
                node = node.get(curLetter);
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */