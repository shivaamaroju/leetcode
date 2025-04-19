class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie obj = new Trie();
        for (String s : dictionary) {
            obj.insert(s);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(obj.search(word)).append(" ");
        }

        return result.toString().trim();
    }
}

class Node {
    Node[] a = new Node[26];
    boolean ew = false;
}

class Trie {
    Node root = new Node();

    public void insert(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (temp.a[idx] == null) {
                temp.a[idx] = new Node();
            }
            temp = temp.a[idx];
        }
        temp.ew = true;
    }

    public String search(String word) {
        StringBuilder t = new StringBuilder();
        Node temp = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (temp.a[idx] == null) return word;
            t.append(ch);
            temp = temp.a[idx];
            if (temp.ew) return t.toString();
        }
        return word;
    }
}
