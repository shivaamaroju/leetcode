class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(nums.length==1)return 0;
        int min=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int st=0;
        for(int i=0;i<nums.length;i++){
          if(i>=k-1){
min=Math.min(min,nums[i]-nums[st]);
st++;
          }
        }
        return min;
        
            }
}