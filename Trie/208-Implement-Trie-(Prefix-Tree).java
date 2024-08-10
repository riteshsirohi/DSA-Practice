class Trie {

    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;

        TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[26];  // Each node has 26 children, one for each letter of the alphabet
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode crawler = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (crawler.children[idx] == null) {
                crawler.children[idx] = new TrieNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode crawler = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];
        }
        return crawler != null && crawler.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode crawler = root;

        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];
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
