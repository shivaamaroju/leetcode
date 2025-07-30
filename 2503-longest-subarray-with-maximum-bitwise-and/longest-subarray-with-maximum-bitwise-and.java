class Solution {
    public int longestSubarray(int[] nums) {
        int max=0;
        for(int s:nums){
            max=Math.max(s,max);
        }
        int maxc=0,cur=0;
        for(int s:nums){
            if(max==s){
                cur++;
                maxc=Math.max(maxc,cur);
            }
            else cur=0;
        }
        return maxc;



    }
}