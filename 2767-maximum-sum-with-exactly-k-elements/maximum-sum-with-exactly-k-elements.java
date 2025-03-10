class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int ele=nums[nums.length-1];
        int sum=0;
        while(k-->0){
            sum+=ele;
            ele++;
        }
        return sum;
    }
}