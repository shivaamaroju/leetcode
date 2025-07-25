class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> hs=new HashSet<>();
        Arrays.sort(nums);
        int sum=nums[nums.length-1];
        hs.add(nums[nums.length-1]);
        for(int i=nums.length-2;i>=0;i--){
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
                if(sum+nums[i]>sum){
                    sum+=nums[i];
                }
            }
        }
        return sum;
    }
}