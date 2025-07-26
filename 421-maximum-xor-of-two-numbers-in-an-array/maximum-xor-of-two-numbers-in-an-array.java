class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie obj=new Trie();
        for(var s:nums){
            obj.insert(s);
        }
        int max=0;
        for(var s:nums){
            max=Math.max(max,obj.maxor(s));
        }
    
    return max;
    }}
class Node{
    Node a[]=new Node[2];
}
class Trie{
 Node root=new Node();
 public void insert(int n){
    Node temp=root;
    for(int i=31;i>=0;i--){
        int x=(n>>i)&1;
        if(temp.a[x]==null){
            temp.a[x]=new Node();
        }
        temp=temp.a[x];
    }
 } 
 public int maxor(int n){
    Node temp=root;
    int max=0;
    for(int i=31;i>=0;i--){
      int x=(n>>i)&1;
      int y=1-x;
      if(temp.a[y]!=null){
temp=temp.a[y];
max|=(1<<i);
      }
      else if(temp.a[x]!=null){
temp=temp.a[x];
      }
      else return max;

    }
    return max;
 }  
}