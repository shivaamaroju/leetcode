class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie obj = new Trie();
        for (var s : arr1) {
            obj.insert(s + "");
        }

        int max = 0;
        for (var s : arr2) {
            max = Math.max(max, obj.search(s + ""));
        }
        return max;
    }
}

class Trie {
    TNode root = new TNode();

    public void insert(String word) {
        TNode temp = root;
        for (char ch : word.toCharArray()) {
            int indx = ch - '0';
            if (temp.a[indx] == null) {
                temp.a[indx] = new TNode();
            }
            temp = temp.a[indx];
        }
        temp.ew = true;
    }

    public int search(String word) {
        TNode temp = root;
        int c = 0;
        for (char ch : word.toCharArray()) {
            int idx = ch - '0';
            if (temp.a[idx] == null) return c;
            temp = temp.a[idx];
            c++;
        }
        return c;
    }
}

class TNode {
    boolean ew = false;
    TNode[] a = new TNode[10]; // fixed: digits 0-9
}
