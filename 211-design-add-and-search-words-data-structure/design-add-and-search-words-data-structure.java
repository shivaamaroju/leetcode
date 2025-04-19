class tire{
 TNode root=new TNode();
 public void insert(String word){
    TNode temp=root;
    for(char ch:word.toCharArray()){
        int indx=(int)ch-'a';
        if(temp.a[indx]==null){
            TNode nn=new TNode();
            temp.a[indx]=nn;
            temp=nn;
        }
        else temp=temp.a[indx];
    }
    temp.ew=true;
 }
 public boolean search(String word){
return dfs(word,0,root);
}
public boolean dfs(String word, int idx, TNode root) {
    if (root == null) return false;
    if (idx == word.length()) return root.ew;
    
    char ch = word.charAt(idx);
    
    if (ch == '.') {
        for (int i = 0; i < 26; i++) {
            if (root.a[i] != null && dfs(word, idx + 1, root.a[i])) {
                return true;
            }
        }
        return false;
    } else {
        int x = ch - 'a';
        if (root.a[x] == null) return false;
        return dfs(word, idx + 1, root.a[x]);
    }
}
}
class TNode{
    boolean ew=false;
    TNode a[]=new TNode[26];
}
class WordDictionary {
    tire obj=new tire();

    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        obj.insert(word);
    }
    
    public boolean search(String word) {
        return obj.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */