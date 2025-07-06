class FindSumPairs {
TreeMap<Integer,Integer> mp=new TreeMap<>();
TreeMap<Integer,Integer> mp2=new TreeMap<>();

int a[],b[];
    public FindSumPairs(int[] nums1, int[] nums2) {
        a=nums1;
        b=nums2;
        for(var s:nums1){
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        for(var s:nums2){
            mp2.put(s,mp2.getOrDefault(s,0)+1);
        }
    }
    
    public void add(int index, int val) {
         int  t=b[index];
         b[index]+=val;
         int c=mp2.get(t);
         if(c==1){
            mp2.remove(t);
         }
         else{
            mp2.put(t,mp2.getOrDefault(t,0)-1);
         }
                    mp2.put(b[index],mp2.getOrDefault(b[index],0)+1); 
  
    }
    
    public int count(int tot) {
        int c=0;
        for(var s:mp.entrySet()){
       int val=s.getKey();
       if(val>tot)break;
       int t=tot-val;
       if(mp2.containsKey(t))c+=mp.get(val)*mp2.get(t);
        }
    return c;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */