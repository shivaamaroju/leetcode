class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Tire obj = new Tire();
        for (String word : wordDict) {
            obj.insert(word);
        }

        Boolean[] dp = new Boolean[s.length()];
        return obj.search(s, 0, dp);
    }
}

class Node {
    Node[] a = new Node[26];
    boolean ew = false;
}

class Tire {
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

    public boolean search(String s, int idx, Boolean[] dp) {
        if (idx == s.length()) return true;
        if (dp[idx] != null) return dp[idx];

        Node temp = root;
        for (int i = idx; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            if (temp.a[charIdx] == null) break;

            temp = temp.a[charIdx];
            if (temp.ew && search(s, i + 1, dp)) {
                dp[idx] = true;
                return true;
            }
        }

        dp[idx] = false;
        return false;
    }
}
