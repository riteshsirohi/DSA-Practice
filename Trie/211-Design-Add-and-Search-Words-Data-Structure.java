class WordDictionary {

    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;

        TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode crawler = root;  // Start from the root

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
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
        return searchInNode(word, crawler);
    }

    private boolean searchInNode(String word, TrieNode crawler) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '.') {
                for (TrieNode child : crawler.children) {
                    if (child != null && searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = ch - 'a';
                if (crawler.children[idx] == null) {
                    return false;
                }
                crawler = crawler.children[idx];
            }
        }
        return crawler.isEndOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
