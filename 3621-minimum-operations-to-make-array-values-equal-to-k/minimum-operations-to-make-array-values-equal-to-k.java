class Solution {
    public int minOperations(int[] nums, int k) {
        int c=0;
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++){
           if(nums[i]>k)hs.add(nums[i]);
            else if(nums[i]<k)return -1;
        }
        return hs.size();
    }
}