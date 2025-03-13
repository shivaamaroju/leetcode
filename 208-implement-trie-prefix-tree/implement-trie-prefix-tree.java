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
}

class TNode{
    boolean ew=false;
    TNode a[]=new TNode[26];
}