class Solution {
    public boolean canJump(int[] nums) {
  HashMap<Integer,Boolean> mp=new HashMap<>();
    return helper(nums,0,mp);
    }
    public boolean helper(int a[],int idx,HashMap<Integer,Boolean> mp){
        if(idx>=a.length-1)return true;
        if(mp.containsKey(idx))return mp.get(idx);
        for(int i=1;i<=a[idx];i++){
            int newjump=idx+i;
boolean found=helper(a,newjump,mp);
if(found){
    mp.put(newjump,found);
    return mp.get(newjump);
}
 
        }
     mp.put(idx,false);
    return mp.get(idx);
    }
}