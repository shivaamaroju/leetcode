import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;  // No houses
        if (nums.length == 1) return nums[0];  // Only one house

        // Case 1: Rob houses from index 0 to n-2 (excluding the last house)
        int case1 = robHelper(nums, 0, nums.length - 2);

        // Case 2: Rob houses from index 1 to n-1 (excluding the first house)
        int case2 = robHelper(nums, 1, nums.length - 1);

        // Return the maximum of both cases
        return Math.max(case1, case2);
    }

    // Helper function to calculate the maximum amount of money we can rob from a linear set of houses
    public int robHelper(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robLinear(nums, start, end, dp);
    }

    // Recursively calculate the maximum points from the current index
    public int robLinear(int[] nums, int i, int end, int[] dp) {
        // Base case: Out of bounds
        if (i > end) return 0;

        // Return cached result if it exists
        if (dp[i] != -1) return dp[i];

        // Option 1: Rob the current house and move to i+2
        int take = nums[i] + robLinear(nums, i + 2, end, dp);

        // Option 2: Skip the current house and move to i+1
        int skip = robLinear(nums, i + 1, end, dp);

        // Store the result and return the maximum of both choices
        dp[i] = Math.max(take, skip);
        return dp[i];
    }
}
