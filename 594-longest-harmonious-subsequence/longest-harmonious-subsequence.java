class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        int max=0;
        for(var s:mp.keySet()){
            if(mp.containsKey(s+1)){
                max=Math.max(max,mp.get(s)+mp.get(s+1));
            }
        }
        return max;
    }
}