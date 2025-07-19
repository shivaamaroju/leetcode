import java.util.*;

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Trie trie = new Trie();
        String longest = "";

        for (String word : words) {
            if (trie.insert(word)) {
                if (word.length() > longest.length()) {
                    longest = word;
                }
            }
        }
        return longest;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}

class Trie {
    TrieNode root = new TrieNode();

    public boolean insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
            if (i != word.length() - 1 && !node.isEnd) {
                return false;
            }
        }
        node.isEnd = true;
        return true;
    }
}
