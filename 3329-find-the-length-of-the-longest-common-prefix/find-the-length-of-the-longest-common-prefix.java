class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie obj=new Trie();
       for(var s:arr1){
obj.insert(s+"");
       } 
       int max=0;
       for(var s:arr2){
       max=Math.max(max, obj.search(s+""));
       }
       return max;
    }
}
class Trie {
TNode root=new TNode();
    public Trie() {
        
    }
    
    public void insert(String word) {
     TNode temp=root;
        for(char ch:word.toCharArray()){
            int indx=(int)ch-'0';
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
    
    public int  search(String word) {
TNode temp=root;
int c=0;
for(char ch:word.toCharArray()){
int idx=(int)ch-'0';
if(temp.a[idx]==null)return c;
temp=temp.a[idx];
c++;
}

        return c;
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
    TNode a[]=new TNode[10];
}