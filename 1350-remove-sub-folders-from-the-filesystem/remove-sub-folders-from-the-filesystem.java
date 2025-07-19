class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie obj=new Trie();
        Arrays.sort(folder);
        List<String> l=new ArrayList<>();
        for(var s:folder){
            if(!obj.insert(s)){
l.add(s);
            }
        }
        return l;
    }
}

class Node {
    HashMap<String, Node> mp = new HashMap<>();
    boolean ew = false;
}

class Trie {
    Node root = new Node();

    public boolean insert(String s) {
        String a[] = s.split("/");
        Node temp = root;
        for (int i = 0; i < a.length; i++) {
            if (temp.ew)
                return true;
            temp.mp.putIfAbsent(a[i], new Node());
            temp = temp.mp.get(a[i]);
        }
        temp.ew = true;
        return false;
    }
}