class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> l=new ArrayList<>();
        Trie obj=new Trie();
        for(var s:products){
            obj.insert(s);
        }
        String t="";

        for(int i=0;i<searchWord.length();i++){
            t+=searchWord.charAt(i);
            List<String> ll=obj.find(t);
            l.add(ll);
        }
        return l;
    }
}
class Trie {
TNode root=new TNode();
    public Trie() {
        
    }
    
    public void insert(String word) {
     TNode temp=root;
        for(char ch:word.toCharArray()){
            int indx=(int)ch-'a';
            if(temp.a[indx]==null){
            TNode nn=new TNode();
            temp.a[indx]=nn;
            temp=nn;    
            }
            else{
                temp=temp.a[indx];
            }
        }
        temp.ew=true;
    }
    
    public boolean search(String word) {
TNode temp=root;
for(char ch:word.toCharArray()){
int idx=(int)ch-'a';
if(temp.a[idx]==null)return false;
temp=temp.a[idx];
}
if(temp.ew)return true;

        return false;
    }
    
    public boolean startsWith(String prefix) {
        TNode temp=root;
        for(char ch:prefix.toCharArray()){
            int idx=(int)ch-'a';
            if(temp.a[idx]==null)return false;
            temp=temp.a[idx];
        }
        return true;
    }
  public List<String> find(String prefix) {
    List<String> result = new ArrayList<>();
    TNode temp = root;

    for (int i = 0; i < prefix.length(); i++) {
        int idx = prefix.charAt(i) - 'a';
        if (temp.a[idx] == null) return result; 
        temp = temp.a[idx];
    }

    dfs(temp, prefix, result);
    return result;
}

private void dfs(TNode node, String path, List<String> result) {
    if (result.size() == 3) return;

    if (node.ew) result.add(path);

    for (int i = 0; i < 26; i++) {
        if (node.a[i] != null) {
            dfs(node.a[i], path + (char) ('a' + i), result);
        }
    }
}

}

class TNode{
    boolean ew=false;
    TNode a[]=new TNode[26];
}