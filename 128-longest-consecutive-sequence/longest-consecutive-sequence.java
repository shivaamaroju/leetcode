class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
    Arrays.sort(nums);
    int last=Integer.MIN_VALUE;
    int cur=0,l=1;
    for(int i=0;i<nums.length;i++){
        if(last==nums[i])continue;
        if(last+1==nums[i]){
            cur++;
            last=nums[i];
            l=Math.max(l,cur);
        }
        else{
            cur=1;
            last=nums[i];
        }
    }
    return l;
    }
}