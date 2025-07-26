class Solution {
    public int maximumStrongPairXor(int[] nums) {
       Arrays.sort(nums); 
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            Trie trie = new Trie();
            int a = nums[i];

            for (int j = 0; j < nums.length; j++) {
                int b = nums[j];
                if (Math.abs(a - b) <= Math.min(a, b)) {
                    trie.insert(b); 
                }
            }

            max = Math.max(max, trie.maxor(a));
        }

        return max;
    }
}
class Node{
    Node a[]=new Node[2];
    boolean ew =false;
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
        temp.ew=true;
    }
    public int maxor(int n){
        int max=0;
        Node temp=root;
        int no=0;
        for(int i=31;i>=0;i--){
           int x=(n>>i)&1;
           int y=1-x;
           if(temp.a[y]==null){
temp=temp.a[x];
           }
           else if(temp.a[y]!=null){
temp=temp.a[y];
no|=(1<<i);
           }
           else{
            return no;
           }

        }
        return no;
    }
}