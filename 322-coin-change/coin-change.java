class Solution {
    public int coinChange(int[] coins, int t) {
        if(t==0)return 0;
        int c=0;
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer>hs=new HashSet<>();
        q.add(t);
        hs.add(t);
        while(q.size()>0){
            int size=q.size();
c++;
            for(int i=0;i<size;i++){
int tt=q.remove();
for(var s:coins){
    int y=tt-s;
    if(y==0)return c;
    if(y>0&&!hs.contains(y)){
        q.add(y);
        hs.add(y);}
}}
        }
        return -1;
    }
}