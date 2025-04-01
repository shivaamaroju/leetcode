import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int case1 = robHelper(nums, 0, nums.length - 2);
        int case2 = robHelper(nums, 1, nums.length - 1);

        return Math.max(case1, case2);
    }

    public int robHelper(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robLinear(nums, start, end, dp);
    }

    public int robLinear(int[] nums, int i, int end, int[] dp) {
        if (i > end) return 0;
        if (dp[i] != -1) return dp[i];

        int take = nums[i] + robLinear(nums, i + 2, end, dp);
        int skip = robLinear(nums, i + 1, end, dp);

        dp[i] = Math.max(take, skip);
        return dp[i];
    }
}
