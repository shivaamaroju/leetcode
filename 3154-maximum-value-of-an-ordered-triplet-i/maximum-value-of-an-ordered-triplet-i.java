class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0;
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long ans = (long)(nums[i] - nums[j]) * nums[k];
                    max = Math.max(max, ans);
                }
            }
        }
        return max;
    }
}
