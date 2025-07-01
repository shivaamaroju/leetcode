class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        HashSet<Long> hs=new HashSet<>();
        pq.add(1L);
        hs.add(1L);
        long x[]={2,3,5};
        long ans=1;
        for(int i=1;i<=n;i++){
             ans=pq.remove();
            for(var s:x){
                long next=ans*s;
                if(!hs.contains(next)){

                    hs.add((long)next);
                    pq.add((long)next);
                }
            }
        }
        return (int)ans;
    }
}