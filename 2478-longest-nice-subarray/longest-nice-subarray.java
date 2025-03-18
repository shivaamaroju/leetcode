class Solution {
    public int longestNiceSubarray(int[] nums) {
        int pre=0,max=1,left=0,c=0;
        for(int i=0;i<nums.length;i++){
            while((pre&nums[i])!=0){
                pre^=nums[left];
                left++;
                c--;
            }
            pre|=nums[i];
            c++;
            max=Math.max(max,c);
        }
        return max;
    }
}